package online.javabook.jdk.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO socket是一种面向流的的I/O:
 * BIO的流的读写区分为输入流和输出流
 */
public class BioServer {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("server is running");

        while (true) {
            Socket acceptSocket = serverSocket.accept();
            System.out.println("accept connect：" + acceptSocket.toString());

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(acceptSocket);
                }
            });
        }
    }

    static void handler(Socket acceptSocket) {
        byte[] bytes = new byte[1024];
        try {
            InputStream inputStreamOfAcceptSocket = acceptSocket.getInputStream();
            while (true) {
                System.out.println("socket is reading......");
                int read = inputStreamOfAcceptSocket.read(bytes);
                System.out.println("socket read......");

                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                acceptSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
