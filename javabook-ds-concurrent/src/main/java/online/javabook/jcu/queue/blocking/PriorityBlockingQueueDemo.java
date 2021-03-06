package online.javabook.jcu.queue.blocking;

import java.util.*;

/**
 * 技术特性
 * 1- 数据结构：一个基于优先级堆的无界优先级队列。
 * 
 * 2- 容器边界：优先级队列是无界的，但是有一个内部容量，控制着用于存储队列元素的数组大小。
 * 					  它通常至少等于队列的大小。随着不断向优先级队列添加元素，其容量会自动增加。无需指定容量增加策略的细节。 
 * 
 * 3- 数据要求：优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。
 * 					  优先级队列不允许使用 null 元素（构造函数中会检查元素的null）。依靠自然顺序的优先级队列还不允许插入不可比较的对象（这样做可能导致 ClassCastException）。

 * 4- 数据顺序：此队列的头是按指定排序方式确定的最小元素。如果多个元素都是最小值，则头是其中一个元素——选择方法是任意的。
 * 					  队列获取操作 poll、remove、peek 和 element 访问处于队列头的元素。 
 * 
 * 5- 线程安全：此实现不是同步的。如果多个线程中的任意线程修改了队列，则这些线程不应同时访问 PriorityQueue 实例。
 * 					  相反，请使用线程安全的 PriorityBlockingQueue 类。  
 *                        
 *  构造函数
 *  PriorityQueue()
 *  	 使用默认的初始容量（11）创建一个 PriorityQueue，并根据其自然顺序对元素进行排序。
 *  
 *  PriorityQueue(Collection<? extends E> c) 
 *  	创建包含指定 collection 中元素的 PriorityQueue。
 *  
 *  PriorityQueue(int capacity)
 *  	使用指定的初始容量创建一个 PriorityQueue，并根据其自然顺序对元素进行排序。
 *  
 * PriorityQueue(int initialCapacity, Comparator<? super E> comparator) 
 *         使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
 *         
  * PriorityQueue(PriorityQueue<? extends E> c) 
 *         创建包含指定优先级队列元素的 PriorityQueue。
 *         
 * PriorityQueue(SortedSet<? extends E> c) 
 *         创建包含指定有序 set 元素的 PriorityQueue。
 *         
 *  扩容方法
 *  private void grow(int minCapacity) {
 *       int oldCapacity = queue.length;
 *      // Double size if small; else grow by 50%
 *      int newCapacity = oldCapacity + ((oldCapacity < 64) ?
 *                                       (oldCapacity + 2) :
 *                                       (oldCapacity >> 1));
 *      // overflow-conscious code
 *       if (newCapacity - MAX_ARRAY_SIZE > 0)
 *         newCapacity = hugeCapacity(minCapacity);
 *      	queue = Arrays.copyOf(queue, newCapacity);
 *   }
 *                                         
 *   private static int hugeCapacity(int minCapacity) {
 *       if (minCapacity < 0) // overflow
 *            throw new OutOfMemoryError();
 *        return (minCapacity > MAX_ARRAY_SIZE) ?
 *            Integer.MAX_VALUE :
 *            MAX_ARRAY_SIZE;
 *   }
 *  
 *  数据结构 
 *  
 *  重要参数  
 *     Queue - Object[] queue = new Object[initialCapacity];
 *               - size         
 *               - Comparator<? super E> comparator
 *               - int modCount
 *                     
 *  算法实现
 *  
 *  	heapify
 *  	private void heapify()
 *  	
 *      siftUp
 *  	private void siftUp(int k, E x)
 *  	private void siftUpComparable(int k, E x)  - 元素本身实现Comparable接口
 *  	private void siftUpUsingComparator(int k, E x)  - 使用Comparator接口比较
 *  
 *  // 将入队数据构建出一个最小堆
 *  private void siftUpUsingComparator(int k, E x) {
 *      while (k > 0) {
 *          int parent = (k - 1) >>> 1; // 获取当前待插入元素x的父节点索引位置，相当于 (k - 1) / 2 
 *          Object e = queue[parent]; // 获取当前待插入元素x的父节点
 *          if (comparator.compare(x, (E) e) >= 0) // 当前待插入元素与它的父节点比较
 *              break;                                            // 当前节点 x 比父节点 e 大（或等于）则将当前待插入节点放到数组末端第一个空位置，即k(size)所在的位置
 *          queue[k] = e; 									 // 如果当前待插入节点 x 小于它的父节点，则将当前节点x与父节点交换，重复这个过程直到满足节点x比父节点大
 *          k = parent;                                        // 最终构建出一个最小堆（堆顶为最小值），父节点一定比子节点小
 *      }
 *      queue[k] = x;
 *  }
 *  
 *  	siftDown
 *  	private void siftDown(int k, E x)
 *  	private void siftDownComparable(int k, E x) - 元素本身实现Comparable接口
 *  	private void siftDownUsingComparator(int k, E x)  - 使用Comparator接口比较
 *  
 *  // 出队，堆顶为最小堆的最小值，直接返回即可
 *  // 将最后一个元素与与堆顶元素交换位置，并清除掉原有最后一个元素
 *  // 重构堆
 *  public E poll() {
 *      if (size == 0)
 *          return null;
 *      int s = --size;
 *      modCount++;
 *      E result = (E) queue[0];
 *      E x = (E) queue[s];
 *      queue[s] = null;
 *      if (s != 0)
 *          siftDown(0, x);
 *      return result;
 * }
*  		// x为新的堆顶元素   	
 *	   private void siftDownUsingComparator1(int k, E x) {
 *
 *		       int half = size >>> 1; // 当前堆数组的中间位置
 *		       while (k < half) { // 最多比较一半就够了
 *		           int       childLeftIndex = (k << 1) + 1; // k的初始值为0，即最小堆顶，child为k的左子节点索引位置
 *		           Object childLeft         = queue[childLeftIndex]; // childLeft为k的左元素
 *		           int childRightIndex     = childLeftIndex + 1; // childRightIndex为k的右子节点索引位置
 *
 *		           if (childRightIndex < size &&
 *		               comparator.compare((E) childLeft, (E) queue[childRightIndex]) > 0) // 如果左边子节点比右子节点大
 *		               childLeft = queue[childLeftIndex = childRightIndex]; // 则将右元素先赋值给左元素，即左小，右大，父节点只需要更较小的左节点比较就可以了（但实际上左右节点在数组中并不交换位置）
 *
 *		           if (comparator.compare(x, (E) childLeft) <= 0) // 如果父元素x元素比它的左子元素小（或等于），则立即返回，说明它是最小的堆顶元素
 *		               break;
 *
 *		           queue[k] = childLeft; // 如果父元素x比它的左子元素大，则将较小的左子元素与它的父元素k交换
 *		           k = childLeftIndex; // 以当前父元素k较小的子元素索引作为下一次的位置，重复上面的过程，直到重新构建新的最小堆结构
 *		       }
 *		       queue[k] = x;
 *		   }
 * 
 * // 删除指定位置的元素，会导致堆的重新构建
 * private E removeAt(int i) {
 *     assert i >= 0 && i < size;
 *     modCount++;
 *     int s = --size;
 *     if (s == i) // removed last element
 *         queue[i] = null; // 刚好删除的是最后一个元素，则无需重构，不会导致堆的结构发生改变
 *     else {
 *         E moved = (E) queue[s]; // 获取最后一个元素，
 *         queue[s] = null;  // 最后一个元素置空
 *         siftDown(i, moved); // 将最后一个元素moved与要删除位置i的元素交换，并从i所在的位置自上而下重构堆
 *         if (queue[i] == moved) {  // 如重构后i所在的位置元素依然等于最后那个元素（说明moved元素没有移动过，即元素的交换没有改变堆的结构要求），
 *             siftUp(i, moved); // 则重新自下而上去重构i节点上半部分的堆结构，poll像似删除操作的一个特例，poll是最顶端的元素，没有上层节点了，因此只需要向下构建，删除操作可能是删除的是中间某层的元素，因此上下都要处理
 *             if (queue[i] != moved) // 如果如重构后i所在的位置元素不等于最后那个元素了，说明moved元素已经向上改变了位置
 *                 return moved;
 *         }
 *     }
 *     return null;
 * }
 * @author LuYang
 *
 */
