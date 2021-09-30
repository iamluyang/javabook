package online.javabook.io.perforamce.mmap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class FileChannelMMAPUtilsWithDirect implements FileChannelMMAPUtils {

	@Override
	public ByteBuffer openByteBuffer(int buffer) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(buffer);
		return byteBuffer;
	}

	// --------------------------------------------------
	// open/close
	// --------------------------------------------------

	@Override
	public FileChannel openFileChannel(String file) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		FileChannel fileChannel = randomAccessFile.getChannel();
		return fileChannel;
	}

	@Override
	public ByteBuffer mmap(FileChannel fileChannel, FileChannel.MapMode mode, long position, long size) throws IOException {
		return fileChannel.map(mode, position, size);
	}

	@Override
	public void closeFileChannel(FileChannel fileChannel) throws IOException {
		fileChannel.close();
	}

	// --------------------------------------------------
	// read/write
	// --------------------------------------------------

	@Override
	public int read(FileChannel fileChannel, ByteBuffer byteBuffer)throws IOException {
		int length = fileChannel.read(byteBuffer);
		return length;
	}

	@Override
	public void write(FileChannel fileChannel, ByteBuffer byteBuffer, String value) throws IOException {

		byte[] bytes = value.getBytes();
		if(byteBuffer.remaining() == 0) {
			byteBuffer.flip();
			fileChannel.write(byteBuffer);
			byteBuffer.clear();
		}else{
			byteBuffer.put( bytes );

		}
	}
}