package online.javabook.jdk.nio.zerocopy;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicLong;

public class NioSocketServer {
    public static void main(String[] args) throws Exception {

        // create serverSocketChannel
        InetSocketAddress address = new InetSocketAddress(7001);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // create serverSocket
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(address);
        System.out.println("启动NIO服务器:" + serverSocket);

        // create buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);

        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            System.out.println(">>>accept socket channel:" + socketChannel);

            AtomicLong totalBytesCount = new AtomicLong();
            while (true) {
                try {
                    int readBytesCount = socketChannel.read(byteBuffer);
                    if(-1 == readBytesCount) {
                        break;
                    }else{
                        totalBytesCount.addAndGet(readBytesCount);
                        System.out.println("总接收字节数:" + totalBytesCount + ";当前接收字节数:" + readBytesCount);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    break;
                }

                //倒带 position = 0, mark 作废
                byteBuffer.rewind();
            }
        }
    }
}
