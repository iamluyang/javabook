package online.javabook.jdk.nio.zerocopy;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicLong;

/**
 * BIO服务器
 */
public class BioSocketServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(7001);
        System.out.println("启动BIO服务器:" + serverSocket);

        while (true) {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            try {
                AtomicLong totalBytesCount = new AtomicLong();
                byte[] byteArray = new byte[4096];
                while (true) {
                    int readBytesCount = dataInputStream.read(byteArray, 0, byteArray.length);
                    if (-1 == readBytesCount) {
                        break;
                    } else {
                        totalBytesCount.addAndGet(readBytesCount);
                        System.out.println("总接收字节数:" + totalBytesCount + ";当前接收字节数:" + readBytesCount);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
