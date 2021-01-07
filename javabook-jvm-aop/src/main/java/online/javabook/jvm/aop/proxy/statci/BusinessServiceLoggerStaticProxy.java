package online.javabook.jvm.aop.proxy.statci;

import online.javabook.jvm.aop.service.IBusinessService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class BusinessServiceLoggerStaticProxy implements IBusinessService {

	private Logger logger = LogManager.getLogger(BusinessServiceLoggerStaticProxy.class.getName());

	public IBusinessService businessService;

	public BusinessServiceLoggerStaticProxy(IBusinessService businessService) {
		this.businessService = businessService;
	}

	@Override
	public void doSomething1() {
		try {
			logger.info("Begin invoke........." + "doSomething1");

			businessService.doSomething1();

			logger.info("Finish invoke........." + "doSomething1");
		}catch (Exception exception){
			logger.error("Exception invoke........." + "doSomething1", exception);
		}
	}

	@Override
	public void doSomething2() {
		try {
			logger.info("Begin invoke........." + "doSomething2");

			businessService.doSomething2();

			logger.info("Finish invoke........." + "doSomething2");
		}catch (Exception exception){
			logger.error("Exception invoke........." + "doSomething2", exception);
		}
	}
}
