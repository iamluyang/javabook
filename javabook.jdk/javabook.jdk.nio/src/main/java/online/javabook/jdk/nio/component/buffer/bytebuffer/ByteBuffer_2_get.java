package online.javabook.jdk.nio.component.buffer.bytebuffer;

import java.nio.ByteBuffer;

public class ByteBuffer_2_get extends ByteBufferBase {
    public static void main(String[] args) {

        // 创建一个容量为capacity的ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(18);
        logBuffer(" ", buffer);

        // put
        // a - 2byte
        buffer.putChar('a');
        logBuffer("a", buffer);

        // 1.2 - 8byte
        buffer.putDouble(1.2);
        logBuffer("1.2", buffer);

        // 1000L - 8byte
        buffer.putLong(1000L);
        logBuffer("1000L", buffer);;

        // write/read
        System.out.println("--------------------");
        buffer.flip();
        logBuffer("flip", buffer);
        System.out.println("--------------------");


        // get
        System.out.println(buffer.getChar());
        logBuffer("getChar", buffer);

        System.out.println(buffer.getDouble());
        logBuffer("getDouble", buffer);

        System.out.println(buffer.getLong());
        logBuffer("getLong", buffer);
    }
}
