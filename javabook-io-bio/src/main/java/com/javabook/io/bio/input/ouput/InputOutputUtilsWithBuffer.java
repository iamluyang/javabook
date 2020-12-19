package com.javabook.io.bio.input.ouput;

import java.io.*;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class InputOutputUtilsWithBuffer implements InputOutputUtils {

	// --------------------------------------------------
	// DataOutputStream
	// --------------------------------------------------

	@Override
	public OutputStream openOutputStream(String file) throws IOException {
		OutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		return os;
	}

	@Override
	public void write(OutputStream outputStream, String value) throws IOException {
		((DataOutputStream)outputStream).writeChars(value);
	}

	@Override
	public void closeOutputStream(OutputStream outputStream) throws IOException {
		outputStream.close();
	}

	// --------------------------------------------------
	// DataInputStream
	// --------------------------------------------------

	@Override
	public InputStream openInputStream(String file) throws IOException {
		DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		return is;
	}

	@Override
	public String read(InputStream inputStream)throws IOException {
		DataInputStream dataInputStream = (DataInputStream)inputStream;
		return dataInputStream.readLine();
	}

	@Override
	public void closeInputStream(InputStream inputStream) throws IOException {
		inputStream.close();
	}
}
