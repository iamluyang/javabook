package online.javabook.jvm.string.intern;

public class StringReplace {

    String string = new String("string");
    char[] chars = new char[] {'c', 'h', 'a', 'r'};

    public void modify(String string, char[] chars) {
        string = "new"; // string是不可变对象
        chars[0] = 'x';
    }

    public static void main(String[] args) {
        StringReplace stringExam = new StringReplace();
        stringExam.modify(stringExam.string, stringExam.chars);
        System.out.println(stringExam.string); // string
        System.out.println(stringExam.chars); // xhar
    }
}
