package online.javabook.jvm.aop.proxy.jdk;

import org.apache.log4j.Logger;

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

	private Logger logger = Logger.getLogger(BusinessServiceLoggerJDKProxy.class.getName());

	/**
	 * delegate
	 */
	private Object delegate;

	public <T> T proxy(Class<T> delegateClass) throws IllegalAccessException, InstantiationException {
		this.delegate = delegateClass.newInstance();
		return (T)Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			logger.info("Begin invoke........." + method.getName());

			Object result = method.invoke(delegate, args);

			logger.info("Finish invoke........." + method.getName());

			return result;
		}catch (Exception exception){
			logger.error("Exception invoke........." + method.getName(), exception);
			throw exception;
		}
	}

}
