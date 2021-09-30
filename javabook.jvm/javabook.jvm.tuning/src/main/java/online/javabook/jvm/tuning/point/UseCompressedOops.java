package online.javabook.jvm.tuning.point;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 禁用压缩指针的使用。默认情况下启用此选项，当 Java 堆大小小于 32 GB 时使用压缩指针。
 * 启用此选项后，对象引用表示为 32 位偏移量而不是 64 位指针，这通常会在运行 Java 堆大小小于 32 GB 的应用程序时提高性能。
 * 此选项仅适用于 64 位 JVM。当 Java 堆大小大于 32GB 时，也可以使用压缩指针。请参阅 -XX:ObjectAlignmentInBytes 选项。
 *
 * -XX:-UseCompressedOops
 * Disables the use of compressed pointers. By default, this option is enabled,
 * and compressed pointers are used when Java heap sizes are less than 32 GB. When this option is enabled,
 * object references are represented as 32-bit offsets instead of 64-bit pointers,
 * which typically increases performance when running the application with Java heap sizes less than 32 GB.
 * This option works only for 64-bit JVMs.
 *
 * It is also possible to use compressed pointers when Java heap sizes are greater than 32GB. See the -XX:ObjectAlignmentInBytes option.
 */
public class UseCompressedOops {
}
