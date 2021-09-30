package online.javabook.jvm.tuning.clazz;
/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 当新类型检查器失败时，启用自动故障转移到旧验证器。
 * 默认情况下，此选项处于禁用状态，对于具有最新字节码版本的类，它会被忽略（即视为禁用）。您可以为具有旧版本字节码的类启用它。
 *
 * -XX:+FailOverToOldVerifier
 * Enables automatic failover to the old verifier when the new type checker fails.
 * By default, this option is disabled and it is ignored (that is, treated as disabled) for classes with a recent bytecode version.
 * You can enable it for classes with older versions of the bytecode.
 */
public class FailOverToOldVerifier {
}
