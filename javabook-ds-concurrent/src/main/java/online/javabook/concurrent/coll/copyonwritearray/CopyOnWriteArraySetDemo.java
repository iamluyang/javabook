package online.javabook.concurrent.coll.copyonwritearray;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 技术特性 对其所有操作使用内部 CopyOnWriteArrayList 的 Set。因此，它共享以下相同的基本属性：
 * 1- 数据结构：
 * 2- 使用场景：它最适合于具有以下特征的应用程序：set 大小通常保持很小，只读操作远多于可变操作，需要在遍历期间防止线程间的冲突。
 * 3- 性能开销：因为通常需要复制整个基础数组，所以可变操作（add、set 和 remove 等等）的开销很大。
 * 4- 线程安全：它是线程安全的。 
 * 5- 迭代：迭代器不支持可变 remove 操作。 
 *              使用迭代器进行遍历的速度很快，并且不会与其他线程发生冲突。在构造迭代器时，迭代器依赖于不变的数组快照。 
 * 6- 实例用法：以下代码使用一个写时复制（copy-on-write）的 set，以维护在状态更新时执行某项操作的一组 Handler 对象。见javadoc
 *     
 *  构造函数

 *  重要方法  
    public boolean add(E e) {
        return al.addIfAbsent(e);
    }
    
    public boolean addAll(Collection<? extends E> c) {
        return al.addAllAbsent(c) > 0;
    }
 *
 *  算法与数据结构
 *  	实际上封装了一个CopyOnWriteArrayList
 *
 * 私有方法
 *    
 * @author LuYang
 *
 */
public class CopyOnWriteArraySetDemo {

	public static void main(String[] args) {
		CopyOnWriteArraySet q = new CopyOnWriteArraySet();
	}
}
