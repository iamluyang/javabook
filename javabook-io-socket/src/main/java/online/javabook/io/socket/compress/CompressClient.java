package online.javabook.io.socket.compress;

import java.io.*;
import java.net.Socket;

public class CompressClient {

	// Size of read buffer
	public static final int BUFSIZE = 256; 

	public static void main(String[] args) throws IOException {

		// Test for correct # of args
		if (args.length != 3) { 
			throw new IllegalArgumentException("Parameter(s): <Server> <Port> <File>");
		}

		// Server name or IP address
		String server = args[0]; 
		
		// Server port
		int port = Integer.parseInt(args[1]); 
		
		// File to read data from
		String filename = args[2]; 

		// Open input and output file (named input.gz)
		FileInputStream  fileIn  = new FileInputStream(filename);
		FileOutputStream fileOut = new FileOutputStream(filename + ".gz");

		// Create socket connected to server on specified port
		Socket sock = new Socket(server, port);

		// Send uncompressed byte stream to server
		sendBytes(sock, fileIn);

		// Receive compressed byte stream from server
		InputStream sockIn = sock.getInputStream();
		
		// Number of bytes read
		int bytesRead; 
		
		// Byte buffer
		byte[] buffer = new byte[BUFSIZE]; 
		
		while ((bytesRead = sockIn.read(buffer)) != -1) {
			fileOut.write(buffer, 0, bytesRead);
			
			// Reading progress indicator
			System.out.print("R"); 
		}
		
		// End progress indicator line
		System.out.println(); 

		// Close the socket and its streams
		sock.close(); 
		
		// Close file streams
		fileIn.close();
		fileOut.close();
	}

	/**
	 * @param sock
	 * @param fileIn
	 * @throws IOException
	 */
	private static void sendBytes(Socket sock, InputStream fileIn) throws IOException {
		
		OutputStream sockOut = sock.getOutputStream();
		
		// Number of bytes read
		int bytesRead; 
		byte[] buffer = new byte[BUFSIZE]; // Byte buffer
		while ((bytesRead = fileIn.read(buffer)) != -1) {
			sockOut.write(buffer, 0, bytesRead);
			
			// Writing progress indicator
			System.out.print("W"); 
		}
		sock.shutdownOutput(); // Finished sending
	}
}
