package online.javabook.io.bio.inputoutput.arrays;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class WritingToArraysViaInputStreamExample {

    public static void main(String[] args) throws IOException {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write("This text is converted to bytes".getBytes("UTF-8"));
        byte[] bytes = output.toByteArray();
    }
}
