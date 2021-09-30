package online.javabook.io.perforamce.readwriter;

import java.io.*;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class ReaderWriterWithBuffer implements ReaderWriterUtils {

	// --------------------------------------------------
	// BufferedReader
	// --------------------------------------------------
	
	@Override
	public BufferedReader openInputStream(String file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file), 8192);
		return reader;
	}

	@Override
	public String read(Reader reader)throws IOException {
		int c = reader.read();
		if(c == -1) {
			return null;
		}
		return new String(new char[]{(char) c} );
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
		BufferedWriter writer = new BufferedWriter(new FileWriter(file), 8192);
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