public class PriorityBlockingQueueDemo<E> extends AbstractQueue<E>
implements java.io.Serializable {
	 
private static final long serialVersionUID = -7720805057305804111L;

private static final int DEFAULT_INITIAL_CAPACITY = 11;

/**
 * Priority queue represented as a balanced binary heap: the two
 * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
 * priority queue is ordered by comparator, or by the elements'
 * natural ordering, if comparator is null: For each node n in the
 * heap and each descendant d of n, n <= d.  The element with the
 * lowest value is in queue[0], assuming the queue is nonempty.
 */
private transient Object[] queue;

/**
 * The number of elements in the priority queue.
 */
private int size = 0;

/**
 * The comparator, or null if priority queue uses elements'
 * natural ordering.
 */
private final Comparator<? super E> comparator;

/**
 * The number of times this priority queue has been
 * <i>structurally modified</i>.  See AbstractList for gory details.
 */
private transient int modCount = 0;

/**
 * Creates a {@code PriorityQueue} with the default initial
 * capacity (11) that orders its elements according to their
 * {@linkplain Comparable natural ordering}.
 */
public PriorityBlockingQueueDemo() {
    this(DEFAULT_INITIAL_CAPACITY, null);
}

/**
 * Creates a {@code PriorityQueue} with the specified initial
 * capacity that orders its elements according to their
 * {@linkplain Comparable natural ordering}.
 *
 * @param initialCapacity the initial capacity for this priority queue
 * @throws IllegalArgumentException if {@code initialCapacity} is less
 *         than 1
 */
public PriorityBlockingQueueDemo(int initialCapacity) {
    this(initialCapacity, null);
}

/**
 * Creates a {@code PriorityQueue} with the specified initial capacity
 * that orders its elements according to the specified comparator.
 *
 * @param  initialCapacity the initial capacity for this priority queue
 * @param  comparator the comparator that will be used to order this
 *         priority queue.  If {@code null}, the {@linkplain Comparable
 *         natural ordering} of the elements will be used.
 * @throws IllegalArgumentException if {@code initialCapacity} is
 *         less than 1
 */
public PriorityBlockingQueueDemo(int initialCapacity,
                                 Comparator<? super E> comparator) {
    // Note: This restriction of at least one is not actually needed,
    // but continues for 1.5 compatibility
    if (initialCapacity < 1)
        throw new IllegalArgumentException();
    this.queue = new Object[initialCapacity];
    this.comparator = comparator;
}

/**
 * Creates a {@code PriorityQueue} containing the elements in the
 * specified collection.  If the specified collection is an instance of
 * a {@link SortedSet} or is another {@code PriorityQueue}, this
 * priority queue will be ordered according to the same ordering.
 * Otherwise, this priority queue will be ordered according to the
 * {@linkplain Comparable natural ordering} of its elements.
 *
 * @param  c the collection whose elements are to be placed
 *         into this priority queue
 * @throws ClassCastException if elements of the specified collection
 *         cannot be compared to one another according to the priority
 *         queue's ordering
 * @throws NullPointerException if the specified collection or any
 *         of its elements are null
 */
@SuppressWarnings("unchecked")
public PriorityBlockingQueueDemo(Collection<? extends E> c) {
    if (c instanceof SortedSet<?>) {
        SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
        this.comparator = (Comparator<? super E>) ss.comparator();
        initElementsFromCollection(ss);
    }
    else if (c instanceof PriorityQueue<?>) {
        PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
        this.comparator = (Comparator<? super E>) pq.comparator();
        initFromPriorityQueue(pq);
    }
    else {
        this.comparator = null;
        initFromCollection(c);
    }
}

/**
 * Creates a {@code PriorityQueue} containing the elements in the
 * specified priority queue.  This priority queue will be
 * ordered according to the same ordering as the given priority
 * queue.
 *
 * @param  c the priority queue whose elements are to be placed
 *         into this priority queue
 * @throws ClassCastException if elements of {@code c} cannot be
 *         compared to one another according to {@code c}'s
 *         ordering
 * @throws NullPointerException if the specified priority queue or any
 *         of its elements are null
 */
@SuppressWarnings("unchecked")
public PriorityBlockingQueueDemo(PriorityQueue<? extends E> c) {
    this.comparator = (Comparator<? super E>) c.comparator();
    initFromPriorityQueue(c);
}

/**
 * Creates a {@code PriorityQueue} containing the elements in the
 * specified sorted set.   This priority queue will be ordered
 * according to the same ordering as the given sorted set.
 *
 * @param  c the sorted set whose elements are to be placed
 *         into this priority queue
 * @throws ClassCastException if elements of the specified sorted
 *         set cannot be compared to one another according to the
 *         sorted set's ordering
 * @throws NullPointerException if the specified sorted set or any
 *         of its elements are null
 */
@SuppressWarnings("unchecked")
public PriorityBlockingQueueDemo(SortedSet<? extends E> c) {
    this.comparator = (Comparator<? super E>) c.comparator();
    initElementsFromCollection(c);
}

private void initFromPriorityQueue(PriorityQueue<? extends E> c) {
    if (c.getClass() == PriorityQueue.class) {
        this.queue = c.toArray();
        this.size = c.size();
    } else {
        initFromCollection(c);
    }
}

private void initElementsFromCollection(Collection<? extends E> c) {
    Object[] a = c.toArray();
    // If c.toArray incorrectly doesn't return Object[], copy it.
    if (a.getClass() != Object[].class)
        a = Arrays.copyOf(a, a.length, Object[].class);
    int len = a.length;
    if (len == 1 || this.comparator != null)
        for (int i = 0; i < len; i++)
            if (a[i] == null)
                throw new NullPointerException();
    this.queue = a;
    this.size = a.length;
}

/**
 * Initializes queue array with elements from the given Collection.
 *
 * @param c the collection
 */
private void initFromCollection(Collection<? extends E> c) {
    initElementsFromCollection(c);
    heapify();
}

/**
 * The maximum size of array to allocate.
 * Some VMs reserve some header words in an array.
 * Attempts to allocate larger arrays may result in
 * OutOfMemoryError: Requested array size exceeds VM limit
 */
private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

/**
 * Increases the capacity of the array.
 *
 * @param minCapacity the desired minimum capacity
 */
private void grow(int minCapacity) {
    int oldCapacity = queue.length;
    // Double size if small; else grow by 50%
    int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                     (oldCapacity + 2) :
                                     (oldCapacity >> 1));
    // overflow-conscious code
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    queue = Arrays.copyOf(queue, newCapacity);
}

