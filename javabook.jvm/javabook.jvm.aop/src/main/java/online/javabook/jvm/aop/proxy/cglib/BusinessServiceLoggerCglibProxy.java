package online.javabook.jvm.aop.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import org.apache.log4j.Logger;

public class BusinessServiceLoggerCglibProxy {

	private static Logger logger = Logger.getLogger(BusinessServiceLoggerCglibProxy.class.getName());

	public static <T> T proxy(Class<T> delegateClass) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(delegateClass);

		enhancer.setCallback((MethodInterceptor) (obj, method, objects, proxy) -> {
			try {
				logger.info("Begin invoke........." + method.getName());

				Object result = proxy.invokeSuper(obj, objects);

				logger.info("Finish invoke........." + method.getName());

				return result;
			}catch (Exception exception){
				logger.error("Exception invoke........." + method.getName(), exception);
				throw exception;
			}
		});
		return (T) enhancer.create();
	}
}
