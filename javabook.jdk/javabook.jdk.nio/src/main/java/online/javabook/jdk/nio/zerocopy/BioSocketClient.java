package online.javabook.jdk.nio.zerocopy;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 应用程序（用户态）
 * -> DMA复制磁盘的数据到内核态的缓冲区
 * -> 复制内核态的缓冲区到用户态的缓冲区
 * -> 复制用户态的缓冲区到套接字的缓冲区
 * -> 复制套接字的缓冲区到内核网络协议栈
 */
public class BioSocketClient {

    public static void main(String[] args) throws Exception {
        // local file
        String fileName = "javabook.jdk/javabook.jdk.nio/mock/zerocopy/file.txt";
        InputStream inputStream = new FileInputStream(fileName);

        // client socket
        Socket clientSocket = new Socket("localhost", 7001);
        System.out.println("BIO客户端连接远程服务器:"+clientSocket);

        // 得到一个socket输出流
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
        long startTime = System.currentTimeMillis();

        int readCount;
        int readTotal = 0;
        byte[] buffer = new byte[4096];
        while ((readCount = inputStream.read(buffer)) >= 0) {
            readTotal += readCount;
            dataOutputStream.write(buffer, 0, readCount);
        }

        System.out.println("传输字节数:" + readTotal + ", 耗费时间:" + (System.currentTimeMillis() - startTime));

        dataOutputStream.close();
        clientSocket.close();
        inputStream.close();
        System.out.println("BIO客户端关闭本地的连接:"+clientSocket);
    }
}
