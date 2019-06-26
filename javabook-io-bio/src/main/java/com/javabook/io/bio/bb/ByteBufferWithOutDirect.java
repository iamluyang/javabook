package com.javabook.io.bio.bb;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-26
 *
 */
public class ByteBufferWithOutDirect extends ByteBufferProxy {

	@Override
	public ByteBuffer openByteBuffer(int buffer) throws IOException {
		ByteBuffer bb = ByteBuffer.allocate(buffer);
		return bb;
	}
}