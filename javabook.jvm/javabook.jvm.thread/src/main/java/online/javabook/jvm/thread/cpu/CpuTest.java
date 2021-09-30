package online.javabook.jvm.thread.cpu;

import java.util.UUID;

public class CpuTest {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < 8; i++) {
            Thread thread = new Thread(() -> {
                while(true) {

                }
            });
            thread.start();
        }
    }
}
