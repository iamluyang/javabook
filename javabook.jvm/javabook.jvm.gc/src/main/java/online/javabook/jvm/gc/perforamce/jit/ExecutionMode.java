package online.javabook.jvm.gc.perforamce.jit;

/**
 * 采用解析器模式执行代码
 * -Xint
 *
 * 采用编译器模式执行代码
 * -Xcomp
 *
 * 采用混合模式执行代码
 * -Xmixed
 *
 * 触发JIT编译的阈值-方法调用的次数或回边的次数，默认是10000次触发
 * -XX:CompileThreshold=10000
 *
 * 关闭或开启JIT计数器是否衰退
 * -XX:-UseCounterDecay
 *
 * 设置JIT计数器半衰的时间周期
 * -XX:CounterHalfLifeTime
 */
public class ExecutionMode {
    public static void main(String[] args) {

        ExecutionMode executionMode = new ExecutionMode();
        int count = 10000 + 990000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            executionMode.toString();
        }
        long finish = System.currentTimeMillis();
        System.out.println("花费时间:" + (finish - start) + "ms");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
