package online.javabook.jdk.nio.component.buffer.charbuffer;

import java.nio.CharBuffer;

public class CharBuffer_03_flip extends CharBufferBase {
    public static void main(String[] args) {

        // 创建一个容量为capacity的CharBuffer
        CharBuffer buffer = CharBuffer.allocate(12);
        logBuffer("allocate(12)", buffer);

        // put
        buffer.put("a");
        logBuffer("a", buffer);

        buffer.put("b");
        logBuffer("b", buffer);

        buffer.put("c");
        logBuffer("c", buffer);

        // flip
        buffer.flip();
        logBuffer("flip", buffer);
    }
}
