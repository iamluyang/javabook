package online.javabook.design.rpc.server.impl.request.register;

import online.javabook.design.rpc.server.api.request.register.IRpcRegisterRequestType;
import online.javabook.design.rpc.server.api.request.register.IRpcRegisterRequest;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcRegisterCenterRequestImpl implements IRpcRegisterRequest {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6447748491032455961L;
	
	/**
	 * rpcRegisterServerHost
	 */
	private String rpcRegisterServerHost;
	
	/**
	 * rpcRegisterServerPort
	 */
	private int rpcRegisterServerPort;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * rpcProviderServerHost
	 */
	private String rpcProviderServerHost;
	
	/**
	 * rpcProviderServerPost
	 */
	private int rpcProviderServerPost;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * serviceName
	 */
	private String serviceName;
	
	/**
	 * rpcRegisterRequestType
	 */
	private IRpcRegisterRequestType rpcRegisterRequestType;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @return the rpcRegisterCenterHost
	 */
	public String getRpcRegisterServerHost() {
		return rpcRegisterServerHost;
	}

	/**
	 * @param rpcRegisterServerHost the rpcRegisterCenterHost to set
	 */
	public void setRpcRegisterServerHost(String rpcRegisterServerHost) {
		this.rpcRegisterServerHost = rpcRegisterServerHost;
	}

	/**
	 * @return the rpcRegisterServerPort
	 */
	public int getRpcRegisterServerPort() {
		return rpcRegisterServerPort;
	}

	/**
	 * @param rpcRegisterServerPort the rpcRegisterServerPort to set
	 */
	public void setRpcRegisterServerPort(int rpcRegisterServerPort) {
		this.rpcRegisterServerPort = rpcRegisterServerPort;
	}
	
	// ----------------------------------------------------------------------------------------------------

	@Override
	public String getRpcProviderServerHost() {
		return rpcProviderServerHost;
	}
	
	@Override
	public void setRpcProviderServerHost(String rpcProviderServerHost) {
		this.rpcProviderServerHost = rpcProviderServerHost;
	}
	
	@Override
	public int getRpcProviderServerPort() {
		return rpcProviderServerPost;
	}
	
	@Override
	public void setRpcProviderServerPort(int rpcProviderServerPort) {
		this.rpcProviderServerPost = rpcProviderServerPort;
	}
	
	// ----------------------------------------------------------------------------------------------------

	@Override
	public String getServiceName() {
		return serviceName;
	}

	@Override
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public IRpcRegisterRequestType getRpcRegisterRequestType() {
		return this.rpcRegisterRequestType;
	}
	
	@Override
	public void setRpcRegisterRequestType(IRpcRegisterRequestType rpcRegisterRequestType) {
		this.rpcRegisterRequestType = rpcRegisterRequestType;
	}
}
