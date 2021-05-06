package online.javabook.io.socket.protocol;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class EchoSelectorProtocol implements TCPProtocol {

	// Size of I/O buffer
	private int bufSize;

	/**
	 * @param bufSize
	 */
	public EchoSelectorProtocol(int bufSize) {
		this.bufSize = bufSize;
	}

	@Override
	public void handleAccept(SelectionKey key) throws IOException {
		
		SocketChannel clntChan = ((ServerSocketChannel) key.channel()).accept();
		
		// Must be nonblocking to register
		clntChan.configureBlocking(false);
		
		// Register the selector with new channel for read and attach byte buffer
		clntChan.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufSize));
	}

	@Override
	public void handleRead(SelectionKey key) throws IOException {
		
		// Client socket channel has pending data
		SocketChannel clntChan = (SocketChannel) key.channel();
		ByteBuffer buf = (ByteBuffer) key.attachment();
		long bytesRead = clntChan.read(buf);
		
		// Did the other end close?
		if (bytesRead == -1) {
			clntChan.close();
		} else if (bytesRead > 0) {
			// Indicate via key that reading/writing are both of interest now.
			key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
		}
	}

	@Override
	public void handleWrite(SelectionKey key) throws IOException {
		
		/*
		 * Channel is available for writing, and key is valid (i.e., client
		 * channel not closed).
		 */
		
		// Retrieve data read earlier
		ByteBuffer buf = (ByteBuffer) key.attachment();
		
		// Prepare buffer for writing
		buf.flip(); 
		SocketChannel clntChan = (SocketChannel) key.channel();
		
		clntChan.write(buf);
		
		// Buffer completely written?
		if (!buf.hasRemaining()) {
			
			// Nothing left, so no longer interested in writes
			key.interestOps(SelectionKey.OP_READ);
		}
		
		buf.compact(); // Make room for more data to be read in
	}

}