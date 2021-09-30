package online.javabook.jdk.nio.component.channel;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel02_read {
    public static void main(String[] args) throws Exception {

        //创建文件的输入流
        File file02 = new File("javabook.jdk/javabook.jdk.nio/mock/channel/file02.txt");
        FileInputStream fileInputStream = new FileInputStream(file02);

        //通过fileInputStream 获取对应的FileChannel -> 实际类型  FileChannelImpl
        FileChannel fileChannel = fileInputStream.getChannel();

        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file02.length());

        //将通道的数据读入到Buffer
        fileChannel.read(byteBuffer);

        //将byteBuffer 的 字节数据 转成String
        System.out.println(new String(byteBuffer.array()));
        fileInputStream.close();

    }
}
