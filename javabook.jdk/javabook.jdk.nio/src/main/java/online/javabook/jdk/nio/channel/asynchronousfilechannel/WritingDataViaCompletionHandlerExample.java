package online.javabook.jdk.nio.channel.asynchronousfilechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 在Java 7中，它AsynchronousFileChannel已添加到Java NIO。
 * 这样AsynchronousFileChannel 就可以从文件中异步读取数据，或将数据异步写入文件。
 */
public class WritingDataViaCompletionHandlerExample {

    public static void main(String[] args) throws IOException {

        // 通过CompletionHandler写入数据
        Path path = Paths.get("./javabook-io-nio/testdata/WritingDataViaCompletionHandlerExample.txt");
        if(!Files.exists(path)){
            Files.createFile(path);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();

        fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("bytes written: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed");
                exc.printStackTrace();
            }
        });
    }
}
