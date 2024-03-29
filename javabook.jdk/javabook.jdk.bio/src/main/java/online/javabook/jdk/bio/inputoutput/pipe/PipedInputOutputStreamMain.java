package online.javabook.jdk.bio.inputoutput.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Java IO 中的管道提供了运行在同一个 JVM 中的两个线程进行通信的能力。因此管道也可以是数据的来源或目的地。
 * 您不能使用管道与不同 JVM（不同进程）中的线程进行通信。Java 中的管道概念与 Unix / Linux 中的管道概念不同，
 * 后者运行在不同地址空间的两个进程可以通过管道进行通信。在Java中，通信双方必须运行在同一个进程中，并且应该是不同的线程。
 *
 * 管道与线程
 * 请记住，当使用两个连接的管道流时，将一个流传递给一个线程，将另一个流传递给另一个线程。在read()与write()对流呼叫拦截，
 * 这意味着如果您尝试使用相同的线程读取和写入，这可能会导致线程死锁本身。
 *
 * 管道的备选方案
 * 除了管道，线程可以在同一个 JVM 中进行通信还有许多其他方式。事实上，线程更经常地交换完整的对象而不是原始字节数据。
 * 但是 - 如果您需要在线程之间交换原始字节数据，则可以使用 Java IO 的管道。
 */
public class PipedInputOutputStreamMain {

    public static void main(String[] args) throws IOException {

        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream  input  = new PipedInputStream(output);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("Hello world, pipe!".getBytes());
                } catch (IOException e) {
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int data = input.read();
                    while(data != -1){
                        System.out.print((char) data);
                        data = input.read();
                    }
                } catch (IOException e) {
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
