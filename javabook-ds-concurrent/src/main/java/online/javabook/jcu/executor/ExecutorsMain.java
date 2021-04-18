package online.javabook.jcu.executor;

import java.util.HashMap;
import java.util.concurrent.*;

public class ExecutorsMain {
    public static void main(String[] args) {

        Executors.defaultThreadFactory();
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newScheduledThreadPool(10);
    }
}
