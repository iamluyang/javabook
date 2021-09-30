package online.javabook.design.rpc.core.api.framework;

import online.javabook.design.rpc.server.api.reference.IRpcServiceReference;
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
	 *
	 * @param host
	 */
	public void setProviderServerHost(String host);

	/**
	 *
	 * @return
	 */
	public String getProviderServerHost();

	/**
	 * @param port the port to set
	 */
	public void setProviderServerPort(int port);

	/**
	 *
	 * @return
	 */
	public int getProviderServerPort();

	/**
	 *
	 * @return
	 */
	public boolean isStartProviderServer();

	/**
	 *
	 * @return
	 * @throws IOException
	 */
	public IoAcceptor startProviderServer() throws IOException;
	
	// ====================================================================================================
	// Register
	// ====================================================================================================

	/**
	 * @param host the host to set
	 */
	public void setRegisterServerHost(String host);

	/**
	 *
	 * @return
	 */
	public String getRegisterServerHost();

	/**
	 *
	 * @param port
	 */
	public void setRegisterServerPort(int port);

	/**
	 *
	 * @return
	 */
	public int getRegisterServerPort();

	/**
	 *
	 * @return
	 */
	public boolean isStartRegisterServer();

	/**
	 *
	 * @return
	 * @throws IOException
	 */
	public IoAcceptor startRpcRegisterServer() throws IOException;

	// ====================================================================================================
	// exporter/importer/unregister
	// ====================================================================================================

	/**
	 *
	 * @param service
	 * @param properties
	 * @param <S>
	 * @return
	 * @throws ServiceNotFoundException
	 */
	public <S> IRpcServiceReference exporterService(final S service, Dictionary<String, ?> properties) throws ServiceNotFoundException;

	/**
	 *
	 * @param serviceName
	 * @param properties
	 * @throws ServiceNotFoundException
	 */
	public void unregisterService(String serviceName, Dictionary<String, ?> properties) throws ServiceNotFoundException;

	/**
	 *
	 * @param interfaceType
	 * @param properties
	 * @param <S>
	 * @return
	 * @throws ServiceNotFoundException
	 */
	public <S> S importerService(final Class<S> interfaceType, Dictionary<String, ?> properties) throws ServiceNotFoundException;

	/**
	 *
	 * @param interfaceType
	 * @param properties
	 * @param <S>
	 * @return
	 * @throws ServiceNotFoundException
	 */
	public <S> IRpcServiceReference getServiceReference(final Class<S> interfaceType, Dictionary<String, ?> properties) throws ServiceNotFoundException;
}
