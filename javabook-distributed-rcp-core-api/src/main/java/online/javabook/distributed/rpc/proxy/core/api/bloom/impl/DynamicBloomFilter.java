package online.javabook.distributed.rpc.proxy.core.api.bloom.impl;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import online.javabook.distributed.rpc.proxy.core.api.bloom.api.Key;
import online.javabook.distributed.rpc.proxy.core.api.bloom.hash.Hash;


/**
 * Implements a <i>dynamic Bloom filter</i>, as defined in the INFOCOM 2006
 * paper.
 * <p>
 * A dynamic Bloom filter (DBF) makes use of a <code>s * m</code> bit matrix but
 * each of the <code>s</code> rows is a standard Bloom filter. The creation
 * process of a DBF is iterative. At the start, the DBF is a <code>1 * m</code>
 * bit matrix, i.e., it is composed of a single standard Bloom filter. It
 * assumes that <code>n<sub>r</sub></code> elements are recorded in the initial
 * bit vector, where <code>n<sub>r</sub> <= n</code> (<code>n</code> is the
 * cardinality of the set <code>A</code> to record in the filter).
 * <p>
 * As the size of <code>A</code> grows during the execution of the application,
 * several keys must be inserted in the DBF. When inserting a key into the DBF,
 * one must first get an active Bloom filter in the matrix. A Bloom filter is
 * active when the number of recorded keys, <code>n<sub>r</sub></code>, is
 * strictly less than the current cardinality of <code>A</code>, <code>n</code>.
 * If an active Bloom filter is found, the key is inserted and
 * <code>n<sub>r</sub></code> is incremented by one. On the other hand, if there
 * is no active Bloom filter, a new one is created (i.e., a new row is added to
 * the matrix) according to the current size of <code>A</code> and the element
 * is added in this new Bloom filter and the <code>n<sub>r</sub></code> value of
 * this new Bloom filter is set to one. A given key is said to belong to the DBF
 * if the <code>k</code> positions are set to one in one of the matrix rows.
 * <p>
 * Originally created by <a href="http://www.one-lab.org">European Commission
 * One-Lab Project 034819</a>.
 * 
 * @see Filter The general behavior of a filter
 * @see BloomFilter A Bloom filter
 * 
 * @see <a
 *      href="http://www.cse.fau.edu/~jie/research/publications/Publication_files/infocom2006.pdf">Theory
 *      and Network Applications of Dynamic Bloom Filters</a>
 */
public class DynamicBloomFilter extends Filter {

	// Dynamic布隆过滤器由多个默认BloomFilter构成
	// nr为每个BloomFilter存储的key的数量的最大值，当一个BloomFilter存储的key达到这个值，则添加一个新的BloomFilter来存储key，即分片存储
	// currentNbRecord记录了Key的数量
	// TODO 细看，相比较默认的布隆过滤器，增加了移除接口	
	
	/**
	 * Threshold for the maximum number of key to record in a dynamic Bloom
	 * filter row.
	 */
	private int nr;

	/**
	 * The number of keys recorded in the current standard active Bloom filter.
	 */
	private int currentNbRecord;

	/**
	 * The matrix of Bloom filter.
	 */
	private BloomFilter[] matrix;

	/**
	 * Zero-args constructor for the serialization.
	 */
	public DynamicBloomFilter() {
		
	}

	/**
	 * Constructor.
	 * <p>
	 * Builds an empty Dynamic Bloom filter.
	 * 
	 * @param vectorSize
	 *            The number of bits in the vector.
	 * @param nbHash
	 *            The number of hash function to consider.
	 * @param hashType
	 *            type of the hashing function (see
	 *            {@link Hash}).
	 * @param nr
	 *            The threshold for the maximum number of keys to record in a
	 *            dynamic Bloom filter row.
	 */
	public DynamicBloomFilter(int vectorSize, int nbHash, int hashType, int nr) {
		
		super(vectorSize, nbHash, hashType);

		// nr and currentNbRecord
		this.nr = nr;
		this.currentNbRecord = 0;

		// BloomFilter
		matrix = new BloomFilter[1];
		matrix[0] = new BloomFilter(this.vectorSize, this.nbHash, this.hashType);
	}

	@Override
	public void add(Key key) {
		
		if (key == null) {
			throw new NullPointerException("Key can not be null");
		}

		// 获取ActiveStandard的BloomFilter
		BloomFilter bf = getActiveStandardBF();

		// 没有的话添加addRow,取最后一个BloomFilter
		if (bf == null) {
			addRow();
			bf = matrix[matrix.length - 1];
			currentNbRecord = 0;
		}

		bf.add(key);

		currentNbRecord++;
	}

