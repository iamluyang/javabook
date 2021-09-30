package online.javabook.jdk.nio.performance;

import java.nio.ByteBuffer;

public class DirectAndHeapSpeedPerformance {

    public static void main(String[] args) {
        int length = 10000 * 500;
        heapExecuteTime(length);
        directExecuteTime(length);
    }

    private static void directExecuteTime(int length) {
        long startTime = System.currentTimeMillis();
        ByteBuffer[] byteBufferArray = new ByteBuffer[length];
        for (int i = 0; i < length; i++) {
            byteBufferArray[i] = ByteBuffer.allocateDirect(1024);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("创建" + length + "个DirectByteBuffer所消耗的时间：" + (endTime - startTime));
    }

    private static void heapExecuteTime(int length) {
        long startTime = System.currentTimeMillis();
        ByteBuffer[] byteBufferArray = new ByteBuffer[length];
        for (int i = 0; i < length; i++) {
            byteBufferArray[i] = ByteBuffer.allocate(1024);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("创建" + length + "个HeapByteBuffer所消耗的时间：" + (endTime - startTime));
    }
}
