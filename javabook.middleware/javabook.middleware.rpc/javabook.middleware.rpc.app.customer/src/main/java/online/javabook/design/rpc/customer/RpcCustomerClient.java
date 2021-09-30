package online.javabook.design.rpc.customer;

import online.javabook.design.rpc.server.api.reference.IRpcServiceReference;
import online.javabook.design.rpc.core.impl.engine.RPCFramework;
import online.javabook.design.rpc.provider.service.api.IHelloService;

public class RpcCustomerClient {

	public static void main(String[] args) throws Exception {

		// where is register
		RPCFramework.getInstance().setRegisterServerHost("127.0.0.1");
		RPCFramework.getInstance().setRegisterServerPort(9999);

		// get remote service
		IRpcServiceReference reference = RPCFramework.getInstance().getServiceReference(IHelloService.class, null);
		IHelloService helloService = reference.getService();

		// call remove service
		String result = helloService.hello("summer");
		System.out.println(result);
	}
}
