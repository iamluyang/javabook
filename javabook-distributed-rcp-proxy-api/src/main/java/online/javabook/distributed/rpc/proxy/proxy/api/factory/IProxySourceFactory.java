package online.javabook.distributed.rpc.proxy.proxy.api.factory;

import online.javabook.distributed.rpc.proxy.proxy.api.handler.IProxySource;
import online.javabook.distributed.rpc.proxy.proxy.api.invoker.IProxyInvoker;
import online.javabook.distributed.rpc.proxy.proxy.api.tracking.IUsageTracking;

/**
 * @author Summer Lu
 * @param <T>
 * @email gmluyang@gmail.com
 * @date 2014-11-22
 *
 */
public interface IProxySourceFactory {

	/**
	 * @param pooledObject
	 * @param proxySource
	 * @param proxyInvoker
	 * @param usageTracking
	 * @return
	 */
	public <T> Object createProxySource(IProxySource<T> proxySource, IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking);
}