private static int hugeCapacity(int minCapacity) {
    if (minCapacity < 0) // overflow
        throw new OutOfMemoryError();
    return (minCapacity > MAX_ARRAY_SIZE) ?
        Integer.MAX_VALUE :
        MAX_ARRAY_SIZE;
}

/**
 * Inserts the specified element into this priority queue.
 *
 * @return {@code true} (as specified by {@link Collection#add})
 * @throws ClassCastException if the specified element cannot be
 *         compared with elements currently in this priority queue
 *         according to the priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */
public boolean add(E e) {
    return offer(e);
}

/**
 * Inserts the specified element into this priority queue.
 *
 * @return {@code true} (as specified by {@link Queue#offer})
 * @throws ClassCastException if the specified element cannot be
 *         compared with elements currently in this priority queue
 *         according to the priority queue's ordering
 * @throws NullPointerException if the specified element is null
 */
public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e);
    return true;
}

public E peek() {
    if (size == 0)
        return null;
    return (E) queue[0];
}

private int indexOf(Object o) {
    if (o != null) {
        for (int i = 0; i < size; i++)
            if (o.equals(queue[i]))
                return i;
    }
    return -1;
}

/**
 * Removes a single instance of the specified element from this queue,
 * if it is present.  More formally, removes an element {@code e} such
 * that {@code o.equals(e)}, if this queue contains one or more such
 * elements.  Returns {@code true} if and only if this queue contained
 * the specified element (or equivalently, if this queue changed as a
 * result of the call).
 *
 * @param o element to be removed from this queue, if present
 * @return {@code true} if this queue changed as a result of the call
 */
