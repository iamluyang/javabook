package online.javabook.distributed.rpc.proxy.core.api.framework;

import online.javabook.distributed.rpc.center.api.reference.IRpcServiceReference;
import org.apache.mina.core.service.IoAcceptor;

import java.io.IOException;
import java.util.Dictionary;

import javax.management.ServiceNotFoundException;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRPCFramework {

	// ====================================================================================================
	// Server
	// ====================================================================================================

	/**
	 * @param host the host to set
	 */
	public void setRpcServerHost(String host);

	/**
	 * @param host the host to get
	 */
	public String getRpcServerHost();

	/**
	 * @param port the port to set
	 */
	public void setRpcServerPort(int port);

	/**
	 * @param port the port to get
	 */
	public int getRpcServerPort();
	
	/**
	 * @param port
	 * @throws IOException 
	 * @throws Exception
	 */
	public boolean isStartRpcServer();

	/**
	 * @param port
	 * @throws IOException 
	 * @throws Exception
	 */
	public IoAcceptor startRpcServer() throws IOException;
	
	// ====================================================================================================
	// Register
	// ====================================================================================================

	/**
	 * @param host the host to set
	 */
	public void setRpcCenterHost(String host);

	/**
	 * @param host the host to get
	 */
	public String getRpcCenterHost();

	/**
	 * @param port the port to set
	 */
	public void setRpcCenterPort(int port);

	/**
	 * @param port the port to get
	 */
	public int getRpcCenterPort();
	
	/**
	 * @param port
	 * @throws IOException 
	 * @throws Exception
	 */
	public boolean isStartRpcCenter();

	/**
	 * @param port
	 * @throws IOException 
	 * @throws Exception
	 */
	public IoAcceptor startRpcCenter() throws IOException;

	// ====================================================================================================
	// exporter/importer/unregister
	// ====================================================================================================

	/**
	 * @param serviceObject
	 * @param properties
	 * @throws Exception
	 */
	public <S> IRpcServiceReference exporterService(final S service, Dictionary<String, ?> properties) throws ServiceNotFoundException;

	/**
	 * @param serviceName
	 * @param properties
	 */
	public void unregisterService(String serviceName, Dictionary<String, ?> properties) throws ServiceNotFoundException;
	
	/**
	 * @param interfaceType
	 * @param properties
	 * @return
	 * @throws ServiceNotFoundException 
	 * @throws Exception
	 */
	public <S> S importerService(final Class<S> interfaceType, Dictionary<String, ?> properties) throws ServiceNotFoundException;

	/**
	 * @param <S>
	 * @param interfaceType
	 * @param properties
	 * @return
	 * @throws ServiceNotFoundException 
	 * @throws Exception
	 */
	public <S> IRpcServiceReference getServiceReference(final Class<S> interfaceType, Dictionary<String, ?> properties) throws ServiceNotFoundException;
}
