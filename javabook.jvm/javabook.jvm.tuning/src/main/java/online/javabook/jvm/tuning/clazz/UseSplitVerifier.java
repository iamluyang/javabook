package online.javabook.jvm.tuning.clazz;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 启用验证过程的拆分。默认情况下，此选项在以前的版本中启用，验证分为两个阶段：类型引用（由编译器执行）和类型检查（由 JVM 运行时执行）。
 * 此选项在 JDK 8 中已弃用，现在默认情况下会拆分验证，无法禁用它。
 *
 * -XX:+UseSplitVerifier
 * Enables splitting of the verification process. By default, this option was enabled in the previous releases,
 * and verification was split into two phases: type referencing (performed by the compiler) and type checking (performed by the JVM runtime).
 * This option was deprecated in JDK 8, and verification is now split by default without a way to disable it.
 */
public class UseSplitVerifier {
}