public boolean remove(Object o) {
    int i = indexOf(o);
    if (i == -1)
        return false;
    else {
        removeAt(i);
        return true;
    }
}

/**
 * Version of remove using reference equality, not equals.
 * Needed by iterator.remove.
 *
 * @param o element to be removed from this queue, if present
 * @return {@code true} if removed
 */
boolean removeEq(Object o) {
    for (int i = 0; i < size; i++) {
        if (o == queue[i]) {
            removeAt(i);
            return true;
        }
    }
    return false;
}

/**
 * Returns {@code true} if this queue contains the specified element.
 * More formally, returns {@code true} if and only if this queue contains
 * at least one element {@code e} such that {@code o.equals(e)}.
 *
 * @param o object to be checked for containment in this queue
 * @return {@code true} if this queue contains the specified element
 */
public boolean contains(Object o) {
    return indexOf(o) != -1;
}

/**
 * Returns an array containing all of the elements in this queue.
 * The elements are in no particular order.
 *
 * <p>The returned array will be "safe" in that no references to it are
 * maintained by this queue.  (In other words, this method must allocate
 * a new array).  The caller is thus free to modify the returned array.
 *
 * <p>This method acts as bridge between array-based and collection-based
 * APIs.
 *
 * @return an array containing all of the elements in this queue
 */
