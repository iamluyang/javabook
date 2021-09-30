package online.javabook.jdk.nio.component.buffer.charbuffer;

import java.nio.CharBuffer;

public class CharBuffer_02_get extends CharBufferBase {
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

        buffer.put("d");
        logBuffer("d", buffer);

        //-----------------
        System.out.println(buffer.get());
        logBuffer(" ", buffer);

        System.out.println(buffer.get());
        logBuffer(" ", buffer);

        System.out.println(buffer.get());
        logBuffer(" ", buffer);
    }
}
