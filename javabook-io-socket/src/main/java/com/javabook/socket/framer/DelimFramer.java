package com.javabook.socket.framer;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DelimFramer implements Framer {
	
	// data source
	private InputStream in; 
	
	/**
	 * message delimiter
	 */
	private static final byte DELIMITER = '\n';

	/**
	 * @param in
	 */
	public DelimFramer(InputStream in) {		
		this.in = in;
	}

	@Override
	public void sendMessage(byte[] message, OutputStream out) throws IOException {
		
		// ensure that the message does not contain the delimiter
		for (byte b : message) {
			if (b == DELIMITER) {
				throw new IOException("Message contains delimiter");
			}
		}
		
		out.write(message);
		out.write(DELIMITER);
		out.flush();
	}

	@Override
	public byte[] reveiveMessage() throws IOException {
		
		ByteArrayOutputStream messageBuffer = new ByteArrayOutputStream();
		int nextByte;

		// fetch bytes until find delimiter
		while ((nextByte = in.read()) != DELIMITER) {
			
			// end of stream?
			if (nextByte == -1) { 
				if (messageBuffer.size() == 0) { // if no byte read
					return null;
				} else { 
					// if bytes followed by end of stream: framing error
					throw new EOFException("Non-empty message without delimiter");
				}
			}
			messageBuffer.write(nextByte); // write byte to buffer
		}

		return messageBuffer.toByteArray();
	}
}
