package online.javabook.distributed.rpc.proxy.proxy.impl.handler.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import online.javabook.distributed.rpc.proxy.proxy.api.invoker.IProxyInvoker;
import online.javabook.distributed.rpc.proxy.proxy.api.tracking.IUsageTracking;
import online.javabook.distributed.rpc.proxy.proxy.impl.handler.ProxyHandlerImpl;

/**
 * Java reflection implementation of the proxy handler.
 *
 * @param <T>
 *            type of the wrapped pooled object
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 */
public class JdkProxyHandler<T> extends ProxyHandlerImpl<T> implements InvocationHandler {

	/**
	 * Create a Java reflection proxy instance.
	 *
	 * @param proxiedObject
	 *            The object to wrap
	 * @param usageTracking
	 *            The instance, if any (usually the object pool) to be provided
	 *            with usage tracking information for this wrapped object
	 */
	JdkProxyHandler(IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking) {
		super(proxyInvoker, usageTracking);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return doInvoke(method, args);
	}
}
