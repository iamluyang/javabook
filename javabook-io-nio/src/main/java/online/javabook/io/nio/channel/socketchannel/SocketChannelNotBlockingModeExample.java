package online.javabook.io.nio.channel.socketchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelNotBlockingModeExample {

    public static void main(String[] args) throws IOException {

        // 打开一个SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress("localhost", 6666));

        while(! socketChannel.finishConnect() ){
            //wait, or do something else...
        }

        // write()
        // 在非阻塞模式下，write()方法可能会在未写入任何内容的情况下返回
        // 因此，您需要write()循环调用该方法

        // read()
        // 在非阻塞模式下，该read()方法可以返回而根本不读取任何数据。
        // 因此，您需要注意return int，它告诉您读取了多少字节。

        // 关闭一个SocketChannel
        socketChannel.close();
    }
}
