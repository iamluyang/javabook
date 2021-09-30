package online.javabook.jvm.string.append;

public class StringAppendMain {
    public static void main(String[] args) {
        int count = 10000 * 10;

        // --------------------------------------------------------------------
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            String string = "this" + "is" + "string" + "append" + "test" + ".";
            // 反编译后等价
            // String var5 = "thisisstringappendtest.";
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("string字面常量相加:" + (finish1 - start1));


        // --------------------------------------------------------------------
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            String string = "this" + "is" + "string" + "append" + "test" + System.currentTimeMillis();
            // 反编译后等价
            // String var9 = "thisisstringappendtest" + System.currentTimeMillis();
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("string动态相加:" + (finish2 - start2));

        // --------------------------------------------------------------------
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            String string =
                    new String("this") +
                    new String("is") +
                    new String("string") +
                    new String("append") +
                    new String("test") +
                    new String(".");

            // 反编译后等价
            // String var13 = new String("this") + new String("is") + new String("string") + new String("append") + new String("test") + new String(".");
        }
        long finish3 = System.currentTimeMillis();
        System.out.println("string非字面常量相加:" + (finish3 - start3));


        // --------------------------------------------------------------------
        long start4 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            String that = new String("this");
            String is = new String("is");
            String str = new String("string");
            String append = new String("append");
            String test = new String("test");
            String dot = new String(".");
            String string = that + is + str + append + test + dot;
            // 反编译后等价
            // (new StringBuilder()).append(that).append(is).append(str).append(append).append(test).append(dot).toString();
        }
        long finish4 = System.currentTimeMillis();
        System.out.println("string非字面常量相加:" + (finish4 - start4));


        // --------------------------------------------------------------------
        long start5 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            StringBuffer stringBuffer = new StringBuffer(100);
            stringBuffer.append("this").append("is").append("string").append("append").append("test").append(".");
        }
        long finish5 = System.currentTimeMillis();
        System.out.println("stringBuffer append:" + (finish5 - start5));


        // --------------------------------------------------------------------
        long start6 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            StringBuilder stringBuilder = new StringBuilder(100);
            stringBuilder.append("this").append("is").append("string").append("append").append("test").append(".");
        }
        long finish6 = System.currentTimeMillis();
        System.out.println("stringBuilder append:" + (finish6 - start6));

        // --------------------------------------------------------------------
        long start7 = System.currentTimeMillis();
        String string1 = new String();
        for (int i = 0; i < count; i++) {
            string1 = string1 + i;
            // 反编译后等价
            // string1 = string1 + i;
        }
        long finish7 = System.currentTimeMillis();
        System.out.println("不要依赖编译器的优化:" + (finish7 - start7));
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("this").append("is").append("string").append("append").append("test").append(".");
        return stringBuffer.toString();
    }
}
