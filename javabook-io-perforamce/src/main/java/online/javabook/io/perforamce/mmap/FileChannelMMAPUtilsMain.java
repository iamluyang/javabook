package online.javabook.io.perforamce.mmap;

import online.javabook.io.perforamce.Perforamce;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class FileChannelMMAPUtilsMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int count = 1024 * 1024;
		test(count, new FileChannelMMAPUtilsWithDirect(), "D:/FileChannelMMAPUtilsWithDirect.txt");
	}

	private static void test(int count, FileChannelMMAPUtils fileChannelUtils, String fileName) throws IOException {

		Perforamce perforamce = new Perforamce();

		// --------------------------------------------------
		// delete
		// --------------------------------------------------

		File file = new File(fileName);
		if(file.exists()) file.delete();

		// --------------------------------------------------
		// write
		// --------------------------------------------------

		FileChannel writeFileChannel = fileChannelUtils.openFileChannel(fileName);
		ByteBuffer writeByteBuffer = fileChannelUtils.mmap(writeFileChannel, FileChannel.MapMode.READ_WRITE, 0, count);

		perforamce.start();
		for (int i = 0; i < count; i++) {
			writeByteBuffer.put("1".getBytes());
		}
		perforamce.stop(fileChannelUtils.getClass().getSimpleName() + ".write()", count);

		fileChannelUtils.closeFileChannel(writeFileChannel);

		// --------------------------------------------------
		// read
		// --------------------------------------------------

		FileChannel readFileChannel = fileChannelUtils.openFileChannel(fileName);
		ByteBuffer readByteBuffer = fileChannelUtils.mmap(readFileChannel, FileChannel.MapMode.READ_ONLY, 0, count);

		perforamce.start();
		while(readByteBuffer.hasRemaining()) {
			readByteBuffer.get();
		}
		perforamce.stop(fileChannelUtils.getClass().getSimpleName() + ".read()", count);

		fileChannelUtils.closeFileChannel(readFileChannel);
	}
}
