package online.javabook.jdk.nio.performance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BioAndNioPerformance {

    public static void main(String[] args) throws Exception {

        String src = "D:/source.iso";
        String desc1 = "D:/target1.iso";
        String desc2 = "D:/target2.iso";
        BioAndNioPerformance bioAndNIO = new BioAndNioPerformance();
        bioAndNIO.nio(src, desc1);
        bioAndNIO.bio(src, desc2);
    }

    private void bio(String src, String dest) throws IOException {

        long start = System.currentTimeMillis();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream( src );
            fileOutputStream = new FileOutputStream( dest);

            byte[] buffer = new byte[1024*1024 *100];
            while (true) {
                int len = fileInputStream.read(buffer);
                if (len == -1) {
                    break;
                }
                fileOutputStream.write( buffer, 0, len);
            }
        } catch (IOException e) {
            if(null != fileInputStream) {
                fileInputStream.close();
            }
            if(null != fileOutputStream) {
                fileOutputStream.close();
            }
        }

        long finish = System.currentTimeMillis();
        System.out.println("BIO耗时:" + (finish - start) + "ms");
    }

    private static void nio(String src,String dest) throws IOException {

        long start = System.currentTimeMillis();
        FileChannel fileChannelSrc = null;
        FileChannel fileChannelDest = null;
        try {
            fileChannelSrc = new FileInputStream(src).getChannel();
            fileChannelDest = new FileOutputStream(dest).getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 1024 * 100);
            while (fileChannelSrc.read(byteBuffer) != -1) {
                byteBuffer.flip();
                fileChannelDest.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(null != fileChannelSrc) {
                fileChannelSrc.close();
            }
            if(null != fileChannelDest) {
                fileChannelDest.close();
            }
        }

        long finish = System.currentTimeMillis();
        System.out.println("NIO耗时:" + (finish - start) + "ms");
    }
}
