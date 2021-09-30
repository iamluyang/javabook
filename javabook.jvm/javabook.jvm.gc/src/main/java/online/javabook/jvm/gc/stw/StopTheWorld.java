package online.javabook.jvm.gc.stw;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class StopTheWorld {
    public static void main(String[] args) {

        Thread workerThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Calendar.getInstance().getTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        workerThread.start();

        Thread gcThread = new Thread() {
            @Override
            public void run() {
                List<byte[]> headMemorys = new LinkedList<byte[]>();
                while (true){
                    byte[] _100MB = new byte[1024 * 1024 * 100];
                }
            }
        };
        gcThread.start();
    }
}
