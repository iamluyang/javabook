package online.javabook.jvm.gc.type;

/**
 * 老年代GC (Major GC/Fu11 GC）触发机制:
 * 指发生在老年代的GC，对象从老年代消失时，我们说“Major Gc”或“Full Gc”发生了。
 * 出现了Major GC，经常会伴随至少一次的Minor GC。也就是在老年代空间不足时，会先尝试触发Minor GC。如果之后空间还不足，则触发Major GC。
 * （但非绝对的，在Parallel Scavenge 收集器的收集策略里就有直接进行Major GC的策略选择过程）
 * Major Gc的速度一般会比Minor GC慢10倍以上，STW的时间更长。如果Major GC后内存还不足，就报OOM了
 *
 * ------------------------------------------------------------------------------------
 * Full Gc触发机制, 触发Fu1l Gc执行的情况有如下五种:
 * (1）调用system.gc()时，系统建议执行Full GC，但是不必然执行
 * (2）老年代空间不足
 * (3）方法区空间不足
 * (4）通过Minor GC后进入老年代的平均大小大于老年代的可用内存
 * (5）由Eden区、survivor space (From Space）区向survivor space1 (To space）区复制时，
 *     对象大小大于To Space可用内存，则把该对象转存到老年代，且老年代的可用内存小于该对象大小.
 *
 * 说明: full gc是开发或调优中尽量要避免的。这样暂停时间会短一些。
 */
public class MajorGC {
}
