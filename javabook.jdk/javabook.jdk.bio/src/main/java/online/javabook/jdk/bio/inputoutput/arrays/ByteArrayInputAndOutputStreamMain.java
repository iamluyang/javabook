package online.javabook.jdk.bio.inputoutput.arrays;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputAndOutputStreamMain {

    public static void main(String[] args) throws IOException {

        // data
        byte[] data = "This is text-这是一个文本".getBytes("UTF-8");

        // byteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(data);
        byte[] bytes = byteArrayOutputStream.toByteArray();
        System.out.println(new String(bytes));

        // byteArrayInputStream
        InputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        //read first byte
        int oneByte = byteArrayInputStream.read();
        while (oneByte != -1) {
            System.out.print((char) oneByte);

            //  next byte
            oneByte = byteArrayInputStream.read();
        }
    }
}
