package com.javabook.socket.framer.service;

import java.util.HashMap;
import java.util.Map;

import com.javabook.socket.framer.serialization.VoteMsg;

public class VoteService {

	// Map of candidates to number of votes
	private Map<Integer, Long> results = new HashMap<Integer, Long>();

	public VoteMsg handleRequest(VoteMsg msg) {
		
		// If response, just send it back
		if (msg.isResponse()) {
			return msg;
		}
		
		// Make message a response
		msg.setResponse(true);
		
		// Get candidate ID and vote count
		int candidate = msg.getCandidateID();
		Long count = results.get(candidate);
		
		if (count == null) {
			count = 0L; // Candidate does not exist
		}
		
		if (!msg.isInquiry()) {
			// If vote, increment count
			results.put(candidate, ++count); 
		}
		
		msg.setVoteCount(count);
		return msg;
	}
}
