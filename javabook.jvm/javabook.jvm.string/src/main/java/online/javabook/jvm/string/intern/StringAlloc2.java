package online.javabook.jvm.string.intern;

public class StringAlloc2 {

    public static void main(String[] args) {
        String s3 = new String("2") + new String("2");
        String s4 = "22";
        s3.intern();
        System.out.println(s3 == s4); // false
    }
}
