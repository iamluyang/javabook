package online.javabook.jdk.nio.component.buffer.charbuffer;

import java.nio.CharBuffer;

public class CharBuffer_11_asReadOnlyBuffer extends CharBufferBase {
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

        // asReadOnlyBuffer
        System.out.println("buffer.getClass():"+buffer.getClass());
        CharBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        System.out.println("readOnlyBuffer.getClass():"+readOnlyBuffer.getClass());

        logBuffer("\nasReadOnlyBuffer", buffer);

        // write
        readOnlyBuffer.put("x");
    }
}
