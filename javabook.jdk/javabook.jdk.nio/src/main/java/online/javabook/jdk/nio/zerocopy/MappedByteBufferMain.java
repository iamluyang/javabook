package online.javabook.jdk.nio.zerocopy;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * MappedByteBuffer可让文件直接在内存(堆外内存)修改, 操作系统不需要拷贝一次
 *
 * 零拷贝是从操作系统的角度来说的。因为内核缓冲区之间，没有数据是重复的（只有 kernel buffer 有一份数据）。
 * 零拷贝不仅仅带来更少的数据复制，还能带来其他的性能优势，例如更少的上下文切换，更少的 CPU 缓存伪共享以及无 CPU 校验和计算。
 *
 * 应用程序（用户态）
 * -> DMA复制磁盘的数据到内核态的缓冲区
 * -> 用户态的内存映射和内核态共享缓冲区
 * -> 复制内核的态缓冲区到套接字的缓冲区
 * -> 复制套接字的缓冲区到内核网络协议栈
 */
public class MappedByteBufferMain {

    public static void main(String[] args) throws Exception {

        // 创建随机访问文件
        String file = "javabook.jdk/javabook.jdk.nio/mock/mapped/file.txt";
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");

        // 获取对应的访问通道
        FileChannel fileChannel = randomAccessFile.getChannel();

        /**
         * 参数1: FileChannel.MapMode.READ_WRITE 使用的读写模式
         * 参数2：1可以直接修改的起始位置
         * 参数3: 10是映射到内存的大小(不是索引位置) ,即将file.txt中的多少个字节映射到内存
         * 可以直接修改的范围就是 0-10
         * 实际类型 DirectByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 10);
        System.out.println("mappedByteBuffer:"+mappedByteBuffer);

        mappedByteBuffer.put(0, (byte) '0');
        mappedByteBuffer.put(3, (byte) '3');
        mappedByteBuffer.put(5, (byte) '5');
        mappedByteBuffer.put(9, (byte) '9');

        //IndexOutOfBoundsException
        mappedByteBuffer.put(10, (byte) 'x');

        randomAccessFile.close();
        System.out.println("修改成功");


    }
}
