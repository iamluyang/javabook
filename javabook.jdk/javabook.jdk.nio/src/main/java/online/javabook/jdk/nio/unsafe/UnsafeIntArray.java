package online.javabook.jdk.nio.unsafe;

public class UnsafeIntArray {

    private long initAddress;

    private int intSize = Integer.SIZE;

    public UnsafeIntArray(int size) {
        initAddress = MyUnsafe.getUnsafe().allocateMemory(size * intSize);
    }

    public int get(int index) {
        return MyUnsafe.getUnsafe().getInt(initAddress + index * intSize);
    }

    public void set(int index, int value) {
        MyUnsafe.getUnsafe().putInt(initAddress + index * intSize, value);
    }

    public void free() {
        if (initAddress == 0) {
            return;
        }
        MyUnsafe.getUnsafe().freeMemory(initAddress);
    }
}
