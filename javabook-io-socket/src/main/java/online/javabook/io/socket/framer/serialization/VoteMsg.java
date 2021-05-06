package online.javabook.io.socket.framer.serialization;

/**
 * @author LuYang
 *
 */
public class VoteMsg {
	
	/**
	 * true if inquiry; false if vote
	 */
	private boolean isInquiry; 
	
	/**
	 * true if response from server
	 */
	private boolean isResponse;
	
	/**
	 * in [0,1000]
	 */
	private int candidateID;
	
	/**
	 * nonzero only in response
	 */
	private long voteCount; 

	/**
	 * MAX_CANDIDATE_ID
	 */
	public static final int MAX_CANDIDATE_ID = 1000;

	/**
	 * @param isResponse
	 * @param isInquiry
	 * @param candidateID
	 * @param voteCount
	 * @throws IllegalArgumentException
	 */
	public VoteMsg(boolean isResponse, boolean isInquiry, int candidateID, long voteCount) throws IllegalArgumentException {
		
		// check invariants		
		if (voteCount != 0 && !isResponse) {
			throw new IllegalArgumentException("Request vote count must be zero");
		}
		
		if (candidateID < 0 || candidateID > MAX_CANDIDATE_ID) {
			throw new IllegalArgumentException("Bad Candidate ID: "+ candidateID);
		}
		
		if (voteCount < 0) {
			throw new IllegalArgumentException("Total must be >= zero");
		}
		
		this.candidateID = candidateID;
		this.isResponse  = isResponse;
		this.isInquiry   = isInquiry;
		this.voteCount   = voteCount;
	}

	/**
	 * @param isInquiry
	 */
	public void setInquiry(boolean isInquiry) {
		this.isInquiry = isInquiry;
	}

	/**
	 * @return
	 */
	public boolean isInquiry() {
		return isInquiry;
	}

	/**
	 * @param isResponse
	 */
	public void setResponse(boolean isResponse) {
		this.isResponse = isResponse;
	}

	/**
	 * @return
	 */
	public boolean isResponse() {
		return isResponse;
	}

	/**
	 * @param candidateID
	 * @throws IllegalArgumentException
	 */
	public void setCandidateID(int candidateID) throws IllegalArgumentException {
		
		if (candidateID < 0 || candidateID > MAX_CANDIDATE_ID) {
			throw new IllegalArgumentException("Bad Candidate ID: " + candidateID);
		}
		this.candidateID = candidateID;
	}

	/**
	 * @return
	 */
	public int getCandidateID() {
		return candidateID;
	}

	/**
	 * @param count
	 */
	public void setVoteCount(long count) {
		
		if ((count != 0 && !isResponse) || count < 0) {
			throw new IllegalArgumentException("Bad vote count");
		}
		voteCount = count;
	}

	/**
	 * @return
	 */
	public long getVoteCount() {
		return voteCount;
	}

	@Override
	public String toString() {
		
		String res = (isInquiry ? "inquiry" : "vote") + " for candidate " + candidateID;
		if (isResponse) {
			res = "response to " + res + " who now has " + voteCount + " vote(s)";
		}
		return res;
	}
}
