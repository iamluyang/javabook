package online.javabook.design.nio.server.accepter;

import online.javabook.design.nio.server.session.Session;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Queue;

public class SocketAccepter implements Runnable {

    /**
     * port
     */
    private int port = 0;

    /**
     * socketQueue
     */
    private Queue socketQueue;

    /**
     * serverSocket
     */
    private ServerSocketChannel serverSocketChannel = null;

    /**
     *
     * @param port
     * @param socketQueue
     */
    public SocketAccepter(int port, Queue socketQueue) {
        this.port = port;
        this.socketQueue = socketQueue;
    }

    @Override
    public void run() {
        try {
            this.serverSocketChannel = ServerSocketChannel.open();
            this.serverSocketChannel.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        while (true) {
            try {
                SocketChannel socketChannel = this.serverSocketChannel.accept();
                System.out.println("Socket accepted: " + socketChannel);

                //todo check if the queue can even accept more sockets.
                this.socketQueue.add(new Session(socketChannel));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}