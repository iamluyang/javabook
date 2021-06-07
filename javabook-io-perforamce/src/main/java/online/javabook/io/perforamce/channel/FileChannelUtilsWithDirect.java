package online.javabook.io.perforamce.channel;

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
public class FileChannelUtilsWithDirect implements FileChannelUtils {

	@Override
	public ByteBuffer openByteBuffer(int buffer) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(buffer);
		return byteBuffer;
	}

	// --------------------------------------------------
	// open/close
	// --------------------------------------------------

	@Override
	public java.nio.channels.FileChannel openFileChannel(String file) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
		java.nio.channels.FileChannel fileChannel = randomAccessFile.getChannel();
		return fileChannel;
	}

	@Override
	public java.nio.channels.FileChannel openReadFileChannel(String file) throws IOException {
		FileInputStream randomAccessFile = new FileInputStream(file);
		java.nio.channels.FileChannel fileChannel = randomAccessFile.getChannel();
		return fileChannel;
	}

	@Override
	public java.nio.channels.FileChannel openWriteFileChannel(String file) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		java.nio.channels.FileChannel fileChannel = fileOutputStream.getChannel();
		return fileChannel;
	}

	@Override
	public void closeFileChannel(java.nio.channels.FileChannel fileChannel) throws IOException {
		fileChannel.close();
	}

	// --------------------------------------------------
	// read/write
	// --------------------------------------------------

	@Override
	public int read(java.nio.channels.FileChannel fileChannel, ByteBuffer byteBuffer)throws IOException {
		int length = fileChannel.read(byteBuffer);
		return length;
	}

	@Override
	public void write(java.nio.channels.FileChannel fileChannel, ByteBuffer byteBuffer, String value) throws IOException {

		byte[] bytes = value.getBytes();
		if(byteBuffer.remaining() != 0) {
			byteBuffer.put( bytes );

		}else{
			byteBuffer.flip();
			fileChannel.write(byteBuffer);
			byteBuffer.clear();
		}
	}

	@Override
	public void flush(FileChannel fileChannel, ByteBuffer byteBuffer) throws IOException {
		byteBuffer.flip();
		fileChannel.write(byteBuffer);
		byteBuffer.clear();
	}
}