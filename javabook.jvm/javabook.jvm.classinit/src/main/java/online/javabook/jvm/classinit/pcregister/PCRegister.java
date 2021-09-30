package online.javabook.jvm.classinit.pcregister;

/**
 * PC寄存器用来存储线程下一条执行的字节码指令，每个线程的PC寄存器和线程栈是独立且隔离的，因此不影响线程上下文切换
 */
public class PCRegister {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = a + b;
        System.out.println(c);

        String d = "xyz";
        System.out.println(d);

        /**
         *
         * bytecode:
         * 指令地址  操作指令
         0 iconst_1
         1 istore_1
         2 iconst_2
         3 istore_2
         4 iload_1
         5 iload_2
         6 iadd
         7 istore_3
         8 getstatic #2 <java/lang/System.out : Ljava/io/PrintStream;>
         11 iload_3
         12 invokevirtual #3 <java/io/PrintStream.println : (I)V>
         15 ldc #4 <xyz>
         17 astore 4
         19 getstatic #2 <java/lang/System.out : Ljava/io/PrintStream;>
         22 aload 4
         24 invokevirtual #5 <java/io/PrintStream.println : (Ljava/lang/String;)V>
         27 return
         */
    }
}
