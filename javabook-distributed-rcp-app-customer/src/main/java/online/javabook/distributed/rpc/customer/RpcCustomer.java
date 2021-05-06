package online.javabook.distributed.rpc.customer;

import online.javabook.distributed.rpc.center.api.reference.IRpcServiceReference;
import online.javabook.distributed.rpc.provider.service.api.IHelloService;
import online.javabook.distributed.rpc.proxy.core.impl.engine.RPCFramework;

public class RpcCustomer {

	public static void main(String[] args) throws Exception {

		// where is register
		RPCFramework.getInstance().setRpcCenterHost("127.0.0.1");
		RPCFramework.getInstance().setRpcCenterPort(9999);

		// get remote service
		IRpcServiceReference reference = RPCFramework.getInstance().getServiceReference(IHelloService.class, null);
		IHelloService helloService = reference.getService();

		// call remove service
		System.out.println(helloService.hello("luyang"));
	}
}
