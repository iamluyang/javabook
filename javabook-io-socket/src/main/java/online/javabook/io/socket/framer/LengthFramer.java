package online.javabook.io.socket.framer;

import java.io.*;

public class LengthFramer implements Framer {
	
	/**
	 * MAXMESSAGELENGTH
	 */
	public static final int MAXMESSAGELENGTH = 65535;
	
	/**
	 * BYTEMASK
	 */
	public static final int BYTEMASK = 0xff;
	
	/**
	 * SHORTMASK
	 */
	public static final int SHORTMASK = 0xffff;
	
	/**
	 * BYTESHIFT
	 */
	public static final int BYTESHIFT = 8;

	/**
	 *  wrapper for data I/O
	 */
	private DataInputStream in;

	/**
	 * @param in
	 * @throws IOException
	 */
	public LengthFramer(InputStream in) throws IOException {
		this.in = new DataInputStream(in);
	}

	@Override
	public void sendMessage(byte[] message, OutputStream out) throws IOException {
		
		if (message.length > MAXMESSAGELENGTH) {
			throw new IOException("message too long");
		}
		
		// write length prefix
		out.write((message.length >> BYTESHIFT) & BYTEMASK);
		out.write(message.length & BYTEMASK);
		
		// write message
		out.write(message);
		out.flush();
	}

	@Override
	public byte[] reveiveMessage() throws IOException {
		
		int length;
		
		try {
			// read 2 bytes
			length = in.readUnsignedShort(); 
		} catch (EOFException e) { 
			// no (or 1 byte) message
			return null;
		}
		
		// 0 <= length <= 65535
		byte[] msg = new byte[length];
		
		// if exception, it's a framing error.
		in.readFully(msg);
		return msg;
	}
}
