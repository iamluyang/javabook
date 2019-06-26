package com.javabook.oom;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-22
 *
 */
public class DProxy implements InvocationHandler {

	/**
	 * delegate
	 */
	private Object delegate;

	/**
	 * @param delegate
	 * @return
	 */
	public Object bind(Object delegate) {
		this.delegate = delegate;
		return Proxy.newProxyInstance(delegate.getClass().getClassLoader(),
		delegate.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)	throws Throwable {
		Object result = null;
		result = method.invoke(delegate, args);
		return result;
	}

}

