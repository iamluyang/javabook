package online.javabook.jvm.magic.string.bigstring;

public class BigStringMain {
    public static void main(String[] args) {
        long count = 999999999;
        String bigString = new String();
        for (int i = 0; i < count; i++) {
            bigString += 1;
        }
        System.out.println(bigString);
        System.out.println(bigString.length());
    }
}
