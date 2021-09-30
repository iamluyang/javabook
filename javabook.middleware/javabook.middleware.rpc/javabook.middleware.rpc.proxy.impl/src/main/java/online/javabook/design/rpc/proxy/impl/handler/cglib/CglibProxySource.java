package online.javabook.design.rpc.proxy.impl.handler.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;

import online.javabook.design.rpc.proxy.api.handler.IProxySource;
import online.javabook.design.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.design.rpc.proxy.api.tracking.IUsageTracking;

/**
 * Provides proxy objects using CGLib.
 *
 * @param <T>
 *            type of the pooled object to be proxied
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 */
public class CglibProxySource<T> implements IProxySource<T> {

	/**
	 * superclass
	 */
	private final Class<? extends T> superclass;

	/**
	 * Create a new proxy source for the given class.
	 *
	 * @param superclass
	 *            The class to proxy
	 */
	public CglibProxySource(Class<? extends T> superclass) {
		this.superclass = superclass;
	}

	@Override
	public T createProxy(IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking) {
		
		// enhancer
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(superclass);

		// proxyInterceptor
		CglibProxyHandler<T> proxyInterceptor = new CglibProxyHandler<T>(proxyInvoker, usageTracking);
		enhancer.setCallback(proxyInterceptor);

		// proxy
		@SuppressWarnings("unchecked")
		T proxy = (T) enhancer.create();

		return proxy;
	}

	@Override
	public void resolveProxy(T proxy) {
		
		@SuppressWarnings("unchecked")
		CglibProxyHandler<T> cglibProxyHandler = (CglibProxyHandler<T>) ((Factory) proxy).getCallback(0);
	}
}
