package online.javabook.jvm.gc.type;

/**
 * JVM在进行Gc时，并非每次都对三个内存(新生代、老年代;方法区)区域一起回收的，大部分时候回收的都是指新生代。
 *
 * 针对HotSpot VM的实现，它里面的GC按照回收区域又分为两大种类型: 一种是部分收集(Partial GC），一种是整堆收集( Fu11 GC)
 *
 * A.部分收集:不是完整收集整个Java堆的垃圾收集。其中又分为:
 *  1.新生代收集（Minor GC/Young GC):只是新生代(Eden,s0,s1)的垃圾收集
 *  2.老年代收集（Major GC/Old GC):只是老年代的垃圾收集。 目前，只有CMS GC会有单独收集老年代的行为
 *  (注意，很多时候Major GC会和Fu1l GC混淆使用，需要具体分辨是老年代回收还是整堆回收。)
 *  3.混合收集（Mixed GC):收集整个新生代以及部分老年代的垃圾收集, 目前只有G1 GC会有这种行为
 *
 * B.整堆收集(Full GC): 收集整个java堆(新生代，年老代)和方法区的垃圾收集
 */
public class FullGC {
}
