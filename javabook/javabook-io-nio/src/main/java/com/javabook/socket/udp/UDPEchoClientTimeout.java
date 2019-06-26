package com.javabook.socket.udp;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LuYang
 * 
 */
public class UDPEchoClientTimeout {

	// Resend timeout (milliseconds)
	private static final int TIMEOUT = 3000;
	
	// Maximum retransmissions
	private static final int MAXTRIES = 5; 

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		if ((args.length < 2) || (args.length > 3)) { // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");
		}

		// Server address
		InetAddress serverAddress = InetAddress.getByName(args[0]); 
		
		// Convert the argument String to bytes using the default encoding
		byte[] bytesToSend = args[1].getBytes();

		// servPort
		int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

		// socket
		DatagramSocket socket = new DatagramSocket();

		//socket.setSoTimeout(TIMEOUT); // Maximum receive blocking time (milliseconds)

		// Sending packet
		DatagramPacket sendPacket = new DatagramPacket(bytesToSend, bytesToSend.length, serverAddress, servPort);

		// Receiving packet
		DatagramPacket receivePacket = new DatagramPacket(new byte[bytesToSend.length], bytesToSend.length);

		// Packets may be lost, so we have to keep trying
		int tries = 0; 
		
		boolean receivedResponse = false;
		
		do {
			
			// Send the echo string
			socket.send(sendPacket); 
			System.out.println("socket send:" + sendPacket + "-sendPacket.getLength():"+sendPacket.getLength());
			try {
				
				socket.receive(receivePacket); // Attempt echo reply reception

				// Check source
				if (!receivePacket.getAddress().equals(serverAddress)) {
					throw new IOException("Received packet from an unknown source");
				}
				
				receivedResponse = true;

			} catch (InterruptedIOException e) { // We did not get anything
				tries += 1;
				System.out.println("Timed out, " + (MAXTRIES - tries) + " more tries..."+e);

			}
		} while ((!receivedResponse) && (tries < MAXTRIES));

		// receivedResponse
		if (receivedResponse) {
			System.out.println("Received: " + new String(receivePacket.getData()));
		} else {
			System.out.println("No response -- giving up.");
		}

		socket.close();
	}
}
