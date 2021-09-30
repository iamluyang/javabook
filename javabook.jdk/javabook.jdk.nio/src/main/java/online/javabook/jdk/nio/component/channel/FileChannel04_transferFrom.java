package online.javabook.jdk.nio.component.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileChannel04_transferFrom {
    public static void main(String[] args) throws Exception {

        String file41 = "javabook.jdk/javabook.jdk.nio/mock/channel/file41.txt";
        String file42 = "javabook.jdk/javabook.jdk.nio/mock/channel/file42.txt";

        //创建相关流
        FileInputStream fileInputStream = new FileInputStream(file41);
        FileOutputStream fileOutputStream = new FileOutputStream(file42);

        //获取各个流对应的filechannel
        FileChannel sourceChannel = fileInputStream.getChannel();
        FileChannel destChannel   = fileOutputStream.getChannel();

        //使用transferForm完成拷贝
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

        //关闭相关通道和流
        sourceChannel.close();
        destChannel.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
