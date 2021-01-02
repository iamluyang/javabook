package online.javabook.concurrent.coll.copyonwritearray;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 技术特性
 * 1- 数据结构： ArrayList的一个线程安全的变体，其中所有可变操作（add、set 等等）都是通过对底层数组进行一次新的复制来实现的。 
 * 
 * 2- 容器边界：
 * 
 * 3- 阻塞性质：这一般需要很大的开销，但是当遍历操作的数量大大超过可变操作的数量时，这种方法可能比其他替代方法更 有效。
 * 	                  在不能或不想进行同步遍历，但又需要从并发线程中排除冲突时，它也很有用。
 * 
 * 4- 容器性质：“快照”风格的迭代器方法在创建迭代器时使用了对数组状态的引用。
 *                     此数组在迭代器的生存期内不会更改，因此不可能发生冲突，并且迭代器保证不会抛出 ConcurrentModificationException。
 *                     创建迭代器以后，迭代器就不会反映列表的添加、移除或者更改。
 *                     在迭代器上进行的元素更改操作（remove、set 和 add）不受支持。这些方法将抛出 UnsupportedOperationException。  
 *                     
 * 5- 数据支持：允许使用所有元素，包括 null。
 *  
 * 6- 内存一致性效果：内存一致性效果：正如其他并发集合一样，将对象放入 CopyOnWriteArrayList 之前的线程中的操作 happen-before 
 *                             随后通过另一线程从 CopyOnWriteArrayList 中访问或移除该元素的操作。
 *                        
 *  构造函数
 *             public CopyOnWriteArrayList(Collection<? extends E> c)
 *             		创建一个按 collection 的迭代器返回元素的顺序包含指定 collection 元素的列表。 
 *             
 *			    public CopyOnWriteArrayList(E[] toCopyIn)
 *					创建一个保存给定数组的副本的列表。           
 *  
 *  重要方法  
 * 				public E set(int index, E element)
 *              public boolean add(E e)
 *              public void add(int index, E element)
 *              public E remove(int index)
 *              public boolean addIfAbsent(E e)
 *              public boolean removeAll(Collection<?> c)
 *              public boolean retainAll(Collection<?> c)
 *              public int addAllAbsent(Collection<? extends E> c)
 *              public void clear()
 *              public boolean addAll(Collection<? extends E> c)
 *              public boolean addAll(int index, Collection<? extends E> c) *              
 * 					使用lock，并且使用COW，这些方法都会修改容器的数据，包括添加，删除
 * 
 *             迭代方法 - 内部类COWIterator
 * 				public Iterator<E> iterator()返回以恰当顺序在此列表元素上进行迭代的迭代器。 
 * 					构造该迭代器时，所返回的迭代器提供了列表状态的一个快照。遍历该迭代器时不需要执行任何同步。该迭代器不 支持 remove 方法。
 * 				
 * 				public ListIterator<E> listIterator()返回此列表元素的列表迭代器（按适当顺序）。 
 * 					构造该迭代器时，所返回的迭代器提供了列表状态的一个快照。遍历该迭代器时不需要执行任何同步。该迭代器不 支持 remove、set 或者 add 方法。 
 * 
 * 				           内部类COWSubList
 * 				
 *
 *  算法与数据结构
 *
 * 私有方法
 *     
 *    
 * @author LuYang
 *
 */
public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		CopyOnWriteArrayList q = new CopyOnWriteArrayList();
	}
}
