package online.javabook.design.nio.server.main;

import online.javabook.design.nio.server.accepter.SocketAccepter;
import online.javabook.design.nio.server.accepter.SocketProcessor;
import online.javabook.design.nio.server.message.MessageBuffer;
import online.javabook.design.nio.server.message.processor.IMessageProcessor;
import online.javabook.design.nio.server.message.reader.IMessageReaderFactory;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Server {

    private int port = 0;

    private SocketAccepter socketAccepter = null;

    private SocketProcessor socketProcessor = null;

    private IMessageReaderFactory messageReaderFactory;

    private IMessageProcessor messageProcessor;

    /**
     *
     * @param port
     * @param messageReaderFactory
     * @param messageProcessor
     */
    public Server(int port, IMessageReaderFactory messageReaderFactory, IMessageProcessor messageProcessor) {
        this.port = port;
        this.messageReaderFactory = messageReaderFactory;
        this.messageProcessor = messageProcessor;
    }

    public void start() throws IOException {

        // socketAccepter
        Queue socketQueue = new ArrayBlockingQueue(1024);
        this.socketAccepter = new SocketAccepter(port, socketQueue);

        // socketProcessor
        MessageBuffer readBuffer = new MessageBuffer();
        MessageBuffer writeBuffer = new MessageBuffer();
        this.socketProcessor = new SocketProcessor(socketQueue, readBuffer, writeBuffer, this.messageReaderFactory, this.messageProcessor);

        // accepterThread/processorThread
        Thread accepterThread = new Thread(this.socketAccepter);
        Thread processorThread = new Thread(this.socketProcessor);

        accepterThread.start();
        processorThread.start();
    }

}
