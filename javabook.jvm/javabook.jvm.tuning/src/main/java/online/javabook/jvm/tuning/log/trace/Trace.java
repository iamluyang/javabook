package online.javabook.jvm.tuning.log.trace;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 跟踪永生区/元数据区中类加载信息
 *
 * -XX:+TraceClassLoading
 * Enables tracing of classes as they are loaded. By default, this option is disabled and classes are not traced.
 *
 * --------------------------------------------------------------------
 * 跟踪永生区/元数据区中类卸载信息
 *
 * -XX:+TraceClassUnloading
 * Enables tracing of classes as they are unloaded. By default, this option is disabled and classes are not traced.
 *
 * --------------------------------------------------------------------
 * 启用对常量池分辨率的跟踪。默认情况下，此选项处于禁用状态，并且不会跟踪常量池解析。
 *
 * -XX:+TraceClassResolution
 * Enables tracing of constant pool resolutions. By default, this option is disabled and constant pool resolutions are not traced.
 *
 * --------------------------------------------------------------------
 * 启用按引用顺序跟踪所有加载的类。默认情况下，此选项处于禁用状态并且不跟踪类。
 *
 * -XX:+TraceClassLoadingPreorder
 * Enables tracing of all loaded classes in the order in which they are referenced. By default, this option is disabled and classes are not traced.
 *
 * --------------------------------------------------------------------
 * 启用对加载程序约束记录的跟踪。默认情况下，此选项处于禁用状态，并且不跟踪加载程序约束记录。
 *
 * -XX:+TraceLoaderConstraints
 * Enables tracing of the loader constraints recording. By default, this option is disabled and loader constraints recording is not traced.
 */
public class Trace {
}
