package online.javabook.jvm.tuning.jit;

/**
 * https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html
 * --------------------------------------------------------------------
 * 仅以解释模式运行应用程序。禁止编译为本机代码，所有字节码都由解释器执行。即时 (JIT) 编译器提供的性能优势在此模式下不存在。
 *
 * -Xint
 * Runs the application in interpreted-only mode. Compilation to native code is disabled, and all bytecode is executed by the interpreter.
 * The performance benefits offered by the just in time (JIT) compiler are not present in this mode.
 *
 * --------------------------------------------------------------------
 * 在第一次调用时强制编译方法。默认情况下，客户端 VM (-client) 执行 1,000 次解释方法调用，服务器 VM (-server) 执行 10,000 次解释方法调用，以收集信息以进行高效编译。
 * 指定 -Xcomp 选项会禁用解释方法调用，以提高编译性能，但会降低效率.
 *
 * -Xcomp
 * Forces compilation of methods on first invocation. By default, the Client VM (-client) performs 1,000 interpreted method invocations
 * and the Server VM (-server) performs 10,000 interpreted method invocations to gather information for efficient compilation.
 * Specifying the -Xcomp option disables interpreted method invocations to increase compilation performance at the expense of efficiency.
 *
 * You can also change the number of interpreted method invocations before compilation using the -XX:CompileThreshold option.
 *
 * --------------------------------------------------------------------
 * 设置编译前解释方法调用的次数。默认情况下，在服务器 JVM 中，JIT 编译器执行 10,000 次解释方法调用来收集信息以进行高效编译。
 * 对于客户端 JVM，默认设置为 1,500 次调用。启用分层编译时将忽略此选项。
 *
 * -XX:CompileThreshold=invocations
 * Sets the number of interpreted method invocations before compilation. By default, in the server JVM,
 * the JIT compiler performs 10,000 interpreted method invocations to gather information for efficient compilation.
 * For the client JVM, the default setting is 1,500 invocations. This option is ignored when tiered compilation is enabled;
 * see the option -XX:+TieredCompilation. The following example shows how to set the number of interpreted method invocations to 5,000:
 *
 * -XX:CompileThreshold=5000
 * You can completely disable interpretation of Java methods before compilation by specifying the -Xcomp option.
 *
 * --------------------------------------------------------------------
 * 由解释器执行除热方法之外的所有字节码，热方法被编译为本机代码。
 *
 * -Xmixed
 * Executes all bytecode by the interpreter except for hot methods, which are compiled to native code.
 *
 */
public class Jit {
}
