package online.javabook.jvm.tuning.clazz;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 设置字节码验证器的模式。字节码验证可确保类文件的格式正确并满足 Java 虚拟机规范中第 4.10 节“类文件的验证”中列出的约束。
 * 不要关闭验证，因为这会降低 Java 提供的保护，并可能由于格式错误的类文件而导致问题。
 *
 * -Xverify:mode
 * Sets the mode of the bytecode verifier. Bytecode verification ensures that class files are properly
 * formed and satisfy the constraints listed in section 4.10, Verification of class Files in the The Java Virtual Machine Specification.
 *
 * Do not turn off verification as this reduces the protection provided by Java and could cause problems due to ill-formed class files.
 * Possible mode arguments for this option include the following:
 *
 * remote
 * Verifies all bytecodes not loaded by the bootstrap class loader. This is the default behavior if you do not specify the -Xverify option.
 *
 * all
 * Enables verification of all bytecodes.
 *
 * none
 * Disables verification of all bytecodes. Use of -Xverify:none is unsupported.
 */
public class Xverify {
}
