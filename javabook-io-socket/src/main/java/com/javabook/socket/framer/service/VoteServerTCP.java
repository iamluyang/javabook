package com.javabook.socket.framer.service;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.javabook.socket.framer.Framer;
import com.javabook.socket.framer.LengthFramer;
import com.javabook.socket.framer.serialization.VoteMsg;
import com.javabook.socket.framer.serialization.VoteMsgBinCoder;
import com.javabook.socket.framer.serialization.VoteMsgCoder;

public class VoteServerTCP {

	public static void main(String args[]) throws Exception {

		// Test for correct # of args
		if (args.length != 1) {
			throw new IllegalArgumentException("Parameter(s): <Port>");
		}

		// Receiving Port
		int port = Integer.parseInt(args[0]);

		ServerSocket servSock = new ServerSocket(port);
		
		// Change Bin to Text on both client and server for different encoding
		VoteMsgCoder coder = new VoteMsgBinCoder();
		VoteService service = new VoteService();

		while (true) {
			
			Socket clntSock = servSock.accept();
			System.out.println("Handling client at " + clntSock.getRemoteSocketAddress());
			
			// Change Length to Delim for a different framing strategy
			Framer framer = new LengthFramer(clntSock.getInputStream());
			try {
				byte[] req;
				
				while ((req = framer.reveiveMessage()) != null) {
					
					System.out.println("Received message (" + req.length + " bytes)");
					VoteMsg responseMsg = service.handleRequest(coder.decoder(req));
					framer.sendMessage(coder.encoder(responseMsg),clntSock.getOutputStream());
				}
				
			} catch (IOException ioe) {
				System.err.println("Error handling client: " + ioe.getMessage());
				
			} finally {
				System.out.println("Closing connection");
				clntSock.close();
				
			}
		}
	}
}
