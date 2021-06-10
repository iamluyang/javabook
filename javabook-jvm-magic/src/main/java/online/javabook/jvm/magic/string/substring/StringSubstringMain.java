package online.javabook.jvm.magic.string.substring;

import java.lang.reflect.Field;

public class StringSubstringMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = "0123456789";
        String sub = str.substring(3);

        System.out.println(sub);
    }
}
