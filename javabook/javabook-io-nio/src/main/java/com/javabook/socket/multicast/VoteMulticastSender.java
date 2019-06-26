package com.javabook.socket.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import com.javabook.socket.framer.serialization.VoteMsg;
import com.javabook.socket.framer.serialization.VoteMsgCoder;
import com.javabook.socket.framer.serialization.VoteMsgTextCoder;

public class VoteMulticastSender {

	public static final int CANDIDATEID = 475;

	public static void main(String args[]) throws IOException {

		// Test # of args
		if ((args.length < 2) || (args.length > 3)) { 
			throw new IllegalArgumentException("Parameter(s): <Multicast Addr> <Port> [<TTL>]");
		}

		// Destination
		InetAddress destAddr = InetAddress.getByName(args[0]); 

		// Test if multicast address
		if (!destAddr.isMulticastAddress()) { 
			throw new IllegalArgumentException("Not a multicast address");
		}

		// Destination port
		int destPort = Integer.parseInt(args[1]); 
		// Set TTL
		int TTL = (args.length == 3) ? Integer.parseInt(args[2]) : 1; 

		MulticastSocket sock = new MulticastSocket();		
		// Set TTL for all datagrams
		sock.setTimeToLive(TTL); 

		VoteMsgCoder coder = new VoteMsgTextCoder();

		VoteMsg vote = new VoteMsg(true, true, CANDIDATEID, 1000001L);

		// Create and send a datagram
		byte[] msg = coder.encoder(vote);
		DatagramPacket message = new DatagramPacket(msg, msg.length, destAddr, destPort);
		
		System.out.println("Sending Text-Encoded Request (" + msg.length + " bytes): ");
		System.out.println(vote);
		sock.send(message);

		sock.close();
	}
}