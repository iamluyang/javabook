package online.javabook.io.nio.channel.socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelBlockingModeExample {

    public static void main(String[] args) throws IOException {

        // 打开一个SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9999));

        // 从SocketChannel读取
        ByteBuffer readBuffer = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(readBuffer);

        // 写入SocketChannel
        String newData = "test" + System.currentTimeMillis();

        ByteBuffer writeBuffer = ByteBuffer.allocate(48);
        writeBuffer.clear();
        writeBuffer.put(newData.getBytes());

        writeBuffer.flip();

        while(writeBuffer.hasRemaining()) {
            socketChannel.write(writeBuffer);
        }

        // 关闭一个SocketChannel
        socketChannel.close();
    }
}
