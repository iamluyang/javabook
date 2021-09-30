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
public class FileChannelUtilsWithOutDirect implements FileChannelUtils {

	@Override
	public ByteBuffer openByteBuffer(int buffer) throws IOException {
		ByteBuffer byteBuffer = ByteBuffer.allocate(buffer);
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
	public FileChannel openReadFileChannel(String file) throws IOException {
		FileInputStream randomAccessFile = new FileInputStream(file);
		FileChannel fileChannel = randomAccessFile.getChannel();
		return fileChannel;
	}

	@Override
	public FileChannel openWriteFileChannel(String file) throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		FileChannel fileChannel = fileOutputStream.getChannel();
		return fileChannel;
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
		if(byteBuffer.remaining() >= bytes.length) {
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