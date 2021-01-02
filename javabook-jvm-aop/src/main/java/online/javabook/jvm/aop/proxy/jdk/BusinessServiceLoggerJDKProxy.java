package online.javabook.jvm.aop.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-22
 *
 */
public class BusinessServiceLoggerJDKProxy implements InvocationHandler {

	/**
	 * delegate
	 */
	private Object delegate;

	/**
	 * @param delegate
	 * @return
	 */
	public <T> T proxy(T delegate) {
		this.delegate = delegate;
		return (T)Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			System.out.println("Begin invoke........." + method.getName());

			Object result = method.invoke(delegate, args);

			System.out.println("Finish invoke........." + method.getName());

			return result;
		}catch (Exception exception){
			System.out.println("Exception invoke........." + method.getName());
			throw exception;
		}
	}

}
