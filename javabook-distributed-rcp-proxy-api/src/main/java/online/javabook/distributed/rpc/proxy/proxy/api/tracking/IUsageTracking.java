package online.javabook.distributed.rpc.proxy.proxy.api.tracking;

/**
 * This interface may be implemented by an object pool to enable clients
 * (primarily those clients that wrap pools to provide pools with extended
 * features) to provide additional information to the pool relating to object
 * using allowing more informed decisions and reporting to be made regarding
 * abandoned objects.
 *
 * @param <T>
 *            The type of object provided by the pool.
 *            
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 */
public interface IUsageTracking<T> {

	/**
	 * This method is called every time a pooled object to enable the pool to
	 * better track borrowed objects.
	 *
	 * @param pooledObject
	 *            The object that is being used
	 */
	void use(T pooledObject);
}
