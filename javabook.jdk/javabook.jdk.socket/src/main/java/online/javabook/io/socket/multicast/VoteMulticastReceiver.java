package online.javabook.io.socket.multicast;

import online.javabook.io.socket.framer.serialization.VoteMsg;
import online.javabook.io.socket.framer.serialization.VoteMsgTextCoder;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Arrays;

/**
 * @author LuYang
 *
 */
public class VoteMulticastReceiver {

	  public static void main(String[] args) throws IOException {

		// Test for correct # of args
	    if (args.length != 2) {
	      throw new IllegalArgumentException("Parameter(s): <Multicast Addr> <Port>");
	    }

	    // Multicast address
	    InetAddress address = InetAddress.getByName(args[0]); 
	    
	    // Test if multicast address
	    if (!address.isMulticastAddress()) { 
	      throw new IllegalArgumentException("Not a multicast address");
	    }

	    // Multicast port
	    int port = Integer.parseInt(args[1]); 
	    // for receiving
	    MulticastSocket sock = new MulticastSocket(port); 
	    // Join the multicast group
	    sock.joinGroup(address); 

	    VoteMsgTextCoder coder = new VoteMsgTextCoder();

	    // Receive a datagram
	    DatagramPacket packet = new DatagramPacket(new byte[VoteMsgTextCoder.MAX_WIRE_LENGTH], VoteMsgTextCoder.MAX_WIRE_LENGTH);
	    sock.receive(packet);

	    VoteMsg vote = coder.decoder(Arrays.copyOfRange(packet.getData(), 0, packet.getLength()));

	    System.out.println("Received Text-Encoded Request (" + packet.getLength() + " bytes): ");
	    System.out.println(vote);

	    sock.close();
	  }
	}