package com.javabook.io.bio.by;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public interface InputOutput {

	// --------------------------------------------------
	// InputStream
	// --------------------------------------------------
	
	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public InputStream openInputStream(String file)throws IOException;

	/**
	 * @param inputStream
	 * @throws IOException
	 */
	public void closeInputStream(InputStream inputStream)throws IOException;
	
	/**
	 * @param inputStream
	 * @throws IOException
	 */
	public String read(InputStream inputStream) throws IOException;

	// --------------------------------------------------
	// OutputStream
	// --------------------------------------------------
	
	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public OutputStream openOutputStream(String file)throws IOException;

	/**
	 * @param outputStream
	 * @throws IOException
	 */
	public void closeOutputStream(OutputStream outputStream)throws IOException;

	/**
	 * @param outputStream
	 * @param value
	 * @throws IOException
	 */
	public void write(OutputStream outputStream, String value) throws IOException;

}
