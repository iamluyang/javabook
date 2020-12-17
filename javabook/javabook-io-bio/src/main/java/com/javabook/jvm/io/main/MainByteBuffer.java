package com.javabook.jvm.io.main;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import com.javabook.bio.profile.Profile;
import com.javabook.jvm.io.bb.ByteBuff;
import com.javabook.jvm.io.bb.ByteBufferWithDirect;
import com.javabook.jvm.io.bb.ByteBufferWithOutDirect;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class MainByteBuffer {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// count
		int count = 100000000;

		// --------------------------------------------------
		// ByteBufferWithOutDirect
		// --------------------------------------------------

		String withOutDirectFile = "MainByteBuffer-withOutDirect.txt";
		File file1 = new File(withOutDirectFile);
		if(file1.exists()) file1.delete();
		ByteBuff withOutDirect = new ByteBufferWithOutDirect();

		// --------------------------------------------------
		// ByteBufferWithOutDirect - write
		// --------------------------------------------------

		Profile profile1 = new Profile();
		profile1.start();
		
		ByteBuffer bb1 = withOutDirect.openByteBuffer(102400);
		FileChannel fileChannel1 = withOutDirect.openFileChannel(withOutDirectFile);
		for (int i = 0; i < count; i++) {
			withOutDirect.write(fileChannel1, bb1, "a");
		}				
		
		profile1.stop("withOutDirect.write()", count);

		// --------------------------------------------------
		// ByteBufferWithOutDirect - read
		// --------------------------------------------------

		Profile profile2 = new Profile();
		profile2.start();
		
		ByteBuffer bb2 = withOutDirect.openByteBuffer(102400);
		while(withOutDirect.read(fileChannel1, bb2)>0);
		withOutDirect.closeFileChannel(fileChannel1);
		
		profile2.stop("withOutDirect.read()", count);
		
		// --------------------------------------------------
		// ByteBufferWithDirect
		// --------------------------------------------------

		String withBufferFile = "MainByteBuffer-withDirect.txt";
		File file2 = new File(withBufferFile);
		if(file2.exists()) file2.delete();
		ByteBuff withDirect = new ByteBufferWithDirect();
		
		// --------------------------------------------------
		// ByteBufferWithDirect - write
		// --------------------------------------------------

		Profile profile3 = new Profile();
		profile3.start();		
		
		ByteBuffer bb3 = withOutDirect.openByteBuffer(102400);
		FileChannel fileChannel2 = withDirect.openFileChannel(withBufferFile);
		for (int i = 0; i < count; i++) {
			withDirect.write(fileChannel2, bb3, "a");
		}
		
		profile3.stop("withDirect.write()", count);
		
		// --------------------------------------------------
		// ByteBufferWithDirect - read
		// --------------------------------------------------

		Profile profile4 = new Profile();
		profile4.start();
		
		ByteBuffer bb4 = withOutDirect.openByteBuffer(102400);
		while(withDirect.read(fileChannel2, bb4)>0);
		withOutDirect.closeFileChannel(fileChannel2);
		
		profile4.stop("withDirect.read()", count);
		
	}
}
