package online.javabook.distributed.rpc.server.api.request.provider;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcProviderRequest {

    /**
     * @return
     */
    public String getRpcProviderServerHost();

    /**
     * @param rpcProviderServerHost
     */
    public void setRpcProviderServerHost(String rpcProviderServerHost);

    /**
     * @return
     */
    public int getRpcProviderServerPort();

    /**
     * @param rpcProviderServerPort
     */
    public void setRpcProviderServerPort(int rpcProviderServerPort);

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

    // ----------------------------------------------------------------------------------------------------

    /**
     * @return
     */
    public Object[] getArguments();

    /**
     * @return
     */
    public void setArguments(Object[] arguments);

}
