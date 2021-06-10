package online.javabook.io.nio.mmp;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * https://techmytalk.com/2014/11/05/java-nio-memory-mapped-files/
 *
 * 在 Java 的早期版本中，使用 FileSystem 常规 API 来访问系统文件。
 * 在后台，JVM 进行 read() 和 write() 系统调用，以将数据从 OS 内核传输到 JVM。
 * JVM 利用它的内存空间来加载和处理会导致大数据文件进程出现问题的文件。文件页面在处理文件数据之前转换到JVM系统，
 * 因为操作系统在页面中处理文件，但JVM使用与页面不兼容的字节流。
 *
 * 在 JDK 1.4 及以上版本中，Java 提供了 MappedByteBuffer，它有助于建立从 JVM 空间到文件系统页面的虚拟内存映射。
 * 这消除了将文件内容从操作系统内核空间传输和处理到 JVM 空间的开销。操作系统使用虚拟内存将文件缓存在内核空间之外，可以与其他非内核进程共享。
 *
 * ---------------------------------------------------------------
 *
 * MappedByteBuffer 通过FileChannel 中的map 方法直接映射到Virtual Memory 中打开的文件。
 * MappedByteBuffer 对象的工作方式类似于缓冲区，但其数据存储在虚拟内存上的文件中。
 * MappedByteBuffer 上的 get() 方法从文件中获取数据，这些数据将代表存储在磁盘中的当前文件数据。
 * 以类似的方式 put() 方法直接更新磁盘上的内容，修改后的内容将对文件的其他读者可见。
 * 通过 MappedByteBuffer 处理文件具有很大的优势，因为它不会对文件进行任何系统调用以提高延迟。
 * 除了 Virtual Memory 中的 File 缓存将由 MappedByteBuffer 直接访问且不消耗 JVM 空间的内存页面。
 * 唯一的缺点是如果请求的页面不在内存中，它会抛出页面错误。
 *
 */
public class MappedByteBufferMain {
    public static void main(String[] args) throws IOException {
        int count = 10;
        RandomAccessFile randomAccessFile = new RandomAccessFile("./javabook-io-nio/testdata/from.7z", "rw");
        MappedByteBuffer out = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);
        for (int i = 0; i < count; i++) {
            out.put((byte) 'A');
        }
        for (int i = 0; i < count; i++) {
            System.out.print((char) out.get(i));
        }
    }
}
