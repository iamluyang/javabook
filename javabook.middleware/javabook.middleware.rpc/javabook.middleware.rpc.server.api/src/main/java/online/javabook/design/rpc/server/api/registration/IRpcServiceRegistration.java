package online.javabook.design.rpc.server.api.registration;

/**
 * A registered service.
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcServiceRegistration {

    /**
     * @return the serviceName
     */
    public String getServiceName();

    /**
     * @param serviceName the serviceName to set
     */
    public void setServiceName(String serviceName);

    /**
     * @return the service
     */
    public <S> S getServiceObject();

    /**
     * @param service the service to set
     */
    public <S> void setServiceObject(S service);

    /**
     * @return the classes
     */
    public String[] getInterfaceNames();

    /**
     * @param classes the classes to set
     */
    public void setInterfaceNames(String[] classes);

    // ----------------------------------------------------------------------------------------------------
    // RpcProviderHost/RpcProviderPort
    // ----------------------------------------------------------------------------------------------------

    /**
     * @return the host
     */
    public String getRpcProviderHost();

    /**
     * @param host the host to set
     */
    public void setRpcProviderHost(String host);

    /**
     * @return the port
     */
    public int getRpcProviderPort();

    /**
     * @param port the port to set
     */
    public void setRpcProviderPort(int port);

    // ====================================================================================================
    // Ext
    // ====================================================================================================

    /**
     * @return the application
     */
    public String getApplication();

    /**
     * @param application the application to set
     */
    public void setApplication(String application);

    /**
     * @return the version
     */
    public String getVersion();

    /**
     * @param version the version to set
     */
    public void setVersion(String version);

    /**
     * @return the serviceRanking
     */
    public int getRanking();

    /**
     * @param ranking
     */
    public void setRanking(int ranking);

    /**
     * @return the description
     */
    public String getDescription();

    /**
     * @param description the description to set
     */
    public void setDescription(String description);

    /**
     * @return the vendor
     */
    public String getVendor();

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor);

}
