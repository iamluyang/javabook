package online.javabook.distributed.rpc.provider;

import online.javabook.distributed.rpc.provider.service.api.IHelloService;
import online.javabook.distributed.rpc.provider.service.impl.HelloServiceImpl;
import online.javabook.distributed.rpc.proxy.core.impl.engine.RPCFramework;

public class RpcProvider {

	public static void main(String[] args) throws Exception {

		// where is register
		RPCFramework.getInstance().setRpcCenterPort(9999);
		RPCFramework.getInstance().setRpcCenterHost("127.0.0.1");

		// where is provider
		RPCFramework.getInstance().setRpcServerHost("127.0.0.1");
		RPCFramework.getInstance().setRpcServerPort(1111);

		// start provider
		RPCFramework.getInstance().startRpcServer();

		// export service
		IHelloService helloService = new HelloServiceImpl();
		RPCFramework.getInstance().exporterService(helloService, null);

	}
}
