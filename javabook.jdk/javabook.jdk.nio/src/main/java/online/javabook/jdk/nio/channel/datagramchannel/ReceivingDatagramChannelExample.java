package online.javabook.jdk.nio.channel.datagramchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Java NIO DatagramChannel是可以发送和接收UDP数据包的通道。UDP是一种无连接的网络协议，
 */
public class ReceivingDatagramChannelExample {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));

        // Receiving Data
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        channel.receive(buf);

        //
        System.out.println(buf);
    }
}
