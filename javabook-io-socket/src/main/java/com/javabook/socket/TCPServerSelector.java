package com.javabook.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

import com.javabook.socket.protocol.EchoSelectorProtocol;
import com.javabook.socket.protocol.TCPProtocol;

public class TCPServerSelector {

	// Buffer size (bytes)
	private static final int BUFSIZE = 256;
	
	// Wait timeout (milliseconds)
	private static final int TIMEOUT = 3000;

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// Test for correct # of args
		if (args.length < 1) {
			throw new IllegalArgumentException("Parameter(s): <Port> ...");
		}

		// Create a selector to multiplex listening sockets and connections
		Selector selector = Selector.open();
		selector.wakeup();
		// Create listening socket channel for each port and register selector
		for (String arg : args) {
			
			ServerSocketChannel listnChannel = ServerSocketChannel.open();
			listnChannel.socket().bind(new InetSocketAddress(Integer.parseInt(arg)));
			listnChannel.configureBlocking(false); // must be nonblocking to register
			
			// Register selector with channel. The returned key is ignored
			listnChannel.register(selector, SelectionKey.OP_ACCEPT);
		}

		// Create a handler that will implement the protocol
		TCPProtocol protocol = new EchoSelectorProtocol(BUFSIZE);

		// Run forever, processing available I/O operations
		while (true) {
			
			// Wait for some channel to be ready (or timeout)
			if (selector.select(TIMEOUT) == 0) { // returns # of ready chans
				System.out.print(".");
				continue;
			}

			// Get iterator on set of keys with I/O to process
			Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
			
			while (keyIter.hasNext()) {
				SelectionKey key = keyIter.next(); // Key is bit mask
				
				// Server socket channel has pending connection requests?
				if (key.isAcceptable()) {
					protocol.handleAccept(key);
				}
				
				// Client socket channel has pending data?
				if (key.isReadable()) {
					protocol.handleRead(key);
				}
				
				// Client socket channel is available for writing and
				// key is valid (i.e., channel not closed)?
				if (key.isValid() && key.isWritable()) {
					protocol.handleWrite(key);
				}
				
				// remove from set of selected keys
				keyIter.remove();
			}
		}
	}
}