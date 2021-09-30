package online.javabook.design.rpc.server.impl.request.provider;

import online.javabook.design.rpc.server.api.request.provider.IRpcProviderRequest;

import java.io.Serializable;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcProviderServerRequestImpl implements IRpcProviderRequest, Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6447748491032455961L;
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * rpcProviderServerHost
	 */
	private String rpcProviderServerHost;
	
	/**
	 * rpcProviderServerPort
	 */
	private int rpcProviderServerPort;
	
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
	public String getRpcProviderServerHost() {
		return rpcProviderServerHost;
	}
	
	@Override
	public void setRpcProviderServerHost(String rpcProviderServerHost) {
		this.rpcProviderServerHost = rpcProviderServerHost;
	}
	
	@Override
	public int getRpcProviderServerPort() {
		return rpcProviderServerPort;
	}
	
	@Override
	public void setRpcProviderServerPort(int rpcProviderServerPort) {
		this.rpcProviderServerPort = rpcProviderServerPort;
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
