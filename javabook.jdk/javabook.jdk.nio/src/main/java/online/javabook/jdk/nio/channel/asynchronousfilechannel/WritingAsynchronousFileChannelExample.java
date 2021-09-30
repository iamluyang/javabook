package online.javabook.jdk.nio.channel.asynchronousfilechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * 在Java 7中，它AsynchronousFileChannel已添加到Java NIO。
 * 这样AsynchronousFileChannel 就可以从文件中异步读取数据，或将数据异步写入文件。
 */
public class WritingAsynchronousFileChannelExample {

    public static void main(String[] args) throws IOException {

        // 创建一个AsynchronousFileChannel
        Path path = Paths.get("./javabook-io-nio/testdata/WritingAsynchronousFileChannelExample.txt");
        if(!Files.exists(path)){
            Files.createFile(path);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        // 通过Future写入数据
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;

        buffer.put("test data".getBytes());
        buffer.flip();

        Future<Integer> operation = fileChannel.write(buffer, position);
        buffer.clear();

        while(!operation.isDone());

        System.out.println("Write done");
    }
}
