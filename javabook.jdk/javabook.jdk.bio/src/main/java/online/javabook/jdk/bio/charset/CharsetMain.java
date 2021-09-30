package online.javabook.jdk.bio.charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CharsetMain {
    public static void main(String[] args) {
        System.out.println("----------可用字符集----------------");
        System.out.println("defaultCharset:" + Charset.defaultCharset());
        for (Map.Entry<String, Charset> availableCharset : Charset.availableCharsets().entrySet()) {
            System.out.println(availableCharset.getValue());
        }

        // 返回utf8字符集
        Charset charset = Charset.forName("utf8");
        System.out.println(charset.name()+"--"+charset.canEncode());

        System.out.println("----------别名----------------");
        Set<String> set = charset.aliases();
        Iterator<String> it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("----------编码----------------");
        ByteBuffer buffer = charset.encode("你好charset");
        System.out.println(buffer.array());


        System.out.println("----------解码----------------");
        CharBuffer charBuffer = charset.decode(buffer);
        System.out.println(charBuffer);
    }
}
