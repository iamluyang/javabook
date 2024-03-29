package online.javabook.jdk.nio.channel.transfers;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 在 Java NIO 中，您可以将数据直接从一个通道传输到另一个通道，如果其中一个通道是FileChannel.
 * 该FileChannel班有一个transferTo() 和 transferFrom()它为您完成此方法。
 */
public class ChannelTransferToExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("./javabook-io-nio/testdata/from.txt", "rw");
        FileChannel      fromChannel = fromFile.getChannel();

        RandomAccessFile toFile = new RandomAccessFile("./javabook-io-nio/testdata/to.txt", "rw");
        FileChannel toChannel = toFile.getChannel();

        long position = 0;
        long count    = fromChannel.size();

        fromChannel.transferTo(position, count, toChannel);
    }
}
