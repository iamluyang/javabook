package online.javabook.concurrent.coll.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap实现了ConcurrentMap接口：
 * 新增了4个原子方法，ConcurrentMap满足内存一致性效果：
 * V putIfAbsent(K key, V value) 
 * 		如果指定键已经不再与某个值相关联，则将它与给定值关联。
 * 	
 *   <pre>
 *   if (!map.containsKey(key))
 *       return map.put(key, value);
 *   else
 *       return map.get(key);</pre>
 * 
 * boolean remove(Object key, Object value)  
 * 		只有目前将键的条目映射到给定值时，才移除该键的条目。
 * 
 * <pre>
 *   if (map.containsKey(key) && map.get(key).equals(value)) {
 *       map.remove(key);
 *       return true;
 *   } else return false;
 *   </pre>
 *   
 * V replace(K key, V value)  
 * 		只有目前将键的条目映射到某一值时，才替换该键的条目。
 * 
 * <pre>
 *   if (map.containsKey(key)) {
 *       return map.put(key, value);
 *   } else return null;</pre>

 * boolean replace(K key, V oldValue, V newValue)  
 * 		只有目前将键的条目映射到给定值时，才替换该键的条目。
 * 
 * <pre>
 *   if (map.containsKey(key) && map.get(key).equals(oldValue)) {
 *       map.put(key, newValue);
 *       return true;
 *   } else return false;</pre>
 *   
 *   
 * 技术特性
 * 1- 数据结构：支持完全并发获取和更新操作的哈希表。
 * 					  此类遵守与 Hashtable 相同的功能规范，并且包括对应于 Hashtable 的每个方法的方法版本
 * 
 * 2- 阻塞性质：获取操作（包括 get）通常不会受阻塞，因此，可能与更新操作交迭（包括 put 和 remove）。
 *                    获取会影响最近完成的更新操作的结果。
 *                    对于一些聚合操作，比如 putAll 和 clear，并发获取可能只影响某些条目的插入和移除。
 *                    类似地，在创建迭代器/枚举时或自此之后，Iterators 和 Enumerations 返回在某一时间点上影响哈希表状态的元素。它们不会 抛出 ConcurrentModificationException。不过，迭代器被设计成每次仅由一个线程使用。
 *
 * 3- 线程安全：不过，尽管所有操作都是线程安全的，但获取操作不必锁定，并且不支持以某种防止所有访问的方式锁定整个表。
 *                    此类可以通过程序完全与 Hashtable 进行互操作，这取决于其线程安全，而与其同步细节无关。 
 * 
 * 4- 容器边界：这允许通过可选的 concurrencyLevel 构造方法参数（默认值为 16）来引导更新操作之间的并发，该参数用作内部调整大小的一个提示。
 * 
 * 5- 技术特性：表是在内部进行分区的，试图允许指示无争用并发更新的数量。
 *                    因为哈希表中的位置基本上是随意的，所以实际的并发将各不相同。理想情况下，应该选择一个尽可能多地容纳并发修改该表的线程的值。
 *                    使用一个比所需要的值高很多的值可能会浪费空间和时间，而使用一个显然低很多的值可能导致线程争用。
 *                    对数量级估计过高或估计过低通常都会带来非常显著的影响。
 * 
 * 6-配置建议：当仅有一个线程将执行修改操作，而其他所有线程都只是执行读取操作时，才认为某个值是合适的。
 *                   此外，重新调整此类或其他任何种类哈希表的大小都是一个相对较慢的操作，
 *                   因此，在可能的时候，提供构造方法中期望表大小的估计值是一个好主意。 
 * 
 * 重要字段
 * 
 * DEFAULT_INITIAL_CAPACITY = 16; - 这是一个默认的哈希表容量，无需通过构造函数指定
 * MAXIMUM_CAPACITY = 1 << 30; - 最大的容量值
 * DEFAULT_LOAD_FACTOR      = 0.75f; - 默认的负载系数
 * 
 * DEFAULT_CONCURRENCY_LEVEL = 16; - 默认的并非级别
 * 
 * MIN_SEGMENT_TABLE_CAPACITY = 2; - 每个分段的最小容量，必须为2的次方
 * MAX_SEGMENTS = 1 << 16 - 每个分段的最大容量，必须为2的次方
 * 
 * RETRIES_BEFORE_LOCK = 2 - 不同步的重试次数
 * 
 * int segmentMask
 * 
 * int segmentShift
 * 
 * Segment<K,V>[] segments
 * 
 * transient Set<K> keySet; - key容器
 * 
 * transient Set<Map.Entry<K,V>> entrySet; key/value对
 * 
 * transient Collection<V> values; -值容器
 * 
 * 数据结构
 * 
 *    static final class HashEntry<K,V> {
 *        final int hash;
 *        final K key;
 *        volatile V value;
 *        volatile HashEntry<K,V> next;
 *
 *        HashEntry(int hash, K key, V value, HashEntry<K,V> next) {
 *            this.hash = hash;
 *            this.key = key;
 *            this.value = value;
 *            this.next = next;
 *        }
 *                
 *		// Sets next field with volatile write semantics.  (See above about use of putOrderedObject.)
 *        final void setNext(HashEntry<K,V> n) {
 *            UNSAFE.putOrderedObject(this, nextOffset, n);
 *        }
 *        
 *        // Unsafe mechanics
 *        static final sun.misc.Unsafe UNSAFE;
 *        static final long nextOffset;
 *        static {
 *            try {
 *                UNSAFE = sun.misc.Unsafe.getUnsafe();
 *                Class k = HashEntry.class;
 *                nextOffset = UNSAFE.objectFieldOffset
 *                    (k.getDeclaredField("next"));
 *            } catch (Exception e) {
 *                throw new Error(e);
 *            }
 *        }
 *    }
 * 
 *  构造函数
 *ConcurrentHashMap() 
 *          创建一个带有默认初始容量 (16)、加载因子 (0.75) 和 concurrencyLevel (16) 的新的空映射。 
 *          
 * ConcurrentHashMap(int initialCapacity) 
 *           创建一个带有指定初始容量、默认加载因子 (0.75) 和 concurrencyLevel (16) 的新的空映射。
 *            
 * ConcurrentHashMap(int initialCapacity, float loadFactor) 
 *          创建一个带有指定初始容量、加载因子和默认 concurrencyLevel (16) 的新的空映射。 
 *          
 * ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel) 
 *          创建一个带有指定初始容量、加载因子和并发级别的新的空映射。 
 *          
 * ConcurrentHashMap(Map<? extends K,? extends V> m) 
 *          构造一个与给定映射具有相同映射关系的新映射。 
 *   
 * @author LuYang
 *
 */
public class ConcurrentHashMapDemo {
	public static void main(String[] args) {
		ConcurrentHashMap m = new ConcurrentHashMap();
	}

}
