package online.javabook.io.perforamce.inouput;

import online.javabook.io.perforamce.Perforamce;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 *
 */
public class InputOutputUtilsMain {

	public static void main(String[] args) throws IOException {
		int count = 1024 * 1024;
		test(count, new InputOutputWithBuffer(), "D:\\InputOutputWithBuffer.txt");
		System.out.println();
		test(count, new InputOutputWithOutBuffer(), "D:\\InputOutputWithOutBuffer.txt");
	}

	private static void test(int count, InputOutputUtils inputOutputUtils, String fileName) throws IOException {

		Perforamce perforamce = new Perforamce();

		// --------------------------------------------------
		// delete
		// --------------------------------------------------

		File file = new File(fileName);
		if(file.exists()) file.delete();

		// --------------------------------------------------
		// write
		// --------------------------------------------------
		OutputStream outputStream = null;
		try {
			outputStream = inputOutputUtils.openOutputStream(fileName);

			perforamce.start();
			for (int i = 0; i < count; i++) {
				inputOutputUtils.write(outputStream, "1");
			}
			perforamce.stop(inputOutputUtils.getClass().getSimpleName() + ".write()", count);
		} finally {
			if(outputStream!=null){
				inputOutputUtils.closeOutputStream(outputStream);
			}
		}

		// --------------------------------------------------
		// read
		// --------------------------------------------------

		InputStream inputStream = null;
		try {
			inputStream = inputOutputUtils.openInputStream(fileName);

			perforamce.start();

			String oneChar = inputOutputUtils.read(inputStream);
			while(oneChar !=null) {
				oneChar = inputOutputUtils.read(inputStream);
			}

			perforamce.stop(inputOutputUtils.getClass().getSimpleName() + ".read()", count);

		} finally {
			if(inputOutputUtils!=null){
				inputOutputUtils.closeInputStream(inputStream);
			}
		}
	}
}
