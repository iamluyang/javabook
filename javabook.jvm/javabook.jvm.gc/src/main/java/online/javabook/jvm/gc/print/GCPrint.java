package online.javabook.jvm.gc.print;

/**
 * -Xms200m -Xmx200m -XX:NewRatio=1 -XX:+PrintGCDetails
 */
public class GCPrint {

    public static void main(String[] args) {
        GCPrint gcPrint = new GCPrint();
        gcPrint.gc1();
    }

    public void gc1() {
        byte[] _10M = new byte[1024 * 1024 * 10];
        System.gc();
    }
}
