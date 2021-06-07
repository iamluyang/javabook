package online.javabook.io.nio.channel.asynchronousfilechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 在Java 7中，它AsynchronousFileChannel已添加到Java NIO。
 * 这样AsynchronousFileChannel 就可以从文件中异步读取数据，或将数据异步写入文件。
 */
public class ReadingDataViaCompletionHandlerExample {

    public static void main(String[] args) throws IOException {

        // 创建一个AsynchronousFileChannel
        Path path = Paths.get("./javabook-io-nio/testdata/ReadingDataViaCompletionHandlerExample.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);

        // 通过CompletionHandler读取数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }
}
