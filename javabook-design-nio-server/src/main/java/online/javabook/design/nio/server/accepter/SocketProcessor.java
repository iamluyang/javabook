package online.javabook.design.nio.server.accepter;

import online.javabook.design.nio.server.message.Message;
import online.javabook.design.nio.server.message.MessageBuffer;
import online.javabook.design.nio.server.message.MessageWriter;
import online.javabook.design.nio.server.message.processor.IMessageProcessor;
import online.javabook.design.nio.server.write.proxy.WriteProxy;
import online.javabook.design.nio.server.message.reader.IMessageReaderFactory;
import online.javabook.design.nio.server.session.Session;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.*;

public class SocketProcessor implements Runnable {

    private Queue<Session> inboundSocketQueue = null;

    private MessageBuffer readMessageBuffer = null; //todo   Not used now - but perhaps will be later - to check for space in the buffer before reading from sockets
    private MessageBuffer writeMessageBuffer = null; //todo   Not used now - but perhaps will be later - to check for space in the buffer before reading from sockets (space for more to write?)

    private IMessageReaderFactory messageReaderFactory = null;

    private Queue<Message> outboundMessageQueue = new LinkedList<>(); //todo use a better / faster queue.

    private Map<Long, Session> socketMap = new HashMap<>();

    private ByteBuffer readByteBuffer = ByteBuffer.allocate(1024 * 1024);
    private ByteBuffer writeByteBuffer = ByteBuffer.allocate(1024 * 1024);
    private Selector readSelector = null;
    private Selector writeSelector = null;

    private IMessageProcessor messageProcessor = null;
    private WriteProxy writeProxy = null;

    private long nextSocketId = 16 * 1024; //start incoming socket ids from 16K - reserve bottom ids for pre-defined sockets (servers).

    private Set<Session> emptyToNonEmptySockets = new HashSet<>();
    private Set<Session> nonEmptyToEmptySockets = new HashSet<>();


    public SocketProcessor(Queue<Session> inboundSocketQueue, MessageBuffer readMessageBuffer, MessageBuffer writeMessageBuffer, IMessageReaderFactory messageReaderFactory, IMessageProcessor messageProcessor) throws IOException {
        this.inboundSocketQueue = inboundSocketQueue;

        this.readMessageBuffer = readMessageBuffer;
        this.writeMessageBuffer = writeMessageBuffer;
        this.writeProxy = new WriteProxy(writeMessageBuffer, this.outboundMessageQueue);

        this.messageReaderFactory = messageReaderFactory;

        this.messageProcessor = messageProcessor;

        this.readSelector = Selector.open();
        this.writeSelector = Selector.open();
    }

    public void run() {
        while (true) {
            try {
                executeCycle();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void executeCycle() throws IOException {
        takeNewSockets();
        readFromSockets();
        writeToSockets();
    }


    public void takeNewSockets() throws IOException {
        Session newSocket = this.inboundSocketQueue.poll();

        while (newSocket != null) {
            newSocket.socketId = this.nextSocketId++;
            newSocket.socketChannel.configureBlocking(false);

            newSocket.messageReader = this.messageReaderFactory.createMessageReader();
            newSocket.messageReader.init(this.readMessageBuffer);

            newSocket.messageWriter = new MessageWriter();

            this.socketMap.put(newSocket.socketId, newSocket);

            SelectionKey key = newSocket.socketChannel.register(this.readSelector, SelectionKey.OP_READ);
            key.attach(newSocket);

            newSocket = this.inboundSocketQueue.poll();
        }
    }


    public void readFromSockets() throws IOException {
        int readReady = this.readSelector.selectNow();

        if (readReady > 0) {
            Set<SelectionKey> selectedKeys = this.readSelector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                readFromSocket(key);

                keyIterator.remove();
            }
            selectedKeys.clear();
        }
    }

    private void readFromSocket(SelectionKey key) throws IOException {
        Session socket = (Session) key.attachment();
        socket.messageReader.read(socket, this.readByteBuffer);

        List<Message> fullMessages = socket.messageReader.getMessages();
        if (fullMessages.size() > 0) {
            for (Message message : fullMessages) {
                message.socketId = socket.socketId;
                this.messageProcessor.process(message, this.writeProxy);  //the message processor will eventually push outgoing messages into an IMessageWriter for this socket.
            }
            fullMessages.clear();
        }

        if (socket.endOfStreamReached) {
            System.out.println("Socket closed: " + socket.socketId);
            this.socketMap.remove(socket.socketId);
            key.attach(null);
            key.cancel();
            key.channel().close();
        }
    }


    public void writeToSockets() throws IOException {

        // Take all new messages from outboundMessageQueue
        takeNewOutboundMessages();

        // Cancel all sockets which have no more data to write.
        cancelEmptySockets();

        // Register all sockets that *have* data and which are not yet registered.
        registerNonEmptySockets();

        // Select from the Selector.
        int writeReady = this.writeSelector.selectNow();

        if (writeReady > 0) {
            Set<SelectionKey> selectionKeys = this.writeSelector.selectedKeys();
            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();

                Session socket = (Session) key.attachment();

                socket.messageWriter.write(socket, this.writeByteBuffer);

                if (socket.messageWriter.isEmpty()) {
                    this.nonEmptyToEmptySockets.add(socket);
                }

                keyIterator.remove();
            }

            selectionKeys.clear();

        }
    }

    private void registerNonEmptySockets() throws ClosedChannelException {
        for (Session socket : emptyToNonEmptySockets) {
            socket.socketChannel.register(this.writeSelector, SelectionKey.OP_WRITE, socket);
        }
        emptyToNonEmptySockets.clear();
    }

    private void cancelEmptySockets() {
        for (Session socket : nonEmptyToEmptySockets) {
            SelectionKey key = socket.socketChannel.keyFor(this.writeSelector);

            key.cancel();
        }
        nonEmptyToEmptySockets.clear();
    }

    private void takeNewOutboundMessages() {
        Message outMessage = this.outboundMessageQueue.poll();
        while (outMessage != null) {
            Session socket = this.socketMap.get(outMessage.socketId);

            if (socket != null) {
                MessageWriter messageWriter = socket.messageWriter;
                if (messageWriter.isEmpty()) {
                    messageWriter.enqueue(outMessage);
                    nonEmptyToEmptySockets.remove(socket);
                    emptyToNonEmptySockets.add(socket);    //not necessary if removed from nonEmptyToEmptySockets in prev. statement.
                } else {
                    messageWriter.enqueue(outMessage);
                }
            }

            outMessage = this.outboundMessageQueue.poll();
        }
    }

}