package online.javabook.design.rpc.core.api.bloom.impl;

import online.javabook.design.rpc.core.api.bloom.api.Key;
import online.javabook.design.rpc.core.api.bloom.hash.Hash;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.BitSet;

/**
 * Implements a <i>Bloom filter</i>, as defined by Bloom in 1970.
 * <p>
 * The Bloom filter is a data structure that was introduced in 1970 and that has
 * been adopted by the networking research community in the past decade thanks
 * to the bandwidth efficiencies that it offers for the transmission of set
 * membership information between networked hosts. A sender encodes the
 * information into a bit vector, the Bloom filter, that is more compact than a
 * conventional representation. Computation and space costs for construction are
 * linear in the number of elements. The receiver uses the filter to test
 * whether various elements are members of the set. Though the filter will
 * occasionally return a false positive, it will never return a false negative.
 * When creating the filter, the sender can choose its desired point in a
 * trade-off between the false positive rate and the size.
 * 
 * <p>
 * Originally created by <a href="http://www.one-lab.org">European Commission
 * One-Lab Project 034819</a>.
 * 
 * @see Filter The general behavior of a filter
 * 
 * @see <a
 *      href="http://portal.acm.org/citation.cfm?id=362692&dl=ACM&coll=portal">Space/Time
 *      Trade-Offs in Hash Coding with Allowable Errors</a>
 */
public class BloomFilter extends Filter {

	public static void main(String[] args) {
		/*BitSet bits = new BitSet(256);
		bits.set(256, true);
		System.out.println( bits.get(255) );
		System.out.println( bits.size() );*/
		
		BloomFilter bloomFilter = new BloomFilter(16, 8, Hash.JENKINS_HASH);
		
		for(int keyIndex=0; keyIndex<8; keyIndex++){
			Key key = new Key(new byte[]{(byte) keyIndex});
			bloomFilter.add(key);	
		}
		
		// 不存在,但还是显示出现
		Key key2 = new Key(new byte[]{80});
		System.out.println(bloomFilter.membershipTest(key2));			
	}
	
	// 默认的布隆过滤器以一个字节作为存储单位
	
	/**
	 * bitvalues
	 */
	private static final byte[] bitvalues = new byte[] { 
		
		// 留意字节高位的规律
		(byte) 0x01, // 0000 0001
		(byte) 0x02, // 0000 0010
		(byte) 0x04, // 0000 0100
		(byte) 0x08, // 0000 1000
		
		(byte) 0x10, // 0001 0000
		(byte) 0x20, // 0010 0000
		(byte) 0x40, // 0100 0000
		(byte) 0x80  // 1000 0000
	};

	/** 
	 * The bit vector. 
	 */
	BitSet bits;

	/** 
	 * Default constructor - use with readFields 
	 */
	public BloomFilter() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param maxValue
	 *            The vector size of <i>this</i> filter.
	 * @param nbHash
	 *            The number of hash function to consider.
	 * @param hashType
	 *            type of the hashing function (see
	 *            {@link Hash}).
	 */
	public BloomFilter(int maxValue, int nbHash, int hashType) {
		
		super(maxValue, nbHash, hashType);
		bits = new BitSet(this.vectorSize);
	}
	
	// ====================================================================================================
	// 管理filter-Key
	// ====================================================================================================
	
	@Override
	public void add(Key key) {
		
		// 每个Key转换为一个int[] h，并将h中指定的索引映射到BitSet中对应的位置为true
		
		if (key == null) {
			throw new NullPointerException("key cannot be null");
		}

		int[] h = hash.hash(key);
		hash.clear();

		for (int i = 0; i < nbHash; i++) {
			bits.set(h[i]);
			System.out.println(h[i]);
		}
	}

