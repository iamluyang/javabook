package com.javabook.socket;

import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCPEchoClientNonblocking {

	public static void main(String args[]) throws Exception {

		// Test for correct # of args
		if ((args.length < 2) || (args.length > 3))
			throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

		// Server name or IP address
		String server = args[0]; 
		
		// Convert input String to bytes using the default charset
		byte[] argument = args[1].getBytes();

		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

		// Create channel and set to nonblocking
		SocketChannel clntChan = SocketChannel.open();
		clntChan.configureBlocking(false);

		// Initiate connection to server and repeatedly poll until complete
		if (!clntChan.connect(new InetSocketAddress(server, servPort))) {
			while (!clntChan.finishConnect()) {
				System.out.print("."); // Do something else
			}
		}
		
		ByteBuffer writeBuf = ByteBuffer.wrap(argument);
		ByteBuffer readBuf = ByteBuffer.allocate(argument.length);
		
		// Total bytes received so far
		int totalBytesRcvd = 0; 
		
		// Bytes received in last read
		int bytesRcvd; 
		
		while (totalBytesRcvd < argument.length) {
			
			if (writeBuf.hasRemaining()) {
				clntChan.write(writeBuf);
			}
			
			if ((bytesRcvd = clntChan.read(readBuf)) == -1) {
				throw new SocketException("Connection closed prematurely");
			}
			
			totalBytesRcvd += bytesRcvd;
			System.out.print("."); // Do something else
		}

		// convert to String per default charset
		System.out.println("Received: " + new String(readBuf.array(), 0, totalBytesRcvd));
		
		clntChan.close();
	}
}
