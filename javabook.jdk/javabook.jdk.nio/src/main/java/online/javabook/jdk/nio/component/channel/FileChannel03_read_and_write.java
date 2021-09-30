package online.javabook.jdk.nio.component.channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannel03_read_and_write {
    public static void main(String[] args) throws Exception {

        String file31 = "javabook.jdk/javabook.jdk.nio/mock/channel/file31.txt";
        String file32 = "javabook.jdk/javabook.jdk.nio/mock/channel/file32.txt";

        //创建相关流
        FileInputStream fileInputStream = new FileInputStream(file31);
        FileOutputStream fileOutputStream = new FileOutputStream(file32);

        //获取各个流对应的filechannel
        FileChannel fileChannel01 = fileInputStream.getChannel();
        FileChannel fileChannel02 = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {

            //这里有一个重要的操作，一定不要忘了
            /*public final Buffer clear() {
                position = 0;
                limit = capacity;
                mark = -1;
                return this;
            }*/

            //清空buffer
            byteBuffer.clear();
            int read = fileChannel01.read(byteBuffer);
            System.out.println("read =" + read);

            //表示读完
            if (read == -1) {
                break;
            }

            //将buffer 中的数据写入到 fileChannel02
            byteBuffer.flip();
            fileChannel02.write(byteBuffer);
        }

        //关闭相关的流
        fileInputStream.close();
        fileOutputStream.close();
    }
}
