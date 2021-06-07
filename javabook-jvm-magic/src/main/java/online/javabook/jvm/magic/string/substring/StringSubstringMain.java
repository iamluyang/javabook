package online.javabook.jvm.magic.string.substring;

import java.lang.reflect.Field;

public class StringSubstringMain {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String str = new String("abcdef");

        // return (beginIndex == 0) ? this : new String(value, beginIndex, subLen);
        // value!!!!
        String sub = str.substring(3);

        System.out.println(sub);

        Field valueField = String.class.getDeclaredField("value");
        valueField.setAccessible(true);
        char[] value = (char[]) valueField.get(sub);
        System.out.println(value);
    }
}
