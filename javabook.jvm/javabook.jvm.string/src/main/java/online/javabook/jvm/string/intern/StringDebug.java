package online.javabook.jvm.string.intern;

public class StringDebug {
    public static void main(String[] args) {
        // break point
        String a = "a";
        String b = "b";
        String c = "c";
        String d = "d";
        String e = "e";
        String f = "f";
        String g = "g";
        String h = "h";
        String i = "i";
        String j = "j";  // 观察当前字符串在内存中的个数

        String a2 = "a"; // 观察当前字符串在内存中的个数， 因为上面字面常量，因此已经存在于字符串常量池中，字符串不会再次创建，字符串个数不会增长
        String b2 = "b";
        String c2 = "c";
        String d2 = "d";
        String e2 = "e";
        String f2 = "f";
        String g2 = "g";
        String h2 = "h";
        String i2 = "i";
        String j2 = "j";
    }
}
