package online.javabook.jvm.objectinit;

/**
 * ---------------------------------------------------------------------
 * 测试对象实例化的过程
 * 1.加载类元信息 2.为对象分配内存 3.处理并发问题 4.属性的默认初始化（零值初始化)
 * 5.设置对象头的信息 6.属性的显式初始化、代码块中初始化、构造器中初始化
 * ---------------------------------------------------------------------
 * 对象的属性赋值的操作;
 * 1.属性的默认初始化 2.显式初始化 3.静态代码(块)中初始化 4.构造器中初始化
 * ---------------------------------------------------------------------
 *
 * <clinit>
 *
 0 sipush 1000
 3 putstatic #9 <online/javabook/jvm/objectinit/Obj.si2 : I>
 6 ldc2_w #10 <2000>
 9 putstatic #12 <online/javabook/jvm/objectinit/Obj.sl2 : J>
 12 ldc #13 <xxxxxxxxxx>
 14 putstatic #14 <online/javabook/jvm/objectinit/Obj.str2 : Ljava/lang/String;>
 17 return
 *
 * ---------------------------------------------------------------------
 *
 * <init>
 *
 0 aload_0
 1 invokespecial #1 <java/lang/Object.<init> : ()V>
 4 aload_0
 5 sipush 3000
 8 putfield #2 <online/javabook/jvm/objectinit/Obj.i2 : I>
 11 aload_0
 12 ldc2_w #3 <4000>
 15 putfield #5 <online/javabook/jvm/objectinit/Obj.l2 : J>
 18 aload_0
 19 ldc #6 <yyyyyyyyyy>
 21 putfield #7 <online/javabook/jvm/objectinit/Obj.s2 : Ljava/lang/String;>
 24 aload_0
 25 iload_1
 26 putfield #8 <online/javabook/jvm/objectinit/Obj.i1 : I>
 29 return
 */
public class Obj {

    private static int si1;
    private static long sl1;
    private static String str1;
    private static int si2 = 1000;
    private static long sl2 = 2000;
    private static String str2 = "xxxxxxxxxx";

    private int i1;
    private long l1;
    private long s1;
    private int i2 = 3000;
    private long l2 = 4000;
    private String s2 = "yyyyyyyyyy";

    public Obj(int i1) {
        this.i1 = i1;
    }
}
