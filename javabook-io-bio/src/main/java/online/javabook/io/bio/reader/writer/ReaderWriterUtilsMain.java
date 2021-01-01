package online.javabook.io.bio.reader.writer;

import online.javabook.io.bio.Perforamce;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ReaderWriterUtilsMain {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		
		// count
		int count = 1000000000;
		test(count, new ReaderWriterUtilsWithBuffer(), "C:\\ReaderWriterUtilsWithBuffer.txt");
		System.out.println();
		test(count, new ReaderWriterUtilsWithOutBuffer(), "C:\\ReaderWriterUtilsWithOutBuffer.txt");
	}

	private static void test(int count, ReaderWriterUtils readerWriterUtils, String fileName) throws IOException {

		Perforamce perforamce = new Perforamce();

		// --------------------------------------------------
		// delete
		// --------------------------------------------------

		File file = new File(fileName);
		if(file.exists()) file.delete();

		// --------------------------------------------------
		// write
		// --------------------------------------------------

		perforamce.start();

		Writer writer = null;
		try {
			writer = readerWriterUtils.openOutputStream(fileName);
			for (int i = 0; i < count; i++) {
				readerWriterUtils.write(writer, "a");
			}
		} finally {
			if(writer!=null) {
				readerWriterUtils.closeOutputStream(writer);
			}
		}

		perforamce.stop(readerWriterUtils.getClass().getSimpleName() + ".write()");

		// --------------------------------------------------
		// read
		// --------------------------------------------------

		perforamce.start();

		Reader reader = null;
		try {
			Reader reader1 = readerWriterUtils.openInputStream(fileName);
			while(readerWriterUtils.read(reader1)!=-1);
		} finally {
			if(reader!=null) {
				readerWriterUtils.closeInputStream(reader);
			}
		}

		perforamce.stop(readerWriterUtils.getClass().getSimpleName() + ".read()");
	}
}
