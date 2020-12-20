package com.javabook.io.bio.filechannel;

import com.javabook.io.bio.Perforamce;

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
public class FileChannelUtilsMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		int count = 1000000;
		test(count, new FileChannelUtilsWithDirect(), "C:\\FileChannelUtilsWithDirect.txt");
		System.out.println();
		test(count, new FileChannelUtilsWithOutDirect(), "C:\\FileChannelUtilsWithOutDirect.txt");
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

		perforamce.start();

		ByteBuffer bb1 = fileChannelUtils.openByteBuffer(102400);
		FileChannel fileChannel1 = fileChannelUtils.openFileChannel(fileName);
		for (int i = 0; i < count; i++) {
			fileChannelUtils.write(fileChannel1, bb1, "a");
		}

		perforamce.stop(fileChannelUtils.getClass().getSimpleName() + ".write()");

		// --------------------------------------------------
		// read
		// --------------------------------------------------

		perforamce.start();

		ByteBuffer bb2 = fileChannelUtils.openByteBuffer(102400);
		while(fileChannelUtils.read(fileChannel1, bb2)>0);
		fileChannelUtils.closeFileChannel(fileChannel1);

		perforamce.stop(fileChannelUtils.getClass().getSimpleName() + ".read()");
	}
}
