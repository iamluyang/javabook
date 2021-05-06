/**
 * 
 */
package online.javabook.distributed.rpc.proxy.proxy.impl.factory;

import online.javabook.distributed.rpc.proxy.proxy.api.factory.IProxySourceFactory;
import online.javabook.distributed.rpc.proxy.proxy.api.handler.IProxySource;
import online.javabook.distributed.rpc.proxy.proxy.api.invoker.IProxyInvoker;
import online.javabook.distributed.rpc.proxy.proxy.api.tracking.IUsageTracking;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-22
 *
 */
public class ProxySourceFactoryImpl implements IProxySourceFactory {

	/**
	 * instance
	 */
	private static IProxySourceFactory instance = new ProxySourceFactoryImpl();
	
	/**
	 * 
	 */
	private ProxySourceFactoryImpl() {

	}
	
	/**
	 * @return
	 */
	public static IProxySourceFactory getInstance() {
		return instance;
	}
	
	@Override
	public <T> T createProxySource(IProxySource<T> proxySource, IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking) {
		T proxy = proxySource.createProxy(proxyInvoker, usageTracking);
		return proxy;
	}

}
