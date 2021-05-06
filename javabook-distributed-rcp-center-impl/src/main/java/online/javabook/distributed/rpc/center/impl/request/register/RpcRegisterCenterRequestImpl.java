package online.javabook.distributed.rpc.center.impl.request.register;

import online.javabook.distributed.rpc.center.api.request.register.IRpcRegisterCenterRequest;
import online.javabook.distributed.rpc.center.api.request.register.IRpcRegisterCenterRequestType;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcRegisterCenterRequestImpl implements IRpcRegisterCenterRequest {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6447748491032455961L;
	
	/**
	 * rpcRegisterCenterHost
	 */
	private String rpcRegisterCenterHost;
	
	/**
	 * rpcRegisterCenterPort
	 */
	private int rpcRegisterCenterPort;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * rpcProviderCenterHost
	 */
	private String rpcProviderCenterHost;
	
	/**
	 * rpcProviderCenterPost
	 */
	private int rpcProviderCenterPost;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * serviceName
	 */
	private String serviceName;
	
	/**
	 * rpcRegisterCenterRequestType
	 */
	private IRpcRegisterCenterRequestType rpcRegisterCenterRequestType;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @return the rpcRegisterCenterHost
	 */
	public String getRpcRegisterCenterHost() {
		return rpcRegisterCenterHost;
	}

	/**
	 * @param rpcRegisterCenterHost the rpcRegisterCenterHost to set
	 */
	public void setRpcRegisterCenterHost(String rpcRegisterCenterHost) {
		this.rpcRegisterCenterHost = rpcRegisterCenterHost;
	}

	/**
	 * @return the registerPort
	 */
	public int getRpcRegisterCenterPort() {
		return rpcRegisterCenterPort;
	}

	/**
	 * @param rpcRegisterCenterPort the rpcRegisterCenterPort to set
	 */
	public void setRpcRegisterCenterPort(int rpcRegisterCenterPort) {
		this.rpcRegisterCenterPort = rpcRegisterCenterPort;
	}
	
	// ----------------------------------------------------------------------------------------------------

	@Override
	public String getRpcProviderCenterHost() {
		return rpcProviderCenterHost;
	}
	
	@Override
	public void setRpcProviderCenterHost(String rpcServiceCenterHost) {
		this.rpcProviderCenterHost = rpcServiceCenterHost;
	}
	
	@Override
	public int getRpcProviderCenterPort() {
		return rpcProviderCenterPost;
	}
	
	@Override
	public void setRpcProviderCenterPort(int rpcServiceCenterPort) {
		this.rpcProviderCenterPost = rpcServiceCenterPort;
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
	public IRpcRegisterCenterRequestType getRpcRegisterCenterRequestType() {
		return this.rpcRegisterCenterRequestType;
	}
	
	@Override
	public void setRpcRegisterCenterRequestType(IRpcRegisterCenterRequestType requestType) {
		this.rpcRegisterCenterRequestType = requestType;
	}
}
