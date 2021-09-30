package online.javabook.jvm.string.equal;

/**
 * String具有不可变性质
 * StringBuffer - 线程安全
 * StringBuilder - 线程不安全
 */
public class StringEqual {
    public static void main(String[] args) {

        // 1.example
        String str11 = "aaa"; // 字面常量存储在字符串常量池中，str11指向"aaa"存储在字符串常量池中
        String str12 = "aaa"; // 字符串常量池不重复相同字符串，str12同样指向字符串常量池中的"aaa"
        System.out.println(str11==str12); // true

        // 2.example
        String str21 = "bbb"; // 字面常量存储在字符串常量池中
        String str22 = new String("bbb"); // 在堆中创建了一个新String
        System.out.println(str21==str22); // false

        // 3. intern
        String str31 = new String("ccc").intern(); // intern会强制放在常量池中
        String str32 = "ccc"; // str52指向常量池中的"ccc"
        System.out.println(str31==str32); // true

        // 4. intern
        String str41 = new String("ddd").intern(); // intern会强制放在常量池中
        String str42 = new String("ddd"); // 在堆中创建了一个新String
        System.out.println(str41==str42); // false

        // 5. intern
        String str51 = new String("eee"); // 在堆中创建了一个新String
        String str52 = new String("eeee").intern(); // 创建或返回字符串常量池中的字符串
        System.out.println(str51==str52); // false

        // 6. constant + constant
        String str61 = "fff" + "ggg"; // 两个字面常量拼接会被编译优化成 fffggg，可以查看bytecode验证
        String str62 = "fffggg"; // 字面常量存储在字符串常量池中
        System.out.println(str61==str62); // true

        // 7. var + var
        String str71 = "hhh"; // 字面常量存储在字符串常量池中
        String str72 = "iii"; // 字面常量存储在字符串常量池中
        String str73 = str71 + str72; // 字符串拼接中存在变量则会在堆空间中创建字符串
        String str74 = "hhhiii"; // 字面常量存储在字符串常量池中
        System.out.println(str73==str74); // false

        // 8. final string
        final String str81 = "xxx"; // 字面常量存储在字符串常量池中
        final String str82 = "yyy"; // 字面常量存储在字符串常量池中
        String str83 = str81 + str82; // 字符串拼接中存在final同样会被优化
        String str84 = "xxxyyy"; // 字面常量存储在字符串常量池中
        System.out.println(str83==str84); // true

        // stringBuffer
        String str91 = "kkk";
        String str92 = "lll";
        String str93 = "kkklll";
        StringBuffer stringBuffer = new StringBuffer();
        String str94 = stringBuffer.append(str91).append(str92).toString();
        System.out.println(str93==str94); // false

    }
}
