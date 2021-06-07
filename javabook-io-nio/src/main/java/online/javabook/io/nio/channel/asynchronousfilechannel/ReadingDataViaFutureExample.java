package online.javabook.io.nio.channel.asynchronousfilechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 在Java 7中，它AsynchronousFileChannel已添加到Java NIO。
 * 这样AsynchronousFileChannel 就可以从文件中异步读取数据，或将数据异步写入文件。
 */
public class ReadingDataViaFutureExample {

    public static void main(String[] args) throws IOException {

        // 创建一个AsynchronousFileChannel
        Path path = Paths.get("./javabook-io-nio/testdata/ReadingDataViaFutureExample.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        // 通过Future读取数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        java.util.concurrent.Future<Integer> operation = fileChannel.read(buffer, position);

        while(!operation.isDone());

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();
    }
}
