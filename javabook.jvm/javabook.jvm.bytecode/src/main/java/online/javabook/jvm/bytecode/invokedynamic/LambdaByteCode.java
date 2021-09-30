package online.javabook.jvm.bytecode.invokedynamic;

/**
 * 动态调用invokedynamic指令
 */
public class LambdaByteCode {

    public void lambda(Func func) {

    }

    /**
     0 new #2 <online/javabook/jvm/bytecode/dynamic/LambdaByteCode>
     3 dup
     4 invokespecial #3 <online/javabook/jvm/bytecode/dynamic/LambdaByteCode.<init> : ()V>
     7 astore_1
     8 new #4 <online/javabook/jvm/bytecode/dynamic/LambdaByteCode$1>
     11 dup
     12 invokespecial #5 <online/javabook/jvm/bytecode/dynamic/LambdaByteCode$1.<init> : ()V>
     15 astore_2
     16 aload_1
     17 aload_2
     18 invokevirtual #6 <online/javabook/jvm/bytecode/dynamic/LambdaByteCode.lambda : (Lonline/javabook/jvm/bytecode/dynamic/Func;)V>
     21 aload_1
     22 invokedynamic #7 <func, BootstrapMethods #0>
     27 invokevirtual #6 <online/javabook/jvm/bytecode/dynamic/LambdaByteCode.lambda : (Lonline/javabook/jvm/bytecode/dynamic/Func;)V>
     30 return
     */
    public static void main(String[] args) {
        LambdaByteCode lambdaByteCode = new LambdaByteCode();
        Func func = new Func() {
            @Override
            public boolean func(String str) {
                return false;
            }
        };

        lambdaByteCode.lambda(func);

        // invokedynamic
        lambdaByteCode.lambda(str -> {
            return true;
        });
    }
}
