package online.javabook.jvm.thread.samethread;

public class OneSingleThreadLoopMain {
    public static void main(String[] args) throws InterruptedException {

        System.out.printf("%20s%20s%20s\n", "Tasks", "Threads", "Time(Mill)");
        int maxTasks = 10000 * 10000;
        for (int minTasks = 1; minTasks <= maxTasks;) {

            long start = System.currentTimeMillis();
            for (int j = 0; j < minTasks; j++){
                new QuickTask().run();
            }

            long finish = System.currentTimeMillis();
            System.out.printf("%20s%20s%20s\n", minTasks, 1, finish - start);
            minTasks = minTasks * 10;
        }
    }
}
