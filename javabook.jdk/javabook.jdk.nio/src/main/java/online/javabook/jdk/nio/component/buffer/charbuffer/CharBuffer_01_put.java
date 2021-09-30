package online.javabook.jdk.nio.component.buffer.charbuffer;

import java.nio.CharBuffer;

public class CharBuffer_01_put extends CharBufferBase {
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

        buffer.put("e");
        logBuffer("d", buffer);

        buffer.put("f");
        logBuffer("f", buffer);

        //-----------------
        buffer.put("g");
        logBuffer("g", buffer);

        buffer.put("h");
        logBuffer("h", buffer);

        buffer.put("i");
        logBuffer("i", buffer);

        buffer.put("j");
        logBuffer("j", buffer);

        buffer.put("k");
        logBuffer("k", buffer);

        buffer.put("l");
        logBuffer("l", buffer);

        //----------------- buffer overflow
        //charBuffer.put("m");
    }
}
