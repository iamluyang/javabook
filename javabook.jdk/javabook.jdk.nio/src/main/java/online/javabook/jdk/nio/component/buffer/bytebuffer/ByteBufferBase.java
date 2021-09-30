package online.javabook.jdk.nio.component.buffer.bytebuffer;

import java.nio.ByteBuffer;

public class ByteBufferBase {

    public static String logBuffer(String c, ByteBuffer buffer) {
        StringBuilder sb = new StringBuilder();
        sb.append(c + "\n");
        sb.append("[");
        sb.append("buffer:" + buffer);
        sb.append("\tremaining:" + buffer.remaining());
        sb.append("]\n");
        System.out.println(sb);
        return sb.toString();
    }
}
