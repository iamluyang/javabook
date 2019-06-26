package com.javabook.jvm.io.main;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import com.javabook.bio.profile.Profile;
import com.javabook.jvm.io.rw.ReaderWriter;
import com.javabook.jvm.io.rw.ReaderWriterWithBuffer;
import com.javabook.jvm.io.rw.ReaderWriterWithOutBuffer;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-26
 *
 */
public class MainReaderWriter {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// count
		int count = 100000000;

		// --------------------------------------------------
		// ReaderWriterWithOutBuffer
		// --------------------------------------------------
		
		String withOutBufferFile = "MainReaderWriter-withOutBuffer.txt";
		File file1 = new File(withOutBufferFile);
		if(file1.exists()) file1.delete();		
		ReaderWriter withOutBuffer = new ReaderWriterWithOutBuffer();

		// --------------------------------------------------
		// ReaderWriterWithOutBuffer - write
		// --------------------------------------------------
		
		Profile profile1 = new Profile();
		profile1.start();

		Writer writer1 = withOutBuffer.openOutputStream(withOutBufferFile);
		for (int i = 0; i < count; i++) {
			withOutBuffer.write(writer1, "a");
		}		
		withOutBuffer.closeOutputStream(writer1);

		profile1.stop("withOutBuffer.write()", count);

		// --------------------------------------------------
		// withOutBuffer - read
		// --------------------------------------------------

		Profile profile2 = new Profile();
		profile2.start();
		
		Reader reader1 = withOutBuffer.openInputStream(withOutBufferFile);
		while(withOutBuffer.read(reader1)!=-1);
		withOutBuffer.closeInputStream(reader1);
		
		profile2.stop("withOutBuffer.read()", count);
		
		// --------------------------------------------------
		// ReaderWriterWithBuffer
		// --------------------------------------------------
		
		String withBufferFile = "MainReaderWriter-withBuffer.txt";
		File file2 = new File(withBufferFile);
		if(file2.exists()) file2.delete();
		ReaderWriter withBuffer = new ReaderWriterWithBuffer();
		
		// --------------------------------------------------
		// ReaderWriterWithBuffer - write
		// --------------------------------------------------
		
		Profile profile3 = new Profile();
		profile3.start();
		
		Writer writer2 = withBuffer.openOutputStream(withBufferFile);
		for (int i = 0; i < count; i++) {
			withBuffer.write(writer2, "a");
		}	
		withOutBuffer.closeOutputStream(writer2);
		
		profile3.stop("withBuffer.write()", count);
		
		// --------------------------------------------------
		// ReaderWriterWithBuffer - read
		// --------------------------------------------------
		
		Profile profile4 = new Profile();
		profile4.start();
		
		Reader reader2 = withBuffer.openInputStream(withOutBufferFile);
		while(withBuffer.read(reader2)!=-1);
		withBuffer.closeInputStream(reader2);
		
		profile4.stop("withBuffer.read()", count);
	}
}
