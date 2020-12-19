package com.javabook.io.bio.filechannel;

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
		ByteBuffer bb = ByteBuffer.allocateDirect(buffer);
		return bb;
	}

	// --------------------------------------------------
	// open/close
	// --------------------------------------------------

	@Override
	public FileChannel openFileChannel(String file) throws IOException {
		RandomAccessFile os = new RandomAccessFile(file, "rw");
		FileChannel fc = os.getChannel();
		return fc;
	}

	@Override
	public void closeFileChannel(FileChannel fc) throws IOException {
		fc.close();
	}

	// --------------------------------------------------
	// read/write
	// --------------------------------------------------

	@Override
	public int read(FileChannel fc, ByteBuffer bb)throws IOException {
		return fc.read(bb);
	}

	@Override
	public void write(FileChannel fc, ByteBuffer bb, String value) throws IOException {

		byte[] bytes = value.getBytes();
		if(bb.remaining()>bytes.length) {
		}else{
			bb.flip();
			fc.write(bb);
			bb.clear();
		}
		bb.put( bytes );

		bb.flip();
		fc.write(bb);
		bb.clear();
	}
}