package online.javabook.jvm.aop.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class BusinessServiceLoggerCglibProxy {

	public static <T> T proxy(Class<T> delegateClass) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(delegateClass);

		enhancer.setCallback((MethodInterceptor) (obj, method, objects, proxy) -> {
			try {
				System.out.println("Begin invoke........." + method.getName());

				Object result = proxy.invokeSuper(obj, objects);

				System.out.println("Finish invoke........." + method.getName());

				return result;
			}catch (Exception exception){
				System.out.println("Exception invoke........." + method.getName());
				throw exception;
			}
		});
		return (T) enhancer.create();
	}
}
