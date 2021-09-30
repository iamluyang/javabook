package online.javabook.jvm.string.intern;

public class StringIntern {

    /**
     0 new #2 <java/lang/String> 在堆中创建
     3 dup
     4 ldc #3 <word>        在字符串常量池中创建
     6 invokespecial #4 <java/lang/String.<init> : (Ljava/lang/String;)V>
     9 astore_1
     10 return
     * @param args
     */
    public static void main(String[] args) {

        // new String本身会在堆中创建一个对象
        // new String双引号中的字面值本身又是一个字符串常量，因此也会在常量池中创建一个对象
        String s1 = new String("word");

        // s1.intern()返回的是s1指向堆中的对象并指向常量池中的常量字符串的引用地址
        // s1 -> heap.string -> (string pool).word
        System.out.println(s1.intern() == s1); // false

        // 字面常量 "word" 返回的是word在常量池中的地址
        System.out.println(s1.intern() == "word"); // true
    }
}
