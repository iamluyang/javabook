package online.javabook.jvm.magic.string.split;

import java.util.StringTokenizer;

public class StringSpliterPerformanceMain {

    public static void main(String[] args) {
        int count = 10000 * 10000;
        String stringSplit = new String("a;b;c");

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            stringSplit.split(";");
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("stringSplit:" + (finish1 - start1));


        StringTokenizer stringTokenizer = new StringTokenizer("a;b;c", ";");
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            while ((stringTokenizer.hasMoreTokens())){
                stringTokenizer.nextToken();
            }
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("stringTokenizer:" + (finish2 - start2));


        StringSpliter stringSpliter = new StringSpliter("a;b;c", ';');
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            while ((stringSpliter.hasMoreTokens())){
                stringSpliter.nextToken();
            }
        }
        long finish3 = System.currentTimeMillis();
        System.out.println("stringTokenizer:" + (finish3 - start3));
    }
}
