package online.javabook.jdk.nio.component.selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args) throws Exception {

        // 创建客户端网络通道
        SocketChannel socketChannel = SocketChannel.open();

        // 设置网络通道非阻塞
        socketChannel.configureBlocking(false);

        // 创建服务器端的ip和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 9999);

        // 连接服务器
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("因为连接需要时间，客户端不会阻塞，可以做其它工作..");
            }
        }

        // ...如果连接成功，就发送数据
        String str = "hello, NIO Server";

        // Wraps a byte array into a buffer
        ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

        // 发送数据，将 buffer 数据写入 channel
        socketChannel.write(buffer);
        System.in.read();
    }
}
