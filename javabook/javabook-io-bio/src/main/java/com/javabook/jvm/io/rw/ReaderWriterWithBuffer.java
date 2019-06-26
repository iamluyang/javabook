package com.javabook.jvm.io.rw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-26
 *
 */
public class ReaderWriterWithBuffer extends ReaderWriterProxy {

	// --------------------------------------------------
	// BufferedReader
	// --------------------------------------------------
	
	@Override
	public BufferedReader openInputStream(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));		
		return reader;
	}
	
	// --------------------------------------------------
	// BufferedWriter
	// --------------------------------------------------
	
	@Override
	public BufferedWriter openOutputStream(String file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));		
		return writer;
	}

}
