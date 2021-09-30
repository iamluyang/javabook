package online.javabook.design.rpc.server.api.request.register;

import java.io.Serializable;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcRegisterRequest extends Serializable {

    /**
     * @return
     */
    public String getRpcRegisterServerHost();

    /**
     * @param rpcRegisterServerHost
     */
    public void setRpcRegisterServerHost(String rpcRegisterServerHost);

    /**
     * @return
     */
    public int getRpcRegisterServerPort();

    /**
     * @param rpcRegisterServerPort
     */
    public void setRpcRegisterServerPort(int rpcRegisterServerPort);

    // ----------------------------------------------------------------------------------------------------

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
    public IRpcRegisterRequestType getRpcRegisterRequestType();

    /**
     * @return
     */
    public void setRpcRegisterRequestType(IRpcRegisterRequestType rpcRegisterRequestType);

}
