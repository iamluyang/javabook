package online.javabook.io.perforamce.inouput;

import java.io.*;


public class InputOutputWithOutBuffer implements InputOutputUtils {

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
		outputStream.write(value.getBytes());
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
