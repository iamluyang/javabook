package online.javabook.distributed.rpc.proxy.impl.handler.jdk;

import java.lang.reflect.Proxy;

import online.javabook.distributed.rpc.proxy.api.handler.IProxySource;
import online.javabook.distributed.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.distributed.rpc.proxy.api.tracking.IUsageTracking;

/**
 * Provides proxy objects using Java reflection.
 *
 * @param <T>
 *            type of the pooled object to be proxied
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 */
public class JdkProxySource<T> implements IProxySource<T> {

	/**
	 * classLoader
	 */
	private final ClassLoader classLoader;
	
	/**
	 * interfaces
	 */
	private final Class<?>[] interfaces;

	/**
	 * Create a new proxy source for the given interfaces.
	 *
	 * @param classLoader
	 *            The class loader with which to create the proxy
	 * @param interfaces
	 *            The interfaces to proxy
	 */
	public JdkProxySource(ClassLoader classLoader, Class<?>[] interfaces) {
		
		// classLoader
		this.classLoader = classLoader;
		
		// Defensive copy
		this.interfaces = new Class<?>[interfaces.length];
		System.arraycopy(interfaces, 0, this.interfaces, 0, interfaces.length);
	}

	@Override
	public T createProxy(IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking) {
		
		// proxy
		@SuppressWarnings("unchecked")
		T proxy = (T) Proxy.newProxyInstance(classLoader, interfaces, new JdkProxyHandler<T>(proxyInvoker, usageTracking));
		return proxy;
	}

	@Override
	public void resolveProxy(T proxy) {
		
		@SuppressWarnings("unchecked")
		JdkProxyHandler<T> jdkProxyHandler = (JdkProxyHandler<T>) Proxy.getInvocationHandler(proxy);
	}
}
