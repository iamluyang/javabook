package online.javabook.jvm.magic.nativearray;

import java.util.Arrays;

public class ArrayCopyPerformanceMain {
    public static void main(String[] args) {

        int test = 10000 * 10000;
        int[] source = new int[] {1,2,3,4,5,6,7,8,9,0};

        long start1 = System.currentTimeMillis();
        for (int i = 0; i < test; i++) {

            int length = source.length;
            int[] target = new int[length];
            for (int idx = 0; idx < length; idx++) {
                target[idx] = source[idx];
            }
        }
        long finish1 = System.currentTimeMillis();
        System.out.println("Copy Array:" + (finish1 - start1));


        long start2 = System.currentTimeMillis();
        for (int i = 0; i < test; i++) {

            int length = source.length;
            int[] target = Arrays.copyOf(source, length);
        }
        long finish2 = System.currentTimeMillis();
        System.out.println("Copy Array:" + (finish2 - start2));
    }
}
