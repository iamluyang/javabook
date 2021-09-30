package online.javabook.jvm.tuning.memory.heap.adjust;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 *
 * -XX:HandlePromotionFailure 新生代对象升级到老年代是否可行，如果每次Minro GC后Old Generation都要进行一次Major GC，
 * 势必效率比较低下，系统响应性下降。 因此能够根据以往Minro GC后进入Old Generation的对象的平均数据来决定是否需要进行Major GC。
 * 但是根据以往数据的平均值未必可靠，可能出现某次需要进入Old Generation的对象数量特别多，这时Old Generation就要先进行Major GC.
 * 一般情况可以开启这个选项，以减少Old Generation的Major GC
 *
 * 在JDK6 Update24之后，HandlePromotionFailure参数不会再影响到虚拟机的空间分配担保策略，观察openJDK中的源码变化，
 * 虽然源码中还定义了HandlePromotionFailure参数，但是在代码中已经不会再使用它。JDK6 Update24之后的规则变为只要老
 * 年代的连续空间大于新生代对象总大小或者历次晋升的平均大小就会进行Minor GC，否则将进行Full GC。
 *
 * --------------------------------------------------------------------
 * 流程：
 * 在发生Minor GC之前，虚拟机会检查老年代最大可用的连续空间是否大于新生代所有对象的总空间。
 * 1.如果大于，则此次Minor GC是安全的
 * 2.如果小于，则虚拟机会查看 -XX:HandlePromotionFailure 设置值是否允许担保失败
 * 3.如果HandlePromotionFailure=true，那么会继续检查老年代最大可用连续空间是否大于历次晋升到老年代的对象的平均大小。
 *   如果大于,则尝试进行一次Minor GC，但这次在Minor GC依然是有风险的;
 *   如果小于，则改为进行一次Full GC。
 * 4.如果HandlePromotionFailure=false，则改为进行一次Full GC
 */
public class HandlePromotionFailure {
}
