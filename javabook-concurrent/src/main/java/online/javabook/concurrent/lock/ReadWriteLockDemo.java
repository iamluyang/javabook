package online.javabook.concurrent.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 此类具有以下属性：
 * 
 * 获取顺序 此类不会将读取者优先或写入者优先强加给锁访问的排序。但是，它确实支持可选的公平策略。
 * 
 * 非公平模式（默认） 当非公平地（默认）构造时，未指定进入读写锁的顺序，受到 reentrancy 约束的限制。连续竞争的非公平锁可能无限期地推迟一个或多个
 * reader 或 writer 线程，但吞吐量通常要高于公平锁。
 * 
 * 公平模式 当公平地构造线程时，线程利用一个近似到达顺序的策略来争夺进入。当释放当前保持的锁时，可以为等待时间最长的单个 writer
 * 线程分配写入锁，如果有一组等待时间大于所有正在等待的 writer 线程 的 reader 线程，将为该组分配写入锁。 如果保持写入锁，或者有一个等待的
 * writer 线程，则试图获得公平读取锁（非重入地）的线程将会阻塞。直到当前最旧的等待 writer
 * 线程已获得并释放了写入锁之后，该线程才会获得读取锁。当然，如果等待 writer 放弃其等待，而保留一个或更多 reader
 * 线程为队列中带有写入锁自由的时间最长的 waiter，则将为那些 reader 分配读取锁。
 * 
 * 试图获得公平写入锁的（非重入地）的线程将会阻塞，除非读取锁和写入锁都自由（这意味着没有等待线程）。（注意，非阻塞
 * ReentrantReadWriteLock.ReadLock.tryLock() 和
 * ReentrantReadWriteLock.WriteLock.tryLock() 方法不会遵守此公平设置，并将获得锁（如果可能），不考虑等待线程）。
 * 
 * 
 * 重入 此锁允许 reader 和 writer 按照 ReentrantLock
 * 的样式重新获取读取锁或写入锁。在写入线程保持的所有写入锁都已经释放后，才允许重入 reader 使用它们。
 * 
 * 此外，writer
 * 可以获取读取锁，但反过来则不成立。在其他应用程序中，当在调用或回调那些在读取锁状态下执行读取操作的方法期间保持写入锁时，重入很有用。如果 reader
 * 试图获取写入锁，那么将永远不会获得成功。
 * 
 * 锁降级 重入还允许从写入锁降级为读取锁，其实现方式是：先获取写入锁，然后获取读取锁，最后释放写入锁。但是，从读取锁升级到写入锁是不可能的。
 * 
 * 锁获取的中断 读取锁和写入锁都支持锁获取期间的中断。
 * 
 * Condition 支持 写入锁提供了一个 Condition 实现，对于写入锁来说，该实现的行为与
 * ReentrantLock.newCondition() 提供的 Condition 实现对 ReentrantLock 所做的行为相同。当然，此
 * Condition 只能用于写入锁。
 * 
 * 读取锁不支持 Condition，readLock().newCondition() 会抛出 UnsupportedOperationException。
 * 
 * 监测 此类支持一些确定是保持锁还是争用锁的方法。这些方法设计用于监视系统状态，而不是同步控制。
 * 
 * 此类行为的序列化方式与内置锁的相同：反序列化的锁处于解除锁状态，无论序列化该锁时其状态如何。
 * 
 * @author LuYang
 * 
 */
public class ReadWriteLockDemo {

	public static void main(String[] args) {
		ReadWriteLock rwl = new ReentrantReadWriteLock();
	}
}
