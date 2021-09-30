package online.javabook.jvm.gc.others.tlab;

/**
 * 开启ThreadLocal空间
 * -XX:UseTLAB
 *
 * 设置TLAB空间占Eden空间 的比例
 * -XX:TLABWasteTargetPercent
 *
 * 什么是TLAB?
 * 从内存模型而不是垃圾收集的角度，对Eden区域继续进行划分，JVM为每个线程分配了一个私有缓存区域，它包含在Eden空间内。
 * 多线程同时分配内存时，使用TLAB可以避免一系列的非线程安全问题，同时还能够提升内存分配的吞吐量，因此我们可以将这种
 * 内存分配方式称之为快速分配策略。 据我所知所有openJDK衍生出来的JVM都提供了TLAB的设计
 *
 *
 * TLAB的说明:
 * 1.尽管不是所有的对象实例都能够在TLAB中成功分配内存，但JVM确实是将TLAB作为内存分配的首选
 * 在程序中，开发人员可以通过选项“-XX:UseTLAB”设置是否开启TLAB空间
 *
 * 2.默认情况下TLAB空间的内存非常小，仅占有整个Eden空间的1%，当然我们可以通过选项“-XX:TLABWasteTargetPercent”设置 TLAB空间
 * 所占用Eden空间的百分比大小。一旦对象在TLAB空间分配内存失败时，JVM就会尝试着通过使用加锁机制确保数据操作的原子性，从而直接在Eden空间中分配内存。
 */
public class ThreadLocalAllocationBuffer {
}
