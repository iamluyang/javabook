package online.javabook.io.socket.framer.service;

import online.javabook.io.socket.framer.serialization.VoteMsg;
import online.javabook.io.socket.framer.serialization.VoteMsgCoder;
import online.javabook.io.socket.framer.serialization.VoteMsgTextCoder;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class VoteServerUDP {

	public static void main(String[] args) throws IOException {

		// Test for correct # of args
		if (args.length != 1) { 
			throw new IllegalArgumentException("Parameter(s): <Port>");
		}

	    // Receiving Port
		int port = Integer.parseInt(args[0]);

		// Receive socket
		DatagramSocket sock = new DatagramSocket(port); 

		byte[] inBuffer = new byte[VoteMsgTextCoder.MAX_WIRE_LENGTH];
		
		// Change Bin to Text for a different coding approach
		VoteMsgCoder coder = new VoteMsgTextCoder();
		VoteService service = new VoteService();

		while (true) {
			
			DatagramPacket packet = new DatagramPacket(inBuffer, inBuffer.length);
			sock.receive(packet);
			byte[] encodedMsg = Arrays.copyOfRange(packet.getData(), 0, packet.getLength());
			System.out.println("Handling request from " + packet.getSocketAddress() + " (" + encodedMsg.length + " bytes)");

			try {
				VoteMsg msg = coder.decoder(encodedMsg);
				msg = service.handleRequest(msg);
				packet.setData(coder.encoder(msg));
				System.out.println("Sending response (" + packet.getLength() + " bytes):");
				System.out.println(msg);
				sock.send(packet);
			} catch (IOException ioe) {
				System.err.println("Parse error in message: " + ioe.getMessage());
			}
		}
	}
}
