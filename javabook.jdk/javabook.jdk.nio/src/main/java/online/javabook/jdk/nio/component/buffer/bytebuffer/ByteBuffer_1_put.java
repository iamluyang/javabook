package online.javabook.jdk.nio.component.buffer.bytebuffer;

import java.nio.ByteBuffer;

/**
 * NIO是面向缓冲区或者面向块编程的。
 * 数据读取到一个它稍后处理的缓冲区，需要时可在缓冲区中前后移动，
 * 这就增加了处理过程中的灵活性，使用它可以提供非阻塞式的高伸缩性网络编程
 */
public class ByteBuffer_1_put extends ByteBufferBase {
    public static void main(String[] args) {

        // 创建一个容量为capacity的ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(18);
        logBuffer("allocate", buffer);

        // a - 2byte
        buffer.putChar('a');
        logBuffer("a", buffer);

        // 1.2 - 8byte
        buffer.putDouble(1.2);
        logBuffer("1.2", buffer);

        // 1000L - 8byte
        buffer.putLong(1000L);
        logBuffer("1000L", buffer);
    }
}
