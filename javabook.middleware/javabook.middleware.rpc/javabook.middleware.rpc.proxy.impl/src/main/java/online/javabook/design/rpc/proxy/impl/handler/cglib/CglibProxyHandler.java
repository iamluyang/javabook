package online.javabook.design.rpc.proxy.impl.handler.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import online.javabook.design.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.design.rpc.proxy.api.tracking.IUsageTracking;
import online.javabook.design.rpc.proxy.impl.handler.ProxyHandlerImpl;

/**
 * CGLib implementation of the proxy handler.
 *
 * @param <T>
 *            type of the wrapped pooled object
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 */
public class CglibProxyHandler<T> extends ProxyHandlerImpl<T> implements MethodInterceptor {

	/**
	 * Create a CGLib proxy instance.
	 *
	 * @param usageTracking
	 *            The instance, if any (usually the object pool) to be provided
	 *            with usage tracking information for this wrapped object
	 */
	CglibProxyHandler(IProxyInvoker<T> proxyInvoker, IUsageTracking<T> usageTracking) {
		super(proxyInvoker, usageTracking);
	}

	@Override
	public Object intercept(Object proxiedObject, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		return doInvoke(method, args);
	}
}
