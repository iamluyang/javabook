package online.javabook.distributed.rpc.proxy.impl.handler;

import java.lang.reflect.Method;

import online.javabook.distributed.rpc.proxy.api.handler.IProxyHandler;
import online.javabook.distributed.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.distributed.rpc.proxy.api.tracking.IUsageTracking;

/**
 * Base implementation for object wrappers when using a
 * ProxiedObjectPool.
 *
 * @param <T>
 *            type of the wrapped pooled object
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 *
 */
public class ProxyHandlerImpl<T> implements IProxyHandler<T> {

	/**
	 * proxyInvoker
	 */
	private final IProxyInvoker<T> proxyInvoker;
	
	/**
	 * usageTracking
	 */
	private final IUsageTracking<T> usageTracking;

	// ----------------------------------------------------------------------------------------------------
	// BaseProxyHandler
	// ----------------------------------------------------------------------------------------------------

	/**
	 * Create a new wrapper for the given pooled object.
	 *
	 * @param proxyInvoker
	 *            The object to wrap
	 * @param usageTracking
	 *            The instance, if any (usually the object pool) to be provided
	 *            with usage tracking information for this wrapped object
	 */
	public ProxyHandlerImpl(IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking) {
		this.proxyInvoker  = proxyInvoker;
		this.usageTracking = usageTracking;
	}

	// ----------------------------------------------------------------------------------------------------
	// doInvoke
	// ----------------------------------------------------------------------------------------------------

	/**
	 * Invoke the given method on the wrapped object.
	 *
	 * @param method
	 *            The method to invoke
	 * @param args
	 *            The arguments to the method
	 * @return The result of the method call
	 * @throws Throwable
	 *             If the method invocation fails
	 */
	@Override
	public Object doInvoke(Method method, Object[] args) throws Throwable {

		if (usageTracking != null) {
			usageTracking.use(null);
		}
		
		return proxyInvoker.doInvoke(method, args);
	}
}
