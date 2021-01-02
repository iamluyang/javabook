package online.javabook.io.socket.framer.serialization;

import java.io.IOException;

/**
 * @author LuYang
 *
 */
public interface VoteMsgCoder {
	
	/**
	 * @param msg
	 * @return
	 * @throws IOException
	 */
	byte[] encoder(VoteMsg msg) throws IOException;

	/**
	 * @param input
	 * @return
	 * @throws IOException
	 */
	VoteMsg decoder(byte[] input) throws IOException;
}