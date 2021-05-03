package online.javabook.jvm.thread.samethread;

public class OneSingleThreadLoopMain {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i <= 8; i++) {

            int total = (int) Math.pow(10, i);
            long start = System.currentTimeMillis();
            for (int j = 0; j < total; j++){
                new SlowTask().run();
            }

            long finish = System.currentTimeMillis();
            System.out.println("OneSingleThreadLoopMain -> 运行 SlowTask " + total + "次，花费时间: " + (finish - start) + " milliseconds");
        }
    }
}
