package online.javabook.jdk.nio.component.channel;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel01_write {
    public static void main(String[] args) throws Exception {

        String str = "hello,NIO";

        // 创建一个输出流->channel
        String file01 = "javabook.jdk/javabook.jdk.nio/mock/channel/file01.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(file01);

        // 通过 fileOutputStream 获取对应的 FileChannel
        // 这个 fileChannel 真实类型是 FileChannelImpl
        FileChannel fileChannel = fileOutputStream.getChannel();

        // 创建一个缓冲区ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 将 str 放入 byteBuffer
        byteBuffer.put(str.getBytes());

        // 对 byteBuffer 进行 flip
        byteBuffer.flip();

        // 将byteBuffer数据写入到 fileChannel
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
