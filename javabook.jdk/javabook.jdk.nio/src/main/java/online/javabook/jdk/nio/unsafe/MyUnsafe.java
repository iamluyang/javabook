package online.javabook.jdk.nio.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
@SuppressWarnings("restriction")
public class MyUnsafe {

    /**
     * unsafeObject
     */
    private static final Object unsafeObject;

    /**
     * maxMemoryField
     */
    static Field maxMemoryField;

    /**
     * reservedMemoryField
     */
    static Field reservedMemoryField;

    /**
     * totalCapacity
     */
    static Field totalCapacity;

    /**
     * BASE
     */
    static long BASE;

    /**
     * SCALE
     */
    static int SCALE;

    /**
     * SHIFT
     */
    static int SHIFT;

    static {

        try {
            // unsafeField
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafeObject = unsafeField.get(Unsafe.class);

            // bits
            Class<?> bits = Class.forName("java.nio.Bits");

            // maxMemoryField
            maxMemoryField = bits.getDeclaredField("maxMemory");
            maxMemoryField.setAccessible(true);

            // reservedMemoryField
            reservedMemoryField = bits.getDeclaredField("reservedMemory");
            reservedMemoryField.setAccessible(true);

            // totalCapacity
            totalCapacity = bits.getDeclaredField("totalCapacity");
            totalCapacity.setAccessible(true);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * @return
     */
    public static Unsafe getUnsafe() {
        return ((Unsafe) unsafeObject);
    }

    /**
     * @return
     */
    public static Long getMaxMemory() {
        try {
            return (Long) maxMemoryField.get(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (long) 0;
    }

    /**
     * @return
     */
    public static Number getReservedMemory() {
        try {
            return (Number) reservedMemoryField.get(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (long) 0;
    }

    /**
     * @return
     */
    public static Number getTotalCapacity() {
        try {
            return (Number) totalCapacity.get(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (long) 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Max Memory: "+ MyUnsafe.getMaxMemory());

        int _1MB = 1024 * 1024;
        List<ByteBuffer> byteBuffers = new ArrayList<ByteBuffer>();
        while(true){
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(_1MB);
            byteBuffers.add(byteBuffer);
            System.out.println("Reserved Memory: "+MyUnsafe.getReservedMemory());
            Thread.sleep(50);
        }
    }
}
