package online.javabook.io.perforamce.readwriter;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public interface ReaderWriterUtils {

	// --------------------------------------------------
	// Reader
	// --------------------------------------------------
	
	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public Reader openInputStream(String file)throws IOException;

	/**
	 * @param reader
	 * @throws IOException
	 */
	public void closeInputStream(Reader reader)throws IOException;
	
	/**
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public String read(Reader reader) throws IOException;

	// --------------------------------------------------
	// Writer
	// --------------------------------------------------
	
	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public Writer openOutputStream(String file)throws IOException;

	/**
	 * @param writer
	 * @throws IOException
	 */
	public void closeOutputStream(Writer writer)throws IOException;

	/**
	 * @param writer
	 * @param value
	 * @throws IOException
	 */
	public void write(Writer writer, String value) throws IOException;

}
