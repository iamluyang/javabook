package online.javabook.concurrent.coll.map;

/**
 * <ul>技术特性
 * 	<li>此类利用哈希表实现 Map 接口，比较键（和值）时使用引用相等性代替对象相等性。
 * <li>在 IdentityHashMap 中，当且仅当 (k1==k2) 时，才认为两个键 k1 和 k2 相等
 * <li>在正常 Map 实现（如 HashMap）中，当且仅当满足下列条件时才认为两个键 k1 和 k2 相等：(k1==null ? k2==null : e1.equals(e2))）。 
 * <li>此为简单的线性探头 哈希表，如 Sedgewick 和 Knuth 原文示例中所述。该数组交替保持键和值（对于大型表来说，它比使用独立组保持键和值更具优势）
 * </ul>
 * 
 * <ul>容量计算 initCapacity
 *  <li>构造函数初始化容量值expectedMaxSize并不是最终的值，内部会通过private int capacity(int expectedMaxSize)方法重新计算
 *  <li>计算方式: (3 * expectedMaxSize)/2 = minCapacity -> 如果这个结果: minCapacity > MAXIMUM_CAPACITY || minCapacity < 0 则使用最大容量 -> result = MAXIMUM_CAPACITY
 *  <li>否则以最小容量为基准 result = MINIMUM_CAPACITY; ->  while (result < minCapacity) result <<= 1; 多次左移逼近 minCapacity，成为一个 2^n 的值，且大于minCapacity的最小值
 *  <li>如果构造函数传人另一个 Map，则expectedMaxSize为 (int) ((1 + m.size()) * 1.1)，然后仍然遵循上面的规则计算
 * </ul>
 * 
 * <ul>容量初始化 threshold,table
 *  <li>完成容量值计算后则开始容量的初始化值计算，使用 private void init(int initCapacity) 计算
 * 	<li>计算 threshold = (initCapacity * 2)/3;
 *  <li>计算 table = new Object[2 * initCapacity]; 乘以2是因为这个Map的数据存储方式比较特殊，key和value作为两个相邻的数据存储在table上，而没有设计一个Entry来包装
 * </ul>
 * 
 * <ul>计算元素的哈希值-private static int hash(Object x, int length)
 * 	<li>通过本地方法获得 h -- public static native int identityHashCode(Object x);
 *  <li>通过h再次计算     ((h << 1) - (h << 8)) & (length - 1);
 * </ul>
 * 
 * <ul>计算Map的哈希值-public int hashCode() 
 * 	<li>相邻的两个元素计算 System.identityHashCode(k) ^ System.identityHashCode(tab[i + 1]);
 *  <li>重复上诉计算方式，将结果累加
 * </ul>
 * 
 * <ul>private static int nextKeyIndex(int i, int len)
 * 	<li>(i + 2 < len ? i + 2 : 0);
 *  <li>根据当前i位置向后错开2个位置获取新的位置，并且期间要判断是否越过table的长度，如越界则返回0，表示从table的起始位置开始查找空闲的位置
 * </ul>
 * 
 * <ul>public V put(K key, V value)
 * 	<li>key和value没有像其他Map那样封装成一个Entry，而是按照相邻顺序都放在table中
 *  <li>通过key先计算出在table中的位置i  value的位置就为 i+1 ，
 *  <li>注意：null的key被NULL_KEY替换
 *  <li>hash冲突的处理：
 *  <li>如果当前位置存在的key等于当前put传递的key（引用相等）,则替换掉oldValue，即覆盖操作
 *  <li>如果当前位置存在的key不是当前put传递的key（应也消得），则通过nextKeyIndex来获取下一个位置来放置key和value
 * </ul>
 * 
 * <ul>IdentityHashMapIterator
 * 	<li>hasNext-每隔2个位置遍历table，查找到不为null的key，返回true，反正返回false
 *  <li>nextIndex -返回下一个key的位置，需要检测几件事：
 *  <li>被其他线程修改了
 *  <li>没有下一个元素了
 *  <li>更新最后一次返回元素的位置lastReturnedIndex = index;
 *  <li>位置更新index += 2;
 * </ul>
 * 
 * <ul>扩容机制-resize
 * 	<li>int newLength = newCapacity * 2;
 * 	<li> 如果当前容量oldLength == 2*MAXIMUM_CAPACITY，并且threshold == MAXIMUM_CAPACITY-1，
 *         则不能扩容了,并且抛出异常 throw new IllegalStateException("Capacity exhausted.");  否则threshold = MAXIMUM_CAPACITY-1;  然后不扩容
 * 	<li>if (oldLength >= newLength)则不扩容
 * 	<li>扩容Object[] newTable = new Object[newLength];，重设threshold = newLength / 3; 然后将oldTable复制到newTable，期间要重新计算hash
 * </ul>
 * 
 * @author LuYang
 *
 */
public class IdentityHashMapDemo {

}
