package online.javabook.jvm.bytecode.localvariables;

public class LocalVariablesTableByteCode {

    private int field1 = 0;
    static final int field2 = 1;
    static final String field3 = "abc";

    public LocalVariablesTableByteCode(int arg1, String arg) {
        int a = 1;
        int b = 2;
        long c = 3;
        double d = 4;
        boolean e = true;
        boolean f = false;
        double g = a + b + c + d;
    }

    public static double methodA(int arg1, String arg2) {
        short a = (short) 1;
        int b = 2;
        long c = 3;       // 需要占用2个slot
        float d = 4;     // 需要占用2个slot
        double e = 4;     // 需要占用2个slot
        String f = "xxx"; // 引用类型也占用1个slot
        {
            int g = 5;
        }
        boolean h = true;
        double i = a + b + c + d;

        short[] shorts = new short[10];
        int[] ints = new int[10];
        long[] longs = new long[10];
        float[] floats = new float[10];
        double[] doubles = new double[10];
        String[] strings = new String[10];
        boolean[] booleans = new boolean[10];

        return i;
    }

    /**
     * A Java stack frame, holding local variables. Only generated when the dump
     * is parsed with the preference set to treat Java stack frames as objects.
     */
    public double methodB(int arg1, String arg2) { // this和方法参数也会加入到局部变量表

        // byte, char, short, int, boolean都被存储为int类型
        short a = (short) 1;
        int b = 2;
        long c = 3;       // 需要占用2个slot
        float d = 4;      // 需要占用2个slot
        double e = 4;     // 需要占用2个slot
        String f = "xxx"; // 引用类型也占用1个slot
        {
            int g = 5;
        }
        boolean h = true;
        double i = a + b + c + d;

        short[] shorts = new short[10];
        int[] ints = new int[10];
        long[] longs = new long[10];
        float[] floats = new float[10];
        double[] doubles = new double[10];
        String[] strings = new String[10];
        boolean[] booleans = new boolean[10];

        return i;
    }
}
