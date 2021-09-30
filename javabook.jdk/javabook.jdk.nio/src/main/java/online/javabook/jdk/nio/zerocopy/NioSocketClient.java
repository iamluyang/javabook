package online.javabook.jdk.nio.zerocopy;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * mmap 和 sendFile 的区别
 * mmap 适合小数据量读写; sendFile适合大文件传输
 * mmap 需要4次上下文切换，3次数据拷贝；sendFile需要3次上下文切换，最少2次数据拷贝
 * sendFile 可以利用DMA方式，减少CPU拷贝，mmap必须从内核拷贝到Socket缓冲区
 *
 * 应用程序（用户态）
 * Linux2.1 sendFile
 * -> DMA复制磁盘的数据到内核态的缓冲区
 * -> 复制内核的态缓冲区到套接字的缓冲区
 * -> 复制套接字的缓冲区到内核网络协议栈
 *
 * Linux2.4 sendFile
 * -> DMA复制磁盘的数据到内核态的缓冲区
 * -> 复制内核的态缓冲区到内核网络协议栈
 */
public class NioSocketClient {
    public static void main(String[] args) throws Exception {

        // 创建文件channel
        String fileName = "javabook.jdk/javabook.jdk.nio/mock/zerocopy/file.txt";
        FileChannel fileChannel = new FileInputStream(fileName).getChannel();

        // 创建socketChannel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 7001));
        System.out.println("NIO客户端连接远程服务器:"+socketChannel);

        // 记录发送时间
        long startTime = System.currentTimeMillis();

        // 在linux下一次transferTo方法调用就可以完成传输
        // 在windows下一次transferTo方法调用只能发送8m, 就需要分段传输文件, 计算出下一次传输时的位置
        // transferTo底层使用到零拷贝
        long transferBytesCount = fileChannel.transferTo(0, fileChannel.size(), socketChannel);
        System.out.println("传输字节数:" + transferBytesCount + ", 耗费时间:" + (System.currentTimeMillis() - startTime));

        // 关闭文件通道
        fileChannel.close();
        System.out.println("NIO客户端关闭本地的通道:"+fileChannel);
    }
}
