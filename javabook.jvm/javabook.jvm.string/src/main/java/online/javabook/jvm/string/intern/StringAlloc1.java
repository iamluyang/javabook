package online.javabook.jvm.string.intern;

/**
 *  jdk1.6中，intern字符串对象尝试放入串池。
 *  如果字符串池中有，则并不会放入。返回已有的字符串池中的对象的地址
 *  如果字符串池没有，会把此对象复制一份放入字符串池并返回字符串池中的对象地址
 *
 * Jdk1.7起，intern将这个字符串对象尝试放入串池
 *  如果字符串池中有，则并不会放入。返回已有的字符串池中的对象的地址
 *  如果字符串池没有，则会把对象的引用地址复制一份，放入字符串池并返回字符串池中的引用地址
 */
public class StringAlloc1 {

    public static void main(String[] args) {
        String s1 = new String("11");
        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2); // jdk6:false; jdk7/8:false

        String s3 = new String("2") + new String("2");
        s3.intern();
        String s4 = "22";
        System.out.println(s3 == s4); // jdk6:false; jdk7/8:true
    }
}
