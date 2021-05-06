package online.javabook.distributed.rpc.proxy.proxy.api.invoker;

import java.lang.reflect.Method;

/**
 * Base implementation for object wrappers when using a
 * {@link ProxiedObjectPool}.
 *
 * @param <T>
 *            type of the wrapped pooled object
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-23
 */
public interface IProxyInvoker<T> {

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
	public Object doInvoke(Method method, Object[] args) throws Throwable;

}