package online.javabook.distributed.rpc.center.api.request.register;

import java.io.Serializable;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcRegisterCenterRequest extends Serializable {
	
	/**
	 * @return
	 */
	public String getRpcRegisterCenterHost();

	/**
	 * @param rpcRegisterCenterHost
	 */
	public void setRpcRegisterCenterHost(String rpcRegisterCenterHost);

	/**
	 * @return
	 */
	public int getRpcRegisterCenterPort();
	
	/**
	 * @param rpcRegisterCenterPort
	 */
	public void setRpcRegisterCenterPort(int rpcRegisterCenterPort);
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @return
	 */
	public String getRpcProviderCenterHost();

	/**
	 * @param rpcProviderCenterHost
	 */
	public void setRpcProviderCenterHost(String rpcProviderCenterHost);
	
	/**
	 * @return
	 */
	public int getRpcProviderCenterPort();
	
	/**
	 * @param rpcProviderCenterPort
	 */
	public void setRpcProviderCenterPort(int rpcProviderCenterPort);
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @return
	 */
	public String getServiceName();

	/**
	 * @return
	 */
	public void setServiceName(String serviceName);
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @return
	 */
	public IRpcRegisterCenterRequestType getRpcRegisterCenterRequestType();

	/**
	 * @return
	 */
	public void setRpcRegisterCenterRequestType(IRpcRegisterCenterRequestType requestType);
	
}
