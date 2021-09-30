package online.javabook.jdk.nio.channel.filechannel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java NIO FileChannel是连接到文件的通道。使用文件通道，您可以从文件读取数据，也可以将数据写入文件。
 * Java NIO FileChannel类是一种替代方法，依然可以继续使用标准Java IO API读取文件。
 * FileChannel无法设置为非阻止模式。它始终以阻止模式运行。
 */
public class FileChannelExample {
    public static void main(String[] args) throws IOException {

        // 打开一个文件通道
        RandomAccessFile randomAccessFile = new RandomAccessFile("./javabook-io-nio/testdata/FileChannelExample.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();

        // -----------------------------------------------------------------------------
        // FileChannel位置
        // FileChannel.position(long pos)方法来设置读写的位置
        // -----------------------------------------------------------------------------
        long position = channel.position();
        System.out.println("position:" + position);

        // -----------------------------------------------------------------------------
        // FileChannel大小
        // FileChannel.size()方法返回通道连接到的文件的文件大小
        // -----------------------------------------------------------------------------
        long fileSize = channel.size();
        System.out.println("fileSize:" + fileSize);
        channel.position(fileSize);

        // -----------------------------------------------------------------------------
        // 将数据写入文件通道
        // -----------------------------------------------------------------------------
        String newData = "34567890";

        ByteBuffer writeBuffer = ByteBuffer.allocate(48);
        writeBuffer.clear();
        writeBuffer.put(newData.getBytes());

        writeBuffer.flip();
        while(writeBuffer.hasRemaining()) {
            channel.write(writeBuffer);
        }

        // -----------------------------------------------------------------------------
        // FileChannel强制
        // FileChannel.force()方法将所有未写入的数据从通道刷新到磁盘
        // 出于性能原因，操作系统可能会将数据缓存在内存中，因此，除非您调用该force()方法，否则不能保证写入通道的数据实际上已写入磁盘
        // -----------------------------------------------------------------------------
        channel.force(true);

        // -----------------------------------------------------------------------------
        // 从文件通道读取数据
        // -----------------------------------------------------------------------------
        ByteBuffer readBuffer = ByteBuffer.allocate(48);
        int bytesRead = channel.read(readBuffer);
        System.out.println(bytesRead);

        // -----------------------------------------------------------------------------
        // FileChannel截断
        // FileChannel.truncate()方法截断文件。截断文件时，会以给定的长度将其剪切掉
        // -----------------------------------------------------------------------------
        channel.truncate(2);

        // -----------------------------------------------------------------------------
        // 关闭文件通道
        // -----------------------------------------------------------------------------
        channel.close();

    }
}