	@Override
	public void and(Filter filter) {
		
		if (filter == null 
			|| !(filter instanceof DynamicBloomFilter)
			|| filter.vectorSize != this.vectorSize
			|| filter.nbHash != this.nbHash) {
			
			throw new IllegalArgumentException("filters cannot be and-ed");
		}

		DynamicBloomFilter dbf = (DynamicBloomFilter) filter;

		if (dbf.matrix.length != this.matrix.length || dbf.nr != this.nr) {
			throw new IllegalArgumentException("filters cannot be and-ed");
		}

		// 每个BloomFilter单独and运算
		for (int i = 0; i < matrix.length; i++) {
			matrix[i].and(dbf.matrix[i]);
		}
	}

	@Override
	public boolean membershipTest(Key key) {
		
		if (key == null) {
			return true;
		}

		// 到每个BloomFilter中检测
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].membershipTest(key)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void not() {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i].not();
		}
	}

	@Override
	public void or(Filter filter) {
		
		if (filter == null 
			|| !(filter instanceof DynamicBloomFilter)
			|| filter.vectorSize != this.vectorSize
			|| filter.nbHash != this.nbHash) {
			
			throw new IllegalArgumentException("filters cannot be or-ed");
		}

		DynamicBloomFilter dbf = (DynamicBloomFilter) filter;

		if (dbf.matrix.length != this.matrix.length || dbf.nr != this.nr) {
			throw new IllegalArgumentException("filters cannot be or-ed");
		}
		
		// 每个BloomFilter单独or运算
		for (int i = 0; i < matrix.length; i++) {
			matrix[i].or(dbf.matrix[i]);
		}
	}

	@Override
	public void xor(Filter filter) {
		
		if (filter == null 
			|| !(filter instanceof DynamicBloomFilter)
			|| filter.vectorSize != this.vectorSize
			|| filter.nbHash != this.nbHash) {
			throw new IllegalArgumentException("filters cannot be xor-ed");
		}
		
		DynamicBloomFilter dbf = (DynamicBloomFilter) filter;

		if (dbf.matrix.length != this.matrix.length || dbf.nr != this.nr) {
			throw new IllegalArgumentException("filters cannot be xor-ed");
		}

		// 每个BloomFilter单独xor运算
		for (int i = 0; i < matrix.length; i++) {
			matrix[i].xor(dbf.matrix[i]);
		}
	}

	@Override
	public String toString() {
		
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < matrix.length; i++) {
			res.append(matrix[i]);
			res.append(Character.LINE_SEPARATOR);
		}
		return res.toString();
	}
	
	// ====================================================================================================
	// Writable
	// ====================================================================================================

	@Override
	public void write(DataOutput out) throws IOException {
		super.write(out);
		out.writeInt(nr);
		out.writeInt(currentNbRecord);
		out.writeInt(matrix.length);
		for (int i = 0; i < matrix.length; i++) {
			matrix[i].write(out);
		}
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		super.readFields(in);
		nr = in.readInt();
		currentNbRecord = in.readInt();
		int len = in.readInt();
		matrix = new BloomFilter[len];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new BloomFilter();
			matrix[i].readFields(in);
		}
	}
	
	// ====================================================================================================
	// private
	// ====================================================================================================

	/**
	 * Returns the active standard Bloom filter in <i>this</i> dynamic Bloom
	 * filter.
	 * 
	 * @return BloomFilter The active standard Bloom filter. <code>Null</code>
	 *         otherwise.
	 */
	private BloomFilter getActiveStandardBF() {
		
		// 当前key的数量超过nr值，则返回null
		if (currentNbRecord >= nr) {
			return null;
		}

		// 否则返回matrix中最后可用的BloomFilter
		return matrix[matrix.length - 1];
	}
	
	/**
	 * Adds a new row to <i>this</i> dynamic Bloom filter.
	 */
	private void addRow() {
		
		// 在matrix中添加一个新的BloomFilter
		// 什么时候需要添加一个新的BloomFilter，当currentNbRecord >= nr（当前key的数量超过nr值）时，增加一个BloomFilter来存储key
		BloomFilter[] tmp = new BloomFilter[matrix.length + 1];

		for (int i = 0; i < matrix.length; i++) {
			tmp[i] = matrix[i];
		}

		tmp[tmp.length - 1] = new BloomFilter(vectorSize, nbHash, hashType);

		matrix = tmp;
	}

}
