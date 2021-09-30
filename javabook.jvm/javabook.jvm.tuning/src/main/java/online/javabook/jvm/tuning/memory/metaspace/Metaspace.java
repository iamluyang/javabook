package online.javabook.jvm.tuning.memory.metaspace;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 最小元数据区 -XX:PermSize和最大元数据区 -XX:MaxPermSize 设置
 * --------------------------------------------------------------------
 * -XX:MaxMetaspaceSize=size
 * Sets the maximum amount of native memory that can be allocated for class metadata. By default, the size is not limited.
 * The amount of metadata for an application depends on the application itself, other running applications,
 * and the amount of memory available on the system.
 * The following example shows how to set the maximum class metadata size to 256 MB:
 * -XX:MaxMetaspaceSize=256m
 * --------------------------------------------------------------------
 * -XX:MetaspaceSize=size
 * Sets the size of the allocated class metadata space that will trigger a garbage collection the first time it is exceeded.
 * This threshold for a garbage collection is increased or decreased depending on the amount of metadata used.
 * The default size depends on the platform.
 * --------------------------------------------------------------------
 */
public class Metaspace {
}
