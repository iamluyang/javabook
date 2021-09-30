package online.javabook.design.rpc.provider;

import online.javabook.design.rpc.provider.service.api.IHelloService;
import online.javabook.design.rpc.provider.service.impl.HelloServiceImpl;
import online.javabook.design.rpc.core.impl.engine.RPCFramework;

public class RpcProviderServer {

	public static void main(String[] args) throws Exception {

		// where is register
		RPCFramework.getInstance().setRegisterServerPort(9999);
		RPCFramework.getInstance().setRegisterServerHost("127.0.0.1");

		// where is provider
		RPCFramework.getInstance().setProviderServerHost("127.0.0.1");
		RPCFramework.getInstance().setProviderServerPort(1111);

		// start provider
		RPCFramework.getInstance().startProviderServer();

		// export service
		IHelloService helloService = new HelloServiceImpl();
		RPCFramework.getInstance().exporterService(helloService, null);

	}
}
