package online.javabook.io.nio.channel.serversocketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelBlockingModeExample {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(9999));

        try {
            while(true){
                // 监听传入的连接
                SocketChannel socketChannel = serverSocketChannel.accept();

                //do something with socketChannel...
            }
        }catch (Exception e) {
            // 关闭ServerSocketChannel
            serverSocketChannel.close();
        }
    }
}
