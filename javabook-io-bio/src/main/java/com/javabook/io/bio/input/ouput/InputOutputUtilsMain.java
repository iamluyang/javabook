package com.javabook.io.bio.input.ouput;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.javabook.io.bio.Perforamce;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 *
 */
public class InputOutputUtilsMain {

	public static void main(String[] args) throws IOException {
		int count = 100000;
		test(count, new InputOutputUtilsWithBuffer(), "C:\\InputOutputUtilsWithBuffer.txt");
		System.out.println();
		test(count, new InputOutputUtilsWithOutBuffer(), "C:\\InputOutputUtilsWithOutBuffer.txt");
	}

	private static void test(int count, InputOutputUtils inputOutputUtils, String fileName) throws IOException {

		Perforamce perforamce = new Perforamce();

		// --------------------------------------------------
		// delete
		// --------------------------------------------------

		File file1 = new File(fileName);
		if(file1.exists()) file1.delete();

		// --------------------------------------------------
		// write
		// --------------------------------------------------
		perforamce.start();
		OutputStream outputStream = null;
		try {
			outputStream = inputOutputUtils.openOutputStream(fileName);
			for (int i = 0; i < count; i++) {
				inputOutputUtils.write(outputStream, "a");
			}
		} finally {
			if(outputStream!=null){
				inputOutputUtils.closeOutputStream(outputStream);
			}
		}
		perforamce.stop(inputOutputUtils.getClass().getSimpleName() + ".write()");

		// --------------------------------------------------
		// read
		// --------------------------------------------------
		perforamce.start();
		InputStream inputStream = null;
		try {
			inputStream = inputOutputUtils.openInputStream(fileName);
			while(inputOutputUtils.read(inputStream)!=null);
		} finally {
			if(inputOutputUtils!=null){
				inputOutputUtils.closeInputStream(inputStream);
			}
		}
		perforamce.stop(inputOutputUtils.getClass().getSimpleName() + ".read()");
	}
}
