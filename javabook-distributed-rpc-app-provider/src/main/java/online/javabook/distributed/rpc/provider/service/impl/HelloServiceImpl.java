package online.javabook.distributed.rpc.provider.service.impl;

import online.javabook.distributed.rpc.provider.service.api.IHelloService;

/**
 * @author LuYang
 *
 */
public class HelloServiceImpl implements IHelloService {

	/**
	 * @param name
	 * @return
	 */
	public String hello(String name) {
		return "hello " + name;
	}
}
