package com.javabook.io.bio.by;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public abstract class InputOutputProxy implements InputOutput{

	// --------------------------------------------------
	// InputStream
	// --------------------------------------------------
	
	@Override
	public String read(InputStream inputStream)throws IOException {
		DataInputStream dataInputStream = (DataInputStream)inputStream;
		return dataInputStream.readLine();
	}

	@Override
	public void closeInputStream(InputStream inputStream) throws IOException {
		inputStream.close();
	}
	
	// --------------------------------------------------
	// OutputStream
	// --------------------------------------------------
	
	@Override
	public void write(OutputStream outputStream, String value) throws IOException {		
		((DataOutputStream)outputStream).writeUTF(value);
	}
	
	@Override
	public void closeOutputStream(OutputStream outputStream) throws IOException {
		outputStream.close();	
	}

}
