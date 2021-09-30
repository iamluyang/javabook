package online.javabook.jvm.bytecode.returnaddress;

/**
 * 返回地址用来存储调用该方法的指令的下一条指令,不同的返回类型返回指令也不同
 */
public class ReturnValueByteCode {

    public ReturnValueByteCode() {
        // void
    }

    static {
        // void
    }

    public void methodA() throws Exception {
        int a = methodReturnShort();
        int b = 2;
    }

    public short methodReturnShort() throws Exception {
        return (short) 1;
    }

    public int methodReturnInt() throws Exception {
        return 1;
    }

    public byte methodReturnByte() throws Exception {
        return (byte) 1;
    }

    public char methodReturnChar() throws Exception {
        return 'a';
    }

    public boolean methodReturnBoolean() throws Exception {
        return true;
    }

    public long methodReturnLong() throws Exception {
        return 1L;
    }

    public float methodReturnFloat() throws Exception {
        return (float)1.0;
    }

    public double methodReturnDouble() throws Exception {
        return 1.0;
    }

    public String methodReturnString() throws Exception {
        return "abc";
    }
}
