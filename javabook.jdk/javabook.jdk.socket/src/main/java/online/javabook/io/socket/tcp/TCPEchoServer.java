package online.javabook.io.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPEchoServer {

	private static final int BUFSIZE = 32; // Size of receive buffer

	public static void main(String[] args) throws IOException, InterruptedException {

		if (args.length != 1) // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Port>");

		int servPort = Integer.parseInt(args[0]);

		// Create a server socket to accept client connection requests
		ServerSocket servSock = new ServerSocket(servPort);

		int recvMsgSize; // Size of received message
		byte[] receiveBuf = new byte[BUFSIZE]; // Receive buffer

		while (true) { // Run forever, accepting and servicing connections
			Socket clntSock = servSock.accept(); // Get client connection

			SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
			System.out.println("Handling client at " + clientAddress);

			InputStream in   = clntSock.getInputStream();
			OutputStream out = clntSock.getOutputStream();

			// Receive until client closes connection, indicated by -1 return
			while ((recvMsgSize = in.read(receiveBuf)) != -1) {
				out.write(receiveBuf, 0, recvMsgSize);
				
				Thread.sleep(10000);
			}
	
			System.out.println("close clntSock " + clntSock);
			clntSock.close(); // Close the socket. We are done with this client!
		}
		/* NOT REACHED */
	}
}
