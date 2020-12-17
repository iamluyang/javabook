package com.javabook.io.bio.bb;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ByteBufferWithDirect extends ByteBufferProxy {

	@Override
	public ByteBuffer openByteBuffer(int buffer) throws IOException {
		ByteBuffer bb = ByteBuffer.allocateDirect(buffer);
		return bb;
	}	
}