package online.javabook.design.rpc.core.api.bloom.hash;


/**
 * This is a very fast, non-cryptographic hash suitable for general hash-based
 * lookup. See http://murmurhash.googlepages.com/ for more details.
 * 
 * <p>
 * The C version of MurmurHash 2.0 found at that site was ported to Java by
 * Andrzej Bialecki (ab at getopt org).
 * </p>
 */
public class MurmurHash extends Hash {
	
	// MurmurHash 是一种非加密型哈希函数，适用于一般的哈希检索操作。
	// http://zh.wikipedia.org/wiki/Murmur%E5%93%88%E5%B8%8C
	
	/**
	 * _instance
	 */
	private static MurmurHash _instance = new MurmurHash();

	/**
	 * @return
	 */
	public static Hash getInstance() {
		return _instance;
	}

	@Override
	public int hash(byte[] data, int length, int seed) {
		
		int m = 0x5bd1e995;
		int r = 24;

		int h = seed ^ length;

		int len_4 = length >> 2;

		for (int i = 0; i < len_4; i++) {
			int i_4 = i << 2;
			int k = data[i_4 + 3];
			k = k << 8;
			k = k | (data[i_4 + 2] & 0xff);
			k = k << 8;
			k = k | (data[i_4 + 1] & 0xff);
			k = k << 8;
			k = k | (data[i_4 + 0] & 0xff);
			k *= m;
			k ^= k >>> r;
			k *= m;
			h *= m;
			h ^= k;
		}

		// avoid calculating modulo
		int len_m = len_4 << 2;
		int left = length - len_m;

		if (left != 0) {
			if (left >= 3) {
				h ^= (int) data[length - 3] << 16;
			}
			if (left >= 2) {
				h ^= (int) data[length - 2] << 8;
			}
			if (left >= 1) {
				h ^= (int) data[length - 1];
			}

			h *= m;
		}

		h ^= h >>> 13;
		h *= m;
		h ^= h >>> 15;

		return h;
	}
}
