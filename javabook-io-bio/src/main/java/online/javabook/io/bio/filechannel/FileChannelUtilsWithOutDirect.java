package online.javabook.io.bio.filechannel;

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
	public void closeFileChannel(FileChannel fileChannel) throws IOException {
		fileChannel.close();
	}

	// --------------------------------------------------
	// read/write
	// --------------------------------------------------

	@Override
	public int read(FileChannel fileChannel, ByteBuffer byteBuffer)throws IOException {
		return fileChannel.read(byteBuffer);
	}

	@Override
	public void write(FileChannel fileChannel, ByteBuffer byteBuffer, String value) throws IOException {

		byte[] bytes = value.getBytes();
		if(byteBuffer.remaining()>bytes.length) {
		}else{
			byteBuffer.flip();
			fileChannel.write(byteBuffer);
			byteBuffer.clear();
		}
		byteBuffer.put( bytes );

		byteBuffer.flip();
		fileChannel.write(byteBuffer);
		byteBuffer.clear();
	}
}