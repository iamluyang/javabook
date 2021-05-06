package online.javabook.distributed.rpc.center.impl.request.provider;

import java.io.Serializable;

import online.javabook.distributed.rpc.center.api.request.provider.IRpcProviderCenterRequest;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcProviderCenterRequestImpl implements IRpcProviderCenterRequest, Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6447748491032455961L;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * rpcProviderCenterHost
	 */
	private String rpcProviderCenterHost;
	
	/**
	 * rpcProviderCenterPort
	 */
	private int rpcProviderCenterPort;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * serviceName
	 */
	private String serviceName;
	
	/**
	 * methodName
	 */
	private String methodName;
	
	/**
	 * methodName
	 */
	private Class<?>[] parameterTypes;
	
	/**
	 * methodName
	 */
	private Object[] arguments;
	
	// ----------------------------------------------------------------------------------------------------

	@Override
	public String getRpcProviderCenterHost() {
		return rpcProviderCenterHost;
	}
	
	@Override
	public void setRpcProviderCenterHost(String serverHost) {
		this.rpcProviderCenterHost = serverHost;
	}
	
	@Override
	public int getRpcProviderCenterPort() {
		return rpcProviderCenterPort;
	}
	
	@Override
	public void setRpcProviderCenterPort(int serverPort) {
		this.rpcProviderCenterPort = serverPort;
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
	public String getMethodName() {
		return methodName;
	}

	@Override
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	@Override
	public Class<?>[] getParameterTypes() {
		return parameterTypes;
	}

	@Override
	public void setParameterTypes(Class<?>[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	@Override
	public Object[] getArguments() {
		return arguments;
	}

	@Override
	public void setArguments(Object[] arguments) {
		this.arguments = arguments;
	}

}
