package online.javabook.io.nio.buffer.scattergather;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO 带有内置的分散/聚集支持。分散/聚集是用于从通道读取和写入通道的概念。
 *
 * 从通道的分散读取是一种将数据读入多个缓冲区的读取操作。因此，通道将来自通道的数据“分散”到多个缓冲区中。
 *
 * 对通道的收集写入是一种将数据从多个缓冲区写入单个通道的写入操作。因此，通道将来自多个缓冲区的数据“收集”到一个通道中。
 *
 * 在您需要分别处理传输数据的各个部分的情况下，分散/收集非常有用。
 *
 * 例如，如果消息由标题和正文组成，您可以将标题和正文保存在单独的缓冲区中。这样做可以让您更轻松地分别处理标题和正文。
 */
public class ScatterGatherExample {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("./javabook-io-nio/testdata/ScatterGatherExample.txt", "rw");
        FileChannel fileChannel = file.getChannel();

        ByteBuffer header1 = ByteBuffer.allocate(2);
        ByteBuffer body1 = ByteBuffer.allocate(2);

        header1.putChar('h');
        body1.putChar('b');
        header1.flip();
        body1.flip();

        //将数据写入缓冲区
        // 缓冲区数组被传递到write()方法中，该方法按照它们在数组中遇到的顺序写入缓冲区的内容。仅写入缓冲区的位置和限制之间的数据。
        // 因此，如果缓冲区的容量为 128 字节，但仅包含 58 字节，则只有 58 字节从该缓冲区写入通道。
        // 因此，与分散读取相比，聚集写入对动态大小的消息部分工作正常。
        ByteBuffer[] bufferArray1 = { header1, body1 };
        fileChannel.write(bufferArray1);

        // ---------------------------------------------------------------------------------

        fileChannel.position(0);
        ByteBuffer header2 = ByteBuffer.allocate(2);
        ByteBuffer body2 = ByteBuffer.allocate(2);

        ByteBuffer[] bufferArray2 = { header2, body2 };

        // 该方法按照缓冲区在数组中出现的顺序从通道写入数据。一旦缓冲区已满，通道就会继续填充下一个缓冲区。
        // 分散读取在进入下一个缓冲区之前填满了一个缓冲区这一事实意味着它不适合动态大小的消息部分。
        // 换句话说，如果您有标题和正文，并且标题是固定大小（例如 128 字节），则分散读取工作正常。
        fileChannel.read(bufferArray2);
        header2.flip();
        body2.flip();

        System.out.println(header2.getChar());
        System.out.println(body2.getChar());
    }
}
