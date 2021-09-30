package online.javabook.design.rpc.proxy.api.handler;

import online.javabook.design.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.design.rpc.proxy.api.tracking.IUsageTracking;


/**
 * The interface that any provide of proxy instances must implement to allow the
 * ProxiedObjectPool to create proxies as required.
 *
 * @param <T>
 *            type of the pooled object to be proxied
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 */
public interface IProxySource<T> {

	/**
	 * Create a new proxy object, wrapping the given pooled object.
	 *
	 * @param proxyInvoker
	 *            The object to wrap
	 * @param usageTracking
	 *            The instance, if any (usually the object pool) to be provided
	 *            with usage tracking information for this wrapped object
	 *
	 * @return the new proxy object
	 */
	public T createProxy(IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking);

	/**
	 * Obtain the wrapped object from the given proxy.
	 *
	 * @param proxy
	 *            The proxy object
	 *
	 * @return The pooled objetc wrapped by the given proxy
	 */
	public void resolveProxy(T proxy);
}
