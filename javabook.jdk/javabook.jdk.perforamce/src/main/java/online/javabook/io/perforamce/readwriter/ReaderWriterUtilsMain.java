package online.javabook.io.perforamce.readwriter;

import online.javabook.io.perforamce.Perforamce;

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
		int count = 1024 * 1024;
		test(count, new ReaderWriterWithBuffer(), "D:\\ReaderWriterWithBuffer.txt");
		System.out.println();
		test(count, new ReaderWriterWithOutBuffer(), "D:\\ReaderWriterWithOutBuffer.txt");
	}

	private static void test(int count, ReaderWriterUtils readerWriter, String fileName) throws IOException {

		Perforamce perforamce = new Perforamce();

		// --------------------------------------------------
		// delete
		// --------------------------------------------------

		File file = new File(fileName);
		if(file.exists()) file.delete();

		// --------------------------------------------------
		// write
		// --------------------------------------------------

		Writer writer = null;
		try {
			writer = readerWriter.openOutputStream(fileName);

			perforamce.start();
			for (int i = 0; i < count; i++) {
				readerWriter.write(writer, "1");
			}
			perforamce.stop(readerWriter.getClass().getSimpleName() + ".write()", count);
		} finally {
			if(writer!=null) {
				readerWriter.closeOutputStream(writer);
			}
		}

		// --------------------------------------------------
		// read
		// --------------------------------------------------

		Reader reader = null;
		try {
			reader = readerWriter.openInputStream(fileName);

			perforamce.start();

			String oneChar = readerWriter.read(reader);
			while(oneChar!=null) {
				oneChar = readerWriter.read(reader);
			}

			perforamce.stop(readerWriter.getClass().getSimpleName() + ".read()", count);

		} finally {
			if(reader!=null) {
				readerWriter.closeInputStream(reader);
			}
		}
	}
}
