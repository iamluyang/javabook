package online.javabook.jvm.string.stringpool;

/**
 * 字符串常量池在JDK6及之前放在永生区中，JDK7和JDK8中字符串常量池放在了堆中
 *
 * string的string Pool是一个固定大小的Hashtable，默认值大小长度是1009。
 *  如果放进string Pool的string非常多，就会造成Hash冲突严重，从而导致链表会很长，
 *  而链表长了后直接会造成的影响就是当调用string.intern时性能会大幅下降。
 *
 *  设置stringTable的长度:
 *  -XX:StringTableSize
 *
 *  jdk6中StringTable的长度是固定的:1009，所以如果常量池中的字符串过多就会导致效率下降很快。StringTableSize设置没有要求
 *  jdk7中StringTable的长度默认值是:60013，StringTableSize设置没有要求
 *  jdk8开始设置stringTable的长度的话，1009是可设置的最小值
 */
public class StringPool {

    String string1 = "xxx"; // 字面常量被分配中堆中
    String string2 = new String().intern(); // intern被分配中堆中
}
