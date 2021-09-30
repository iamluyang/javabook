package online.javabook.jdk.nio.component.buffer.scatter;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scattering：将数据写入到buffer时，可以采用buffer数组，依次写入[分散]
 * Gathering: 从buffer读取数据时，  可以采用buffer数组，依次读入[聚合]
 */
public class ScatteringAndGatheringServerMain {
    public static void main(String[] args) throws Exception {

        // 使用ServerSocketChannel和SocketChannel网络
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        // 绑定端口到socket并启动
        serverSocketChannel.socket().bind(inetSocketAddress);
        System.out.println("启动NIO服务端:" + serverSocketChannel);

        // 假设从客户端接收8个字节
        int messageLength = 8;

        // 创建buffer数组用于聚合读和分散写
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        // 等客户端连接(telnet)
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 循环读取客户端请求字节
        while (true) {
            int byteRead = 0;

            // 一定要读够8个字节才能结束这一轮的read操作
            while (byteRead < messageLength) {
                long readCount = socketChannel.read(byteBuffers);

                //累计读取的字节数
                byteRead += readCount;
                System.out.println("已经接收的字节数:" + byteRead);

                // 查看每个buffer的position和limit
                for (ByteBuffer buffer : byteBuffers) {
                    String s = "position=" + buffer.position() + ", limit=" + buffer.limit();
                    System.out.println(s);
                }
            }

            // 将所有的buffer进行flip
            Arrays.asList(byteBuffers).forEach(buffer -> buffer.flip());

            // 将数据读出回显到客户端
            long byteWirte = 0;
            while (byteWirte < messageLength) {
                long bytes = socketChannel.write(byteBuffers);
                byteWirte += bytes;
            }

            // 将所有的buffer进行clear
            for (ByteBuffer buffer : Arrays.asList(byteBuffers)) {
                buffer.clear();
            }

            System.out.println("byteRead=" + byteRead + ", byteWrite=" + byteWirte + ", message length=" + messageLength);
        }
    }
}
