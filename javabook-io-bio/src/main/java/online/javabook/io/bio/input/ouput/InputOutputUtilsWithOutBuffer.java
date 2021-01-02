package online.javabook.io.bio.input.ouput;

import java.io.*;


public class InputOutputUtilsWithOutBuffer implements InputOutputUtils {

	// --------------------------------------------------
	// InputStream
	// --------------------------------------------------

	@Override
	public OutputStream openOutputStream(String file) throws IOException {
		OutputStream os = new DataOutputStream(new FileOutputStream(file));
		return os;
	}

	@Override
	public void write(OutputStream outputStream, String value) throws IOException {
		((DataOutputStream)outputStream).writeChars(value);
	}

	@Override
	public void closeOutputStream(OutputStream outputStream) throws IOException {
		outputStream.close();
	}

	// --------------------------------------------------
	// InputStream
	// --------------------------------------------------

	@Override
	public DataInputStream openInputStream(String file) throws IOException {
		DataInputStream is = new DataInputStream(new FileInputStream(file));
		return is;
	}

	@Override
	public String read(InputStream inputStream)throws IOException {
		DataInputStream dataInputStream = (DataInputStream)inputStream;
		return dataInputStream.readLine();
	}

	@Override
	public void closeInputStream(InputStream inputStream) throws IOException {
		inputStream.close();
	}

}
