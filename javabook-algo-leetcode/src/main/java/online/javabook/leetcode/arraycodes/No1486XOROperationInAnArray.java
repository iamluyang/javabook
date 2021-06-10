package online.javabook.leetcode.array;

public class No1486XOROperationInAnArray {
    public static void main(String[] args) {
        int result = xorOperation(5, 0);
        System.out.println(result);
    }

    public static int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }
}
