package online.javabook.io.bio.filechannel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public interface FileChannelUtils {

	// --------------------------------------------------
	// open/close
	// --------------------------------------------------
	
	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public FileChannel openFileChannel(String file)throws IOException;

	/**
	 * @param fc
	 * @throws IOException
	 */
	public void closeFileChannel(FileChannel fc)throws IOException;

	// --------------------------------------------------
	// read/write
	// --------------------------------------------------

	/**
	 * @param fileChannel
	 * @param bb
	 * @return
	 * @throws IOException
	 */
	public int read(FileChannel fileChannel, ByteBuffer bb) throws IOException;

	/**
	 * @param fileChannel
	 * @param bb
	 * @param value
	 * @throws IOException
	 */
	public void write(FileChannel fileChannel, ByteBuffer bb, String value) throws IOException;

	// --------------------------------------------------
	// openByteBuffer
	// --------------------------------------------------

	/**
	 * @param buffer
	 * @return
	 * @throws IOException
	 */
	public ByteBuffer openByteBuffer(int buffer)throws IOException;

}
