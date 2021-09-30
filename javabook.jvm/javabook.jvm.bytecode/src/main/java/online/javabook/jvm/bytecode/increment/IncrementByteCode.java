package online.javabook.jvm.bytecode.increment;

/**
 * 自增的指令区别
 */
public class IncrementByteCode {

    /**
     0 iconst_1
     1 istore_1
     2 iload_1
     3 iinc 1 by 1
     6 istore_2
     7 return
     */
    public void getAndIncrement() {
        int a = 1;
        int b = a++;
    }

    /**
     0 iconst_1
     1 istore_1
     2 iinc 1 by 1
     5 iload_1
     6 istore_2
     7 return
     */
    public void incrementAndGet() {
        int a = 1;
        int b = ++a;
    }
}
