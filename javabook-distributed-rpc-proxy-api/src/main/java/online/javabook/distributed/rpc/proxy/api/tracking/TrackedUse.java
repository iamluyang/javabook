package online.javabook.distributed.rpc.proxy.api.tracking;

/**
 * This interface allows pooled objects to make information available about when
 * and how they were used available to the object pool. The object pool may, but
 * is not required, to use this information to make more informed decisions when
 * determining the state of a pooled object - for instance whether or not the
 * object has been abandoned.
 *
 * @version $Revision:$
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 *
 */
public interface TrackedUse {

	/**
	 * Get the last time this object was used in ms.
	 *
	 * @return long time in ms
	 */
	long getLastUsed();
}
