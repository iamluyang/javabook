package online.javabook.io.perforamce.channel;

import online.javabook.io.perforamce.Perforamce;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class FileChannelUtilsMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int count = 1024 * 1024;
		test(count, new FileChannelUtilsWithDirect(), "D:/FileChannelUtilsWithDirect.txt");
		System.out.println();
		test(count, new FileChannelUtilsWithOutDirect(), "D:/FileChannelUtilsWithOutDirect.txt");
	}

	private static void test(int count, FileChannelUtils fileChannelUtils, String fileName) throws IOException {

		Perforamce perforamce = new Perforamce();

		// --------------------------------------------------
		// delete
		// --------------------------------------------------

		File file = new File(fileName);
		if(file.exists()) file.delete();

		// --------------------------------------------------
		// write
		// --------------------------------------------------

		ByteBuffer writeByteBuffer = fileChannelUtils.openByteBuffer(count);
		java.nio.channels.FileChannel writeFileChannel = fileChannelUtils.openWriteFileChannel(fileName);

		perforamce.start();
		for (int i = 0; i < count; i++) {
			fileChannelUtils.write(writeFileChannel, writeByteBuffer, "1");
		}
		fileChannelUtils.flush(writeFileChannel, writeByteBuffer);
		perforamce.stop(fileChannelUtils.getClass().getSimpleName() + ".write()", count);

		fileChannelUtils.closeFileChannel(writeFileChannel);

		// --------------------------------------------------
		// read
		// --------------------------------------------------

		ByteBuffer readByteBuffer = fileChannelUtils.openByteBuffer(count);
		java.nio.channels.FileChannel readFileChannel = fileChannelUtils.openReadFileChannel(fileName);

		perforamce.start();
		int bytesRead = readFileChannel.read(readByteBuffer);
		while(bytesRead > 0) {
			readByteBuffer.flip();  //make buffer ready for read
			while(readByteBuffer.hasRemaining()){
				String a = new String(new byte[]{readByteBuffer.get()}); // read 1 byte at a time
			}

			readByteBuffer.clear(); //make buffer ready for writing
			bytesRead = fileChannelUtils.read(readFileChannel, readByteBuffer);
		}
		perforamce.stop(fileChannelUtils.getClass().getSimpleName() + ".read()", count);
		fileChannelUtils.closeFileChannel(readFileChannel);
	}
}
