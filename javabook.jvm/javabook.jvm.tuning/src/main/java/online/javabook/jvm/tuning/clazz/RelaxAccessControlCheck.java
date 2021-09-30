package online.javabook.jvm.tuning.clazz;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 减少验证程序中访问控制检查的数量。
 * 默认情况下，此选项处于禁用状态，对于具有最新字节码版本的类，它会被忽略（即视为禁用）。您可以为具有旧版本字节码的类启用它。
 *
 * -XX:+RelaxAccessControlCheck
 * Decreases the amount of access control checks in the verifier.
 * By default, this option is disabled, and it is ignored (that is, treated as disabled) for classes with a recent bytecode version.
 * You can enable it for classes with older versions of the bytecode.
 */
public class RelaxAccessControlCheck {
}
