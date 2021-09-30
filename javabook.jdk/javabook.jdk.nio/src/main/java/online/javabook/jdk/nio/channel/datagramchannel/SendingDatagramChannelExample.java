package online.javabook.jdk.nio.channel.datagramchannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Java NIO DatagramChannel是可以发送和接收UDP数据包的通道。UDP是一种无连接的网络协议，
 */
public class SendingDatagramChannelExample {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel = DatagramChannel.open();

        String newData = "test udp message" + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();

        int bytesSent = channel.send(buf, new InetSocketAddress("localhost", 9999));
    }
}
