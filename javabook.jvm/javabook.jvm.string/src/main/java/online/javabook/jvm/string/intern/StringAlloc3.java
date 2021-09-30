package online.javabook.jvm.string.intern;

public class StringAlloc3 {

    public static void main(String[] args) {
        String s3 = new String("2") + new String("2");
        String s4 = "22";
        String s5 = s3.intern();
        System.out.println(s4 == s5); // true
    }
}
