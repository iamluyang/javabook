package online.javabook.distributed.rpc.provider.service.api;


/**
 * @author LuYang
 *
 */
public interface IHelloService {

	/**
	 * @param name
	 * @return
	 */
	public String hello(String name);
}
