package online.javabook.jdk.bio.inputoutput.file;

import org.apache.commons.io.Charsets;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class FileInputAndOutputStreamMain {
    public static void main(String[] args) throws IOException {

        String lineEnding = System.lineSeparator();
        final Charset cs = Charsets.toCharset(Charset.defaultCharset());

        // 数据
        List<String> lines = new ArrayList<>();
        lines.add("你");
        lines.add("好");
        lines.add("啊");
        lines.add("1");
        lines.add("2");
        lines.add("3");

        // path
        String path = "." + File.separator + "javabook-io-bio" + File.separator + "data" + File.separator + "out.txt";

        // outputStream
        OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(path, true));
        for (final Object line : lines) {
            if (line != null) {
                outputStream.write(line.toString().getBytes(cs));
                outputStream.write(lineEnding.getBytes(cs));
            }
        }
        outputStream.flush();
    }
}
