package online.javabook.distributed.rpc.provider;

import online.javabook.distributed.rpc.proxy.core.impl.engine.RPCFramework;

public class RpcRegister {

	public static void main(String[] args) throws Exception {
		
		RPCFramework.getInstance().setRpcCenterHost("127.0.0.1");
		RPCFramework.getInstance().setRpcCenterPort(9999);
		RPCFramework.getInstance().startRpcCenter();
	}
}
