package online.javabook.distributed.rpc.register;

import online.javabook.distributed.rpc.core.impl.engine.RPCFramework;

public class RpcRegisterServer {

	public static void main(String[] args) throws Exception {
		
		RPCFramework.getInstance().setRegisterServerHost("127.0.0.1");
		RPCFramework.getInstance().setRegisterServerPort(9999);
		RPCFramework.getInstance().startRpcRegisterServer();
	}
}