	@Override
	public boolean membershipTest(Key key) {
		
		if (key == null) {
			throw new NullPointerException("key cannot be null");
		}

		// add方法的逆向检测
		int[] hashs = hash.hash(key);
		hash.clear();
		for (int i = 0; i < nbHash; i++) {
			if (!bits.get(hashs[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void and(Filter filter) {
		
		if (filter == null 
			|| !(filter instanceof BloomFilter)
			|| filter.vectorSize != this.vectorSize
			|| filter.nbHash != this.nbHash) {
			
			throw new IllegalArgumentException("filters cannot be and-ed");
		}

		this.bits.and(((BloomFilter) filter).bits);
	}

	@Override
	public void not() {
		bits.flip(0, vectorSize - 1);
	}

	@Override
	public void or(Filter filter) {
		
		if (filter == null 
			|| !(filter instanceof BloomFilter)
			|| filter.vectorSize != this.vectorSize
			|| filter.nbHash != this.nbHash) {
			throw new IllegalArgumentException("filters cannot be or-ed");
		}
		bits.or(((BloomFilter) filter).bits);
	}

	@Override
	public void xor(Filter filter) {
		
		if (filter == null 
			|| !(filter instanceof BloomFilter)
			|| filter.vectorSize != this.vectorSize
			|| filter.nbHash != this.nbHash) {
			throw new IllegalArgumentException("filters cannot be xor-ed");
		}
		bits.xor(((BloomFilter) filter).bits);
	}

	@Override
	public String toString() {
		return bits.toString();
	}

	/**
	 * @return size of the the bloomfilter
	 */
	public int getVectorSize() {
		return this.vectorSize;
	}
	
	// ====================================================================================================
	// Writable
	// ====================================================================================================

	/**
	 * number of bytes needed to hold bit vector
	 * 
	 * @return
	 */
	private int getNBytes() {
		
		// 尽可能获得不少与一个字节		
		return (vectorSize + 7) / 8;
	}
	
	@Override
	public void write(DataOutput out) throws IOException {
		
		super.write(out);
		byte[] bytes = new byte[getNBytes()];
		
		for (int i = 0, byteIndex = 0, bitIndex = 0; i < vectorSize; i++, bitIndex++) {
			
			// i - 持续递增
			// bitIndex - 0-8循环
			// byteIndex - bitIndex每轮询1次(即1个字节)，byteIndex递增1次
			// 每8位(1个字节),移动一个字节索引,逢8进1
			if (bitIndex == 8) {
				bitIndex = 0;
				byteIndex++;
			}
			
			// bitIndex复位到0位索引时表示开始一个新的字节长度周期，该字节的初始值为0
			if (bitIndex == 0) {
				bytes[byteIndex] = 0;
			}
			
			// 将位集中连续的8位（一个字节长度）中为true的位的位值进行 | 运算.
			// 计算结果最小为 0(0000 0000),bits中连续八个位都是false， - 最大值为255（1111 1111）,bits中连续八个位都是true
			// 例子  bitIndex  ->  0            1             2             3              4              5              6              7
			//     bitset    -> true          true          true          true           false          false          false          false 
			//     bitvalues -> [0000 0001]   [0000 0010]   [0000 0100]   [0000 1000]    [0001 0000]    [0010 0000]    [0100 0000]    [1000 0000]
			//     结果                      [0000 0001] | [0000 0011] | [0000 0111]   [0000 1111]    [0000 1111]    [0000 1111]    [0000 1111]    [0000 1111]
			// **简单的来说即是将BitSet中连续的8位数据转换为1个字节存储，将flase/true的形似变成0/1的形似**
			if (bits.get(i)) {
				bytes[byteIndex] |= bitvalues[bitIndex];
			}
		}
		out.write(bytes);
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		
		super.readFields(in);
		
		bits = new BitSet(this.vectorSize);
		
		// bytes
		byte[] bytes = new byte[getNBytes()];
		in.readFully(bytes);
		
		// 与上诉方法相反，将字节数据转为BitSet
		for (int i = 0, byteIndex = 0, bitIndex = 0; i < vectorSize; i++, bitIndex++) {
			
			if (bitIndex == 8) {
				bitIndex = 0;
				byteIndex++;
			}
			
			// 与运算获得当前位是否为0
			if ((bytes[byteIndex] & bitvalues[bitIndex]) != 0) {
				bits.set(i);
			}
		}
	}

}
