package online.javabook.jdk.nio.component.buffer.charbuffer;

import java.nio.CharBuffer;

public class CharBufferBase {

    public static String logBuffer(String c, CharBuffer buffer) {
        StringBuilder sb = new StringBuilder();
        sb.append(c + ":\n");
        sb.append("buffer{" + "");
        sb.append("position:" + buffer.position() + ";");
        sb.append("limit:" + buffer.limit() + ";");
        sb.append("capacity:" + buffer.capacity() + ";");
        sb.append("remaining:" + buffer.remaining() + ";");
        sb.append("}\n");
        System.out.println(sb);
        return sb.toString();
    }
}
