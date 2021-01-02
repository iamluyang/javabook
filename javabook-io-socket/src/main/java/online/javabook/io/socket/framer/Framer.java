package online.javabook.io.socket.framer;

import java.io.IOException;
import java.io.OutputStream;

public interface Framer {

	/**
	 * @param message
	 * @param out
	 * @throws IOException
	 */
	void sendMessage(byte[] message, OutputStream out) throws IOException;

	/**
	 * @return
	 * @throws IOException
	 */
	byte[] reveiveMessage() throws IOException;
}
