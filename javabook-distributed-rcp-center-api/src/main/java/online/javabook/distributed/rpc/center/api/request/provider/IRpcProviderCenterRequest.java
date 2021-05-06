package online.javabook.distributed.rpc.center.api.request.provider;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcProviderCenterRequest {

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

	/**
	 * @return
	 */
	public String getMethodName();

	/**
	 * @return
	 */
	public void setMethodName(String methodName);
	
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @return
	 */
	public Class<?>[] getParameterTypes();
	
	/**
	 * @return
	 */
	public void setParameterTypes(Class<?>[] parameterTypes);
	
	/**
	 * @return
	 */
	public Object[] getArguments();
	
	/**
	 * @return
	 */
	public void setArguments(Object[] arguments);

}
