package online.javabook.jvm.gc.perforamce.escapeanalysis;

/**
 * 什么是逃逸分析?
 * JIT编译器在编译期间根据逃逸分析的结果，发现如果一个对象并没有逃逸出方法的话，就可能被优化成栈上分配。
 * 分配完成后继续在调用栈内执行，最后线程结束，栈空间被回收，局部变量对象也被回收。这样就无须进行垃圾回收了
 *
 * 在JDK 6u23(JDK7)版本之后，Hotspot中默认就已经开启了逃逸分析。
 * 如果使用的是较早的版本，开发人员则可以通过:
 * 选项-server:启动server模式      因为在server模式下，才可以启用逃逸分析
 * 选项-XX:+DoEscapeAnalysis     显式开启逃逸分析
 * 选项-XX:+PrintEscapeAnalysis  查看逃逸分析的筛选结果
 *
 * 1.栈上分配:
 * 将堆分配转化为栈分配。如果一个对象在子方法中被分配，要使指向该对象的指针永远不会逃逸出该方法，对象可能是栈分配的候选，而不是堆分配
 * 2.同步省略:
 * 如果一个对象被发现只能从一个线程被访问到，那么对于这个对象的操作可以不考虑同步
 * 3.分离对象(聚合量)或标量替换:
 * 有的对象可能不需要作为一个连续的内存结构存在也可以被访问到，那么对象的部分(或全部)可以不存储在内存中，而是存储在CPU寄存器中。
 *
 */
public class EscapeAnalysisAndSyncIgnore {

    public static void main(String[] args) throws InterruptedException {

        EscapeAnalysisAndSyncIgnore escapeAnalysisAndIgnoreSync = new EscapeAnalysisAndSyncIgnore();
        long start = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < 1000000000; i++) {
            escapeAnalysisAndIgnoreSync.syncEscapeAnalysis();
        }
        long finish = System.currentTimeMillis();
        System.out.println("花费时间:" + (finish - start) + "ms");
    }
    /**
     * 同步省略
     * 同步操作的逃逸分析
     */
    public void syncEscapeAnalysis() {
        Object lock = new Object();
        synchronized (lock) {

        }
    }

    /**
     * 同步省略
     * StringBuffer是线程安全的，但是不能逃逸出该作用域，因此会被逃逸分析，被StringBuilder替代
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("abc");
        sb.append("def");
        return sb.toString();
    }
}
