package com.javabook.jvm.io.rw;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-26
 *
 */
public class ReaderWriterWithOutBuffer extends ReaderWriterProxy {

	// --------------------------------------------------
	// FileReader
	// --------------------------------------------------
	
	@Override
	public FileReader openInputStream(String file) throws IOException {
		FileReader reader = new FileReader(file);
		return reader;
	}
	
	// --------------------------------------------------
	// FileWriter
	// --------------------------------------------------
	
	@Override
	public FileWriter openOutputStream(String file) throws IOException {
		FileWriter writer = new FileWriter(file);		
		return writer;
	}

}
