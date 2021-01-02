package online.javabook.io.bio.reader.writer;

import java.io.*;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ReaderWriterUtilsWithBuffer implements ReaderWriterUtils {

	// --------------------------------------------------
	// BufferedReader
	// --------------------------------------------------
	
	@Override
	public BufferedReader openInputStream(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));		
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
	// BufferedWriter
	// --------------------------------------------------
	
	@Override
	public BufferedWriter openOutputStream(String file) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));		
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
