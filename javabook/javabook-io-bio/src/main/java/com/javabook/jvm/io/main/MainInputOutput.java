package com.javabook.jvm.io.main;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.javabook.bio.profile.Profile;
import com.javabook.jvm.io.by.InputOutput;
import com.javabook.jvm.io.by.InputOutputWithBuffer;
import com.javabook.jvm.io.by.InputOutputWithOutBuffer;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 *
 */
public class MainInputOutput {

	public static void main(String[] args) throws IOException {
		
		// count
		int count = 100000000;

		// --------------------------------------------------
		// InputOutputWithOutBuffer
		// --------------------------------------------------
		
		String withOutBufferFile = "MainInputOutput-withOutBuffer.txt";
		File file1 = new File(withOutBufferFile);
		if(file1.exists()) file1.delete();
		InputOutput withOutBuffer = new InputOutputWithOutBuffer();

		// --------------------------------------------------
		// InputOutputWithOutBuffer - write
		// --------------------------------------------------
		
		// withOutBuffer - write
		Profile profile1 = new Profile();
		profile1.start();
		
		OutputStream writer1 = withOutBuffer.openOutputStream(withOutBufferFile);
		for (int i = 0; i < count; i++) {
			withOutBuffer.write(writer1, "a");
		}		
		withOutBuffer.closeOutputStream(writer1);
		
		profile1.stop("withOutBuffer.write()", 1);

		// --------------------------------------------------
		// InputOutputWithOutBuffer - read
		// --------------------------------------------------
		
		// withOutBuffer - 
		Profile profile2 = new Profile();
		profile2.start();
		
		InputStream reader1 = withOutBuffer.openInputStream(withOutBufferFile);
		while(withOutBuffer.read(reader1)!=null);
		withOutBuffer.closeInputStream(reader1);
		
		profile2.stop("withOutBuffer.read()", 1);
		
		// --------------------------------------------------
		// InputOutputWithOutBuffer
		// --------------------------------------------------
		
		String withBufferFile = "MainInputOutput-withBuffer.txt";
		File file2 = new File(withBufferFile);
		if(file2.exists()) file2.delete();
		InputOutput withBuffer    = new InputOutputWithBuffer();

		// --------------------------------------------------
		// InputOutputWithBuffer - write
		// --------------------------------------------------
		
		// withBuffer - write
		Profile profile3 = new Profile();
		profile3.start();
		
		OutputStream writer2 = withBuffer.openOutputStream(withBufferFile);
		for (int i = 0; i < count; i++) {
			withBuffer.write(writer2, "a");
		}	
		withOutBuffer.closeOutputStream(writer2);
		
		profile3.stop("withBuffer.write()", 1);		
		
		// --------------------------------------------------
		// ReaderWriterWithBuffer - read
		// --------------------------------------------------
		
		Profile profile4 = new Profile();
		profile4.start();
		
		InputStream reader2 = withBuffer.openInputStream(withBufferFile);
		while(withBuffer.read(reader2)!=null);
		withBuffer.closeInputStream(reader2);
		
		profile4.stop("withBuffer.read()", 1);
	}
}
