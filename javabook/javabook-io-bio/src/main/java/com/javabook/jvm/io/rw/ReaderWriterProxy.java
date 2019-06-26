package com.javabook.jvm.io.rw;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-26
 *
 */
public abstract class ReaderWriterProxy implements ReaderWriter{

	// --------------------------------------------------
	// Reader
	// --------------------------------------------------
	
	@Override
	public int read(Reader reader)throws IOException {
		return reader.read();
	}
	
	@Override
	public void closeInputStream(Reader reader) throws IOException {
		reader.close();
	}
	
	// --------------------------------------------------
	// Writer
	// --------------------------------------------------
	
	@Override
	public void write(Writer writer, String value) throws IOException {
		writer.write(value);	
	}
	
	@Override
	public void closeOutputStream(Writer writer) throws IOException {
		writer.close();	
	}

}
