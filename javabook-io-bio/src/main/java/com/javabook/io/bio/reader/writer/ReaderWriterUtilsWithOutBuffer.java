package com.javabook.io.bio.reader.writer;

import java.io.*;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ReaderWriterUtilsWithOutBuffer implements ReaderWriterUtils {

	// --------------------------------------------------
	// FileReader
	// --------------------------------------------------
	
	@Override
	public FileReader openInputStream(String file) throws IOException {
		FileReader reader = new FileReader(file);
		return reader;
	}

	@Override
	public int read(Reader reader)throws IOException {
		return reader.read();
	}

	@Override
	public void closeInputStream(Reader reader) throws IOException {
		reader.close();
	}

	// --------------------------------------------------
	// FileWriter
	// --------------------------------------------------
	
	@Override
	public FileWriter openOutputStream(String file) throws IOException {
		FileWriter writer = new FileWriter(file);		
		return writer;
	}

	@Override
	public void write(Writer writer, String value) throws IOException {
		writer.write(value);
	}

	@Override
	public void closeOutputStream(Writer writer) throws IOException {
		writer.close();
	}

}
