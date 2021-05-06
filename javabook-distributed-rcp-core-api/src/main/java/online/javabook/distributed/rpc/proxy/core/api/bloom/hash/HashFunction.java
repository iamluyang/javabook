package online.javabook.distributed.rpc.proxy.core.api.bloom.hash;

import online.javabook.distributed.rpc.proxy.core.api.bloom.api.Key;
import online.javabook.distributed.rpc.proxy.core.api.bloom.impl.Filter;

/**
 * Implements a hash object that returns a certain number of hashed values.
 * 
 * @see Key The general behavior of a key being stored in a filter
 * @see Filter The general behavior of a filter
 */
public final class HashFunction {
	
	// 哈希函数的构建参数:1-maxValue每个字节的最大值(不等于该值) 2-nbHash哈希字节数组的长度 3-Hash算法类型
	// 即对一个Key进行nbHash次hash计算，每次的种子值为上一次计算出来的哈希值，且每个哈希值不能超过maxValue
	
	/**
	 * The number of hashed values.
	 */
	private int nbHash;

	/**
	 * The maximum highest returned value.
	 */
	private int maxValue;

	/**
	 * Hashing algorithm to use.
	 */
	private Hash hash;

	/**
	 * Constructor.
	 * <p>
	 * Builds a hash function that must obey to a given maximum number of
	 * returned values and a highest value.
	 * 
	 * @param maxValue
	 *            The maximum highest returned value.
	 * @param nbHash
	 *            The number of resulting hashed values.
	 * @param hashType
	 *            type of the hashing function (see {@link Hash}).
	 */
	public HashFunction(int maxValue, int nbHash, int hashType) {

		if (maxValue <= 0) {
			throw new IllegalArgumentException("maxValue must be > 0");
		}

		if (nbHash <= 0) {
			throw new IllegalArgumentException("nbHash must be > 0");
		}

		this.maxValue = maxValue;
		this.nbHash   = nbHash;
		this.hash     = Hash.getInstance(hashType);

		if (this.hash == null)
		throw new IllegalArgumentException("hashType must be known");
	}

	/**
	 * Clears <i>this</i> hash function. A NOOP
	 */
	public void clear() {

	}

	/**
	 * Hashes a specified key into several integers.
	 * 
	 * @param key
	 *            The specified key.
	 * @return The array of hashed values.
	 */
	public int[] hash(Key key) {

		byte[] bytes = key.getBytes();

		if (bytes == null) {
			throw new NullPointerException("buffer reference is null");
		}

		if (bytes.length == 0) {
			throw new IllegalArgumentException("key length must be > 0");
		}

		int[] result = new int[nbHash];

		for (int i = 0, initval = 0; i < nbHash; i++) {
			initval   = hash.hash(bytes, initval);
			result[i] = Math.abs(initval % maxValue);
		}

		return result;
	}

}