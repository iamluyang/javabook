package online.javabook.design.rpc.core.api.bloom.impl;

import online.javabook.design.rpc.core.api.bloom.hash.HashFunction;
import online.javabook.design.rpc.core.api.bloom.api.Key;
import online.javabook.design.rpc.core.api.bloom.api.Writable;
import online.javabook.design.rpc.core.api.bloom.hash.Hash;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Defines the general behavior of a filter.
 * <p>
 * A filter is a data structure which aims at offering a lossy summary of a set
 * <code>A</code>. The key idea is to map entries of <code>A</code> (also called
 * <i>keys</i>) into several positions in a vector through the use of several
 * hash functions.
 * <p>
 * Typically, a filter will be implemented as a Bloom filter (or a Bloom filter
 * extension).
 * <p>
 * It must be extended in order to define the real behavior.
 * 
 * @see Key The general behavior of a key
 * @see HashFunction A hash function
 */
public abstract class Filter implements Writable {

	// Filter格式: VERSION+nbHash+hashType+vectorSize
	// Filter机制: 过滤器内部使用HashFunction来实现
	
	/**
	 * VERSION
	 */
	private static final int VERSION = -1; // negative to accommodate for old format
	
	/** 
	 * The vector size of <i>this</i> filter. 
	 */
	protected int vectorSize;

	/** 
	 * The number of hash function to consider. 
	 */
	protected int nbHash;

	/** 
	 * Type of hashing function to use. 
	 */
	protected int hashType;

	/** 
	 * The hash function used to map a key to several positions in the vector. 
	 */
	protected HashFunction hash;

	/**
	 * Filter
	 */
	protected Filter() {
		
	}

	/**
	 * Constructor.
	 * 
	 * @param vectorSize
	 *            The vector size of <i>this</i> filter.
	 * @param nbHash
	 *            The number of hash functions to consider.
	 * @param hashType
	 *            type of the hashing function (see {@link Hash}).
	 */
	protected Filter(int vectorSize, int nbHash, int hashType) {
		this.vectorSize = vectorSize;
		this.nbHash     = nbHash;
		this.hashType   = hashType;
		this.hash       = new HashFunction(this.vectorSize, this.nbHash, this.hashType);
	}

	// ====================================================================================================
	// filter-计算模式
	// ====================================================================================================

	/**
	 * Peforms a logical AND between <i>this</i> filter and a specified filter.
	 * <p>
	 * <b>Invariant</b>: The result is assigned to <i>this</i> filter.
	 * 
	 * @param filter
	 *            The filter to AND with.
	 */
	public abstract void and(Filter filter);

	/**
	 * Peforms a logical OR between <i>this</i> filter and a specified filter.
	 * <p>
	 * <b>Invariant</b>: The result is assigned to <i>this</i> filter.
	 * 
	 * @param filter
	 *            The filter to OR with.
	 */
	public abstract void or(Filter filter);

	/**
	 * Peforms a logical XOR between <i>this</i> filter and a specified filter.
	 * <p>
	 * <b>Invariant</b>: The result is assigned to <i>this</i> filter.
	 * 
	 * @param filter
	 *            The filter to XOR with.
	 */
	public abstract void xor(Filter filter);

	/**
	 * Performs a logical NOT on <i>this</i> filter.
	 * <p>
	 * The result is assigned to <i>this</i> filter.
	 */
	public abstract void not();

	/**
	 * Determines wether a specified key belongs to <i>this</i> filter.
	 * 
	 * @param key
	 *            The key to test.
	 * @return boolean True if the specified key belongs to <i>this</i> filter.
	 *         False otherwise.
	 */
	public abstract boolean membershipTest(Key key);
	
	// ====================================================================================================
	// 管理filter-Key
	// ====================================================================================================

	/**
	 * Adds a key to <i>this</i> filter.
	 * 
	 * @param key
	 *            The key to add.
	 */
	public abstract void add(Key key);

	/**
	 * Adds a list of keys to <i>this</i> filter.
	 * 
	 * @param keys
	 *            The list of keys.
	 */
	public void add(List<Key> keys) {
		
		if (keys == null) {
			throw new IllegalArgumentException("ArrayList<Key> may not be null");
		}

		for (Key key : keys) {
			add(key);
		}
	}

	/**
	 * Adds a collection of keys to <i>this</i> filter.
	 * 
	 * @param keys
	 *            The collection of keys.
	 */
	public void add(Collection<Key> keys) {
		
		if (keys == null) {
			throw new IllegalArgumentException("Collection<Key> may not be null");
		}
		
		for (Key key : keys) {
			add(key);
		}
	}

	/**
	 * Adds an array of keys to <i>this</i> filter.
	 * 
	 * @param keys
	 *            The array of keys.
	 */
	public void add(Key[] keys) {
		
		if (keys == null) {
			throw new IllegalArgumentException("Key[] may not be null");
		}
		
		for (int i = 0; i < keys.length; i++) {
			add(keys[i]);
		}
		
	}

	// ====================================================================================================
	// Writable interface
	// ====================================================================================================
	
	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(VERSION);
		out.writeInt(this.nbHash);
		out.writeByte(this.hashType);
		out.writeInt(this.vectorSize);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		
		int version = in.readInt();
		
		if (version > 0) {
			this.nbHash   = version;
			this.hashType = Hash.JENKINS_HASH;
			
		} else if (version == VERSION) {
			this.nbHash   = in.readInt();
			this.hashType = in.readByte();
			
		} else {
			throw new IOException("Unsupported version: " + version);
		}
		
		this.vectorSize = in.readInt();
		this.hash = new HashFunction(this.vectorSize, this.nbHash, this.hashType);
	}
	
}