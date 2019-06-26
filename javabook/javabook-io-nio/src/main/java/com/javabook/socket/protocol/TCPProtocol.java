package com.javabook.socket.protocol;

import java.io.IOException;
import java.nio.channels.SelectionKey;

public interface TCPProtocol {
	
	/**
	 * @param key
	 * @throws IOException
	 */
	void handleAccept(SelectionKey key) throws IOException;

	/**
	 * @param key
	 * @throws IOException
	 */
	void handleRead(SelectionKey key) throws IOException;

	/**
	 * @param key
	 * @throws IOException
	 */
	void handleWrite(SelectionKey key) throws IOException;
}