public Object[] toArray() {
    return Arrays.copyOf(queue, size);
}

/**
 * Returns an array containing all of the elements in this queue; the
 * runtime type of the returned array is that of the specified array.
 * The returned array elements are in no particular order.
 * If the queue fits in the specified array, it is returned therein.
 * Otherwise, a new array is allocated with the runtime type of the
 * specified array and the size of this queue.
 *
 * <p>If the queue fits in the specified array with room to spare
 * (i.e., the array has more elements than the queue), the element in
 * the array immediately following the end of the collection is set to
 * {@code null}.
 *
 * <p>Like the {@link #toArray()} method, this method acts as bridge between
 * array-based and collection-based APIs.  Further, this method allows
 * precise control over the runtime type of the output array, and may,
 * under certain circumstances, be used to save allocation costs.
 *
 * <p>Suppose <tt>x</tt> is a queue known to contain only strings.
 * The following code can be used to dump the queue into a newly
 * allocated array of <tt>String</tt>:
 *
 * <pre>
 *     String[] y = x.toArray(new String[0]);</pre>
 *
 * Note that <tt>toArray(new Object[0])</tt> is identical in function to
 * <tt>toArray()</tt>.
 *
 * @param a the array into which the elements of the queue are to
 *          be stored, if it is big enough; otherwise, a new array of the
 *          same runtime type is allocated for this purpose.
 * @return an array containing all of the elements in this queue
 * @throws ArrayStoreException if the runtime type of the specified array
 *         is not a supertype of the runtime type of every element in
 *         this queue
 * @throws NullPointerException if the specified array is null
 */
public <T> T[] toArray(T[] a) {
    if (a.length < size)
        // Make a new array of a's runtime type, but my contents:
        return (T[]) Arrays.copyOf(queue, size, a.getClass());
    System.arraycopy(queue, 0, a, 0, size);
    if (a.length > size)
        a[size] = null;
    return a;
}

/**
 * Returns an iterator over the elements in this queue. The iterator
 * does not return the elements in any particular order.
 *
 * @return an iterator over the elements in this queue
 */
public Iterator<E> iterator() {
    return new Itr();
}

private final class Itr implements Iterator<E> {
    /**
     * Index (into queue array) of element to be returned by
     * subsequent call to next.
     */
    private int cursor = 0;

    /**
     * Index of element returned by most recent call to next,
     * unless that element came from the forgetMeNot list.
     * Set to -1 if element is deleted by a call to remove.
     */
    private int lastRet = -1;

    /**
     * A queue of elements that were moved from the unvisited portion of
     * the heap into the visited portion as a result of "unlucky" element
     * removals during the iteration.  (Unlucky element removals are those
     * that require a siftup instead of a siftdown.)  We must visit all of
     * the elements in this list to complete the iteration.  We do this
     * after we've completed the "normal" iteration.
     *
     * We expect that most iterations, even those involving removals,
     * will not need to store elements in this field.
     */
    private ArrayDeque<E> forgetMeNot = null;

    /**
     * Element returned by the most recent call to next iff that
     * element was drawn from the forgetMeNot list.
     */
    private E lastRetElt = null;

    /**
     * The modCount value that the iterator believes that the backing
     * Queue should have.  If this expectation is violated, the iterator
     * has detected concurrent modification.
     */
    private int expectedModCount = modCount;

    public boolean hasNext() {
        return cursor < size ||
            (forgetMeNot != null && !forgetMeNot.isEmpty());
    }

    public E next() {
        if (expectedModCount != modCount)
            throw new ConcurrentModificationException();
        if (cursor < size)
            return (E) queue[lastRet = cursor++];
        if (forgetMeNot != null) {
            lastRet = -1;
            lastRetElt = forgetMeNot.poll();
            if (lastRetElt != null)
                return lastRetElt;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        if (expectedModCount != modCount)
            throw new ConcurrentModificationException();
        if (lastRet != -1) {
            E moved = PriorityBlockingQueueDemo.this.removeAt(lastRet);
            lastRet = -1;
            if (moved == null)
                cursor--;
            else {
                if (forgetMeNot == null)
                    forgetMeNot = new ArrayDeque();
                forgetMeNot.add(moved);
            }
        } else if (lastRetElt != null) {
        	PriorityBlockingQueueDemo.this.removeEq(lastRetElt);
            lastRetElt = null;
        } else {
            throw new IllegalStateException();
        }
        expectedModCount = modCount;
    }
}

public int size() {
    return size;
}

/**
 * Removes all of the elements from this priority queue.
 * The queue will be empty after this call returns.
 */
public void clear() {
    modCount++;
    for (int i = 0; i < size; i++)
        queue[i] = null;
    size = 0;
}

public E poll() {
    if (size == 0)
        return null;
    int s = --size;
    modCount++;
    E result = (E) queue[0];
    E x = (E) queue[s];
    queue[s] = null;
    if (s != 0)
        siftDown(0, x);
    return result;
}

/**
 * Removes the ith element from queue.
 *
 * Normally this method leaves the elements at up to i-1,
 * inclusive, untouched.  Under these circumstances, it returns
 * null.  Occasionally, in order to maintain the heap invariant,
 * it must swap a later element of the list with one earlier than
 * i.  Under these circumstances, this method returns the element
 * that was previously at the end of the list and is now at some
 * position before i. This fact is used by iterator.remove so as to
 * avoid missing traversing elements.
 */
private E removeAt(int i) {
    assert i >= 0 && i < size;
    modCount++;
    int s = --size;
    if (s == i) // removed last element
        queue[i] = null;
    else {
        E moved = (E) queue[s];
        queue[s] = null;
        siftDown(i, moved);
        if (queue[i] == moved) {
            siftUp(i, moved);
            if (queue[i] != moved)
                return moved;
        }
    }
    return null;
}

/**
 * Inserts item x at position k, maintaining heap invariant by
 * promoting x up the tree until it is greater than or equal to
 * its parent, or is the root.
 *
 * To simplify and speed up coercions and comparisons. the
 * Comparable and Comparator versions are separated into different
 * methods that are otherwise identical. (Similarly for siftDown.)
 *
 * @param k the position to fill
 * @param x the item to insert
 */
private void siftUp(int k, E x) {
    if (comparator != null)
        siftUpUsingComparator(k, x);
    else
        siftUpComparable(k, x);
}

private void siftUpComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>) x;
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (key.compareTo((E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = key;
}

private void siftUpUsingComparator(int k, E x) {
    while (k > 0) {
        int parent = (k - 1) >>> 1;
        Object e = queue[parent];
        if (comparator.compare(x, (E) e) >= 0)
            break;
        queue[k] = e;
        k = parent;
    }
    queue[k] = x;
}

/**
 * Inserts item x at position k, maintaining heap invariant by
 * demoting x down the tree repeatedly until it is less than or
 * equal to its children or is a leaf.
 *
 * @param k the position to fill
 * @param x the item to insert
 */
private void siftDown(int k, E x) {
    if (comparator != null)
        siftDownUsingComparator(k, x);
    else
        siftDownComparable(k, x);
}

private void siftDownComparable(int k, E x) {
    Comparable<? super E> key = (Comparable<? super E>)x;
    int half = size >>> 1;        // loop while a non-leaf
    while (k < half) {
        int child = (k << 1) + 1; // assume left child is least
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
            c = queue[child = right];
        if (key.compareTo((E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = key;
}

private void siftDownUsingComparator(int k, E x) {
    int half = size >>> 1;
    while (k < half) {
        int child = (k << 1) + 1;
        Object c = queue[child];
        int right = child + 1;
        if (right < size &&
            comparator.compare((E) c, (E) queue[right]) > 0)
            c = queue[child = right];
        if (comparator.compare(x, (E) c) <= 0)
            break;
        queue[k] = c;
        k = child;
    }
    queue[k] = x;
}

/**
 * Establishes the heap invariant (described above) in the entire tree,
 * assuming nothing about the order of the elements prior to the call.
 */
private void heapify() {
    for (int i = (size >>> 1) - 1; i >= 0; i--)
        siftDown(i, (E) queue[i]);
}

/**
 * Returns the comparator used to order the elements in this
 * queue, or {@code null} if this queue is sorted according to
 * the {@linkplain Comparable natural ordering} of its elements.
 *
 * @return the comparator used to order this queue, or
 *         {@code null} if this queue is sorted according to the
 *         natural ordering of its elements
 */
public Comparator<? super E> comparator() {
    return comparator;
}

/**
 * Saves the state of the instance to a stream (that
 * is, serializes it).
 *
 * @serialData The length of the array backing the instance is
 *             emitted (int), followed by all of its elements
 *             (each an {@code Object}) in the proper order.
 * @param s the stream
 */
private void writeObject(java.io.ObjectOutputStream s)
    throws java.io.IOException{
    // Write out element count, and any hidden stuff
    s.defaultWriteObject();

    // Write out array length, for compatibility with 1.5 version
    s.writeInt(Math.max(2, size + 1));

    // Write out all elements in the "proper order".
    for (int i = 0; i < size; i++)
        s.writeObject(queue[i]);
}

/**
 * Reconstitutes the {@code PriorityQueue} instance from a stream
 * (that is, deserializes it).
 *
 * @param s the stream
 */
private void readObject(java.io.ObjectInputStream s)
    throws java.io.IOException, ClassNotFoundException {
    // Read in size, and any hidden stuff
    s.defaultReadObject();

    // Read in (and discard) array length
    s.readInt();

    queue = new Object[size];

    // Read in all elements.
    for (int i = 0; i < size; i++)
        queue[i] = s.readObject();

    // Elements are guaranteed to be in "proper order", but the
    // spec has never explained what that might be.
    heapify();
}

	public static void main(String[] args) {
		
		Object[] array = new Object[10];
		array[0] = new Object();
		System.out.println(array[0]);
		
		Object a0 = array[0];
		a0 = new Object();
		
		System.out.println(array[0]);
		System.out.println(array[0]==a0);
		
		PriorityBlockingQueueDemo<Integer> q = new PriorityBlockingQueueDemo<Integer>();
		/*ArrayBlockingQueue, 
		DelayQueue, 
		LinkedBlockingDeque, 
		LinkedBlockingQueue, 
		PriorityBlockingQueue, 
		SynchronousQueue*/ 	
		
		/*ArrayBlockingQueue, 
		ConcurrentLinkedQueue, 
		DelayQueue, 
		LinkedBlockingDeque, 
		LinkedBlockingQueue, 
		PriorityBlockingQueue, 
		PriorityQueue, 
		SynchronousQueue */
		q.offer(11);
		q.offer(10);
		q.offer(9);
		q.offer(8);
		q.offer(7);
		q.offer(6);
		q.offer(5);
		q.offer(4);
		q.offer(3);	
		q.offer(2);	
		q.offer(12);
		//q.put(0);
		System.out.println(q.peek());
		for(Object o : q) {
			//System.out.println(q);
		}
	}
}
