package online.javabook.jdk.nio.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Java NIO Pipe是两个线程之间的单向数据连接。APipe 具有源通道和宿通道。您将数据写入接收器通道。然后可以从源通道读取此数据。
 */
public class PipeExample {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();

        // Writing to a Pipe
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "1234567890";

        ByteBuffer writeBuffer = ByteBuffer.allocate(48);
        writeBuffer.clear();
        writeBuffer.put(newData.getBytes());
        System.out.println("writeBuffer:"+writeBuffer);

        writeBuffer.flip();
        while(writeBuffer.hasRemaining()) {
            sinkChannel.write(writeBuffer);
        }

        // Reading from a Pipe
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer readBuffer = ByteBuffer.allocate(48);

        int bytesRead = sourceChannel.read(readBuffer);
        System.out.println("readBuffer:"+readBuffer);
    }
}
