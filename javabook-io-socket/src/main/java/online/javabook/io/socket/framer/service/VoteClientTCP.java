package online.javabook.io.socket.framer.service;

import online.javabook.io.socket.framer.Framer;
import online.javabook.io.socket.framer.LengthFramer;
import online.javabook.io.socket.framer.serialization.VoteMsg;
import online.javabook.io.socket.framer.serialization.VoteMsgBinCoder;
import online.javabook.io.socket.framer.serialization.VoteMsgCoder;

import java.io.OutputStream;
import java.net.Socket;

public class VoteClientTCP {

	public static final int CANDIDATEID = 888;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {

		if (args.length != 2) { // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Server> <Port>");
		}

		// Destination address
		String destAddr = args[0];
		
		// Destination port
		int destPort = Integer.parseInt(args[1]);

		Socket sock = new Socket(destAddr, destPort);
		OutputStream out = sock.getOutputStream();

		// Change Bin to Text for a different framing strategy
		VoteMsgCoder coder = new VoteMsgBinCoder();
		
		// Change Length to Delim for a different encoding strategy
		Framer framer = new LengthFramer(sock.getInputStream());

		// Create an inquiry request (2nd arg = true)
		VoteMsg msg = new VoteMsg(false, true, CANDIDATEID, 0);
		
		// Send request
		byte[] encodedMsg = coder.encoder(msg);
		System.out.println("Sending Inquiry (" + encodedMsg.length + " bytes): ");
		System.out.println(msg);
		framer.sendMessage(encodedMsg, out);

		// Now send a vote
		msg.setInquiry(false);
		encodedMsg = coder.encoder(msg);
		System.out.println("Sending Vote (" + encodedMsg.length + " bytes): ");
		System.out.println(msg);
		framer.sendMessage(encodedMsg, out);

		// Receive inquiry response
		msg = coder.decoder(framer.reveiveMessage());
		System.out.println("Received Response (" + encodedMsg.length + " bytes): ");
		System.out.println(msg);

		// Receive vote response
		msg = coder.decoder(framer.reveiveMessage());
		System.out.println("Received Response (" + encodedMsg.length + " bytes): ");
		System.out.println(msg);

		sock.close();
	}
}
