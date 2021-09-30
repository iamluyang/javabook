package online.javabook.io.perforamce.inouput;

import java.io.*;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-26
 *
 */
public class InputOutputWithBuffer implements InputOutputUtils {

	// --------------------------------------------------
	// DataOutputStream
	// --------------------------------------------------

	@Override
	public OutputStream openOutputStream(String file) throws IOException {
		OutputStream os = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file), 8192));
		return os;
	}

	@Override
	public void closeOutputStream(OutputStream outputStream) throws IOException {
		outputStream.close();
	}

	@Override
	public void write(OutputStream outputStream, String value) throws IOException {
		outputStream.write(value.getBytes());
	}

	// --------------------------------------------------
	// DataInputStream
	// --------------------------------------------------

	@Override
	public InputStream openInputStream(String file) throws IOException {
		DataInputStream is = new DataInputStream(new BufferedInputStream(new FileInputStream(file), 8192));
		return is;
	}

	@Override
	public String read(InputStream inputStream)throws IOException {
		byte oneByte = (byte)inputStream.read();
		if(oneByte != -1) {
			return new String(new byte[]{oneByte});
		}
		return null;
	}

	@Override
	public void closeInputStream(InputStream inputStream) throws IOException {
		inputStream.close();
	}
}
