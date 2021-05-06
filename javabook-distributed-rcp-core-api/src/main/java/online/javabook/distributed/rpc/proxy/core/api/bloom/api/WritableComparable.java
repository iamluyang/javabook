package online.javabook.distributed.rpc.proxy.core.api.bloom.api;


/**
 * A {@link Writable} which is also {@link Comparable}. 
 *
 * <p><code>WritableComparable</code>s can be compared to each other, typically 
 * via <code>Comparator</code>s. Any type which is to be used as a 
 * <code>key</code> in the Hadoop Map-Reduce framework should implement this
 * interface.</p>
 *
 * <p>Note that <code>hashCode()</code> is frequently used in Hadoop to partition
 * keys. It's important that your implementation of hashCode() returns the same 
 * result across different instances of the JVM. Note also that the default 
 * <code>hashCode()</code> implementation in <code>Object</code> does <b>not</b>
 * satisfy this property.</p>
 *  
 * <p>Example:</p>
 * <p><blockquote><pre>
 *     public class MyWritableComparable implements WritableComparable<MyWritableComparable> {
 *       // Some data
 *       private int counter;
 *       private long timestamp;
 *       
 *       public void write(DataOutput out) throws IOException {
 *         out.writeInt(counter);
 *         out.writeLong(timestamp);
 *       }
 *       
 *       public void readFields(DataInput in) throws IOException {
 *         counter = in.readInt();
 *         timestamp = in.readLong();
 *       }
 *       
 *       public int compareTo(MyWritableComparable o) {
 *         int thisValue = this.value;
 *         int thatValue = o.value;
 *         return (thisValue &lt; thatValue ? -1 : (thisValue==thatValue ? 0 : 1));
 *       }
 *
 *       public int hashCode() {
 *         final int prime = 31;
 *         int result = 1;
 *         result = prime * result + counter;
 *         result = prime * result + (int) (timestamp ^ (timestamp &gt;&gt;&gt; 32));
 *         return result
 *       }
 *     }
 * </pre></blockquote></p>
 */
public interface WritableComparable<T> extends Writable, Comparable<T> {
	// 支持Comparable接口的Writable
}
