package online.javabook.io.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoClient {

	public static void main(String[] args) throws IOException {

		if ((args.length < 2) || (args.length > 3)) // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

		// Server name or IP address
		String server = args[0];

		// Convert argument String to bytes using the default character encoding
		byte[] data = args[1].getBytes();

		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

		// Create socket that is connected to server on specified port
		Socket socket = new Socket(server, servPort);
		System.out.println("Connected to server...sending echo string " + socket);

		InputStream  in  = socket.getInputStream();
		OutputStream out = socket.getOutputStream();

		out.write(data); // Send the encoded string to the server

		// Receive the same string back from the server
		int totalBytesRcvd = 0; // Total bytes received so far
		int bytesRcvd; // Bytes received in last read

		while (totalBytesRcvd < data.length) {
			
			if ((bytesRcvd = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1)
				throw new SocketException("Connection closed prematurely");
			
			System.out.println("read:"+bytesRcvd);
			totalBytesRcvd += bytesRcvd;
		} // data array is full

		System.out.println("Received: " + new String(data));

		socket.close(); // Close the socket and its streams
	}
}
