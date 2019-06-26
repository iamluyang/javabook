package com.javabook.io.bio.bb;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author LuYang
 *
 */
public abstract class ByteBufferProxy implements ByteBuff{

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
	// read
	// --------------------------------------------------
	
	@Override
	public int read(FileChannel fc, ByteBuffer bb)throws IOException {		
		return fc.read(bb);
	}

	// --------------------------------------------------
	// write
	// --------------------------------------------------
	
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
