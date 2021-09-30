package online.javabook.design.rpc.proxy.api.factory;

import online.javabook.design.rpc.proxy.api.handler.IProxySource;
import online.javabook.design.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.design.rpc.proxy.api.tracking.IUsageTracking;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-22
 *
 */
public interface IProxySourceFactory {

	/**
	 *
	 * @param proxySource
	 * @param proxyInvoker
	 * @param usageTracking
	 * @param <T>
	 * @return
	 */
	public <T> Object createProxySource(IProxySource<T> proxySource, IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking);
}
