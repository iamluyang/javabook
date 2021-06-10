package online.javabook.io.nio.unsafe.array;

public class UnsafeIntArrayMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {

        UnsafeIntArray outHeapIntArray = new UnsafeIntArray(1024*1024*50);
        outHeapIntArray.set(0, 0);
        outHeapIntArray.set(1, 1);
        outHeapIntArray.set(2, 2);
        outHeapIntArray.set(3, 3);

        System.out.println(outHeapIntArray.get(0));
        System.out.println(outHeapIntArray.get(1));
        System.out.println(outHeapIntArray.get(2));
        System.out.println(outHeapIntArray.get(3));
    }
}
