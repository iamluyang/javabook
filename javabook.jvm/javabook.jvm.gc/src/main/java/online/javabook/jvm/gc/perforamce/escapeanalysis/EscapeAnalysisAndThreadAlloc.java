package online.javabook.jvm.gc.perforamce.escapeanalysis;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -XX:+DoEscapeAnalysis -XX:+PrintGCDetails
 * 开启栈上分配比在堆上分配能避免GC的频率和分配销毁对象的速度
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class EscapeAnalysisAndThreadAlloc {

    public static void main(String[] args) throws InterruptedException {

        EscapeAnalysisAndThreadAlloc escapeAnalysisAndThreadAlloc = new EscapeAnalysisAndThreadAlloc();
        long start = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < Long.MAX_VALUE; i++) {
            escapeAnalysisAndThreadAlloc.allocInTheStack();
        }
        long finish = System.currentTimeMillis();
        System.out.println("花费时间:" + (finish - start) + "ms");
    }

    /**
     * 该对象不会逃逸出该方法，因此可以避免堆分配，从而在栈上分配
     * 开发中能使用局部变量的，就不要使用在方法外定义
     */
    private void allocInTheStack() {
        Scalar _1KB = new Scalar();
    }
}
