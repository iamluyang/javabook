package online.javabook.jvm.gc.perforamce.escapeanalysis;

/**
 * 标量替换参数设置∶
 * -XX:+EliminateAllocations -XX:+PrintGCDetails
 * 开启标量替换(默认打开)，允许将对象打散分配在栈上
 *
 * 分离对象(聚合量)或标量替换:
 * 有的对象可能不需要作为一个连续的内存结构存在也可以被访问到，那么对象的部分(或全部)可以不存储在内存中，而是存储在CPU寄存器中。
 *
 */
public class EscapeAnalysisAndScalarReplace {

    public static void main(String[] args) throws InterruptedException {

        EscapeAnalysisAndScalarReplace escapeAnalysisAndScalarReplace = new EscapeAnalysisAndScalarReplace();
        long start = System.currentTimeMillis();
        System.out.println();
        for (int i = 0; i < Long.MAX_VALUE; i++) {
            escapeAnalysisAndScalarReplace.scalar();
        }
        long finish = System.currentTimeMillis();
        System.out.println("花费时间:" + (finish - start) + "ms");
    }

    /**
     * 可以看到Point这个聚合量经过逃逸分析后，发现它并没有逃逸，就被替换成两个标量了。
     * 这就是大大减少堆内存的占想。因为一旦不需要创建对象，那么就不再需要分配堆内存了。
     */
    private void scalar() {
        Scalar point = new Scalar();
        point.x = 100;
        point.y = 100;
    }

    private void scalarReplace() {
        int x = 1;
        int y = 2;
        System.out.println("point.x=" + x + " ; point.y=" + y);
    }
}
