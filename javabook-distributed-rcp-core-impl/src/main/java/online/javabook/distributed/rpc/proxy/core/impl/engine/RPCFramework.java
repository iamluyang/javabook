package online.javabook.distributed.rpc.proxy.core.impl.engine;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Dictionary;

import javax.management.ServiceNotFoundException;

import online.javabook.distributed.rpc.center.api.reference.IRpcServiceReference;
import online.javabook.distributed.rpc.center.api.register.IRpcRegisterCenter;
import online.javabook.distributed.rpc.center.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.center.api.request.register.IRpcRegisterCenterRequest;
import online.javabook.distributed.rpc.center.impl.handler.RpcProviderCenterHandler;
import online.javabook.distributed.rpc.center.impl.handler.RpcRegisterCenterHandler;
import online.javabook.distributed.rpc.center.impl.reference.LocalRpcServiceReferenceImpl;
import online.javabook.distributed.rpc.center.impl.register.LocalRpcRegisterCenterImpl;
import online.javabook.distributed.rpc.center.impl.register.RemoteRegisterCenterImpl;
import online.javabook.distributed.rpc.center.impl.request.register.RpcRegisterCenterRequestImpl;
import online.javabook.distributed.rpc.proxy.core.api.framework.IRPCFramework;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioDatagramAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * RpcFramework
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RPCFramework implements IRPCFramework {

	// ====================================================================================================
	// RpcFrameworkImpl
	// ====================================================================================================

	/**
	 * rpcFramework
	 */
	private static IRPCFramework rpcFramework = new RPCFramework();

	/**
	 * 
	 */
	private RPCFramework() {
		super();
	}
	
	/**
	 * @return
	 */
	public static IRPCFramework getInstance() {
		return rpcFramework;
	}

	// ====================================================================================================
	// Server
	// ====================================================================================================

	/**
	 * rpcServer
	 */
	private IoAcceptor rpcServer;

	/**
	 * rpcServerHost
	 */
	private String rpcServerHost = "localhost";
	
	/**
	 * rpcServerPort
	 */
	private int rpcServerPort = 1234;

	@Override
	public String getRpcServerHost() {
		return rpcServerHost;
	}

	@Override
	public void setRpcServerHost(String host) {
		this.rpcServerHost = host;
	}

	@Override
	public int getRpcServerPort() {
		return rpcServerPort;
	}

	@Override
	public void setRpcServerPort(int port) {
		this.rpcServerPort = port;
	}

	@Override
	public boolean isStartRpcServer() {
		return rpcServer!=null && rpcServer.isActive();
	};
	
	@Override
	public IoAcceptor startRpcServer() throws IOException {

		// service
		rpcServer = new NioSocketAcceptor();

		// filter
		rpcServer.getFilterChain().addLast("loger", new LoggingFilter());
		
		// filter
		rpcServer.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

		// register
		IRpcRegisterCenter localRegisterImpl = new LocalRpcRegisterCenterImpl();
		
		// handler
		RpcProviderCenterHandler serverHandler = new RpcProviderCenterHandler();
		serverHandler.setRpcRegisterCenterContent(localRegisterImpl);
		rpcServer.setHandler(serverHandler);

		// bind
		rpcServer.bind(new InetSocketAddress(rpcServerHost, rpcServerPort));

		return rpcServer;
	}

	// ====================================================================================================
	// Register
	// ====================================================================================================

	/**
	 * registerServer
	 */
	private IoAcceptor registerServer;

	/**
	 * registerHost
	 */
	private String registerHost = "localhost";
	
	/**
	 * registerPort
	 */
	private int registerPort = 1234;

	@Override
	public String getRpcCenterHost() {
		return registerHost;
	}

	@Override
	public void setRpcCenterHost(String host) {
		this.registerHost = host;
	}

	@Override
	public int getRpcCenterPort() {
		return registerPort;
	}

	@Override
	public void setRpcCenterPort(int port) {
		this.registerPort = port;
	}

	@Override
	public boolean isStartRpcCenter() {
		return registerServer!=null && registerServer.isActive();
	};
	
	@Override
	public IoAcceptor startRpcCenter() throws IOException {

		// exporter
		registerServer = new NioDatagramAcceptor();
		
		// filter
		registerServer.getFilterChain().addLast("loger", new LoggingFilter());
		
		// filter
		registerServer.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));		

		// register
		IRpcRegisterCenter localRegisterImpl = new LocalRpcRegisterCenterImpl();
		
		// handler
		RpcRegisterCenterHandler registerHandler = new RpcRegisterCenterHandler();
		registerHandler.setRpcRegisterCenter(localRegisterImpl);
		registerServer.setHandler(registerHandler);
		
		// bind
		registerServer.bind(new InetSocketAddress(registerHost, registerPort));

		return registerServer;
	}

	// ====================================================================================================
	// register
	// ====================================================================================================
	
	@Override
	public <S> IRpcServiceReference exporterService(S service, Dictionary<String, ?> properties) throws ServiceNotFoundException {

		// interfaceTypes 
		Class<?>[] interfaceTypes = service.getClass().getInterfaces();
		
		// interfaceType
		for (Class<?> interfaceType : interfaceTypes) {
			
			IRpcRegisterCenterRequest request = new RpcRegisterCenterRequestImpl();
			
			// server
			request.setServiceName(interfaceType.getName());
			request.setRpcProviderCenterHost(getRpcServerHost());
			request.setRpcProviderCenterPort(getRpcServerPort());
			
			// center
			request.setRpcRegisterCenterHost(getRpcCenterHost());
			request.setRpcRegisterCenterPort(getRpcCenterPort());

			// local
			localRpcCenterService(request, service);	
			// remote
			remoteRpcCenterService(request, service);	
		}		
		
		// reference
		IRpcServiceReference reference = new LocalRpcServiceReferenceImpl(service);
		return reference;
	}

	/**
	 * @param request
	 * @param serviceObject
	 */
	private void localRpcCenterService(IRpcRegisterCenterRequest request, final Object serviceObject) {
		IRpcRegisterCenter localRegister = ((RpcProviderCenterHandler)rpcServer.getHandler()).getRpcRegisterCenter();
		localRegister.addServiceRegistration(request.getServiceName(), serviceObject, request);
	}

	/**
	 * @param request
	 * @param serviceObject
	 */
	private void remoteRpcCenterService(IRpcRegisterCenterRequest request, final Object serviceObject) {		
		IRpcRegisterCenter remoteRegister = new RemoteRegisterCenterImpl();
		remoteRegister.addServiceRegistration(request.getServiceName(), serviceObject, request);	
	}

	// ====================================================================================================
	// unregister
	// ====================================================================================================
	
	@Override
	public void unregisterService(String serviceName, Dictionary<String, ?> properties) throws ServiceNotFoundException {
		
		IRpcRegisterCenterRequest request = new RpcRegisterCenterRequestImpl();
		request.setServiceName(serviceName);
		request.setRpcProviderCenterHost(getRpcServerHost());
		request.setRpcProviderCenterPort(getRpcServerPort());
		request.setRpcRegisterCenterHost(getRpcCenterHost());
		request.setRpcRegisterCenterPort(getRpcCenterPort());
		
		// local
		localUnregisterService(request);	
		// remote
		remoteUnregisterService(request);	
	}
		
	/**
	 * @param request
	 */
	private void localUnregisterService(IRpcRegisterCenterRequest request) {
		IRpcRegisterCenter localRegister = ((RpcProviderCenterHandler)rpcServer.getHandler()).getRpcRegisterCenter();
		localRegister.delServiceRegistration(request.getServiceName(), request);
	}

	/**
	 * @param request
	 */
	private void remoteUnregisterService(IRpcRegisterCenterRequest request) {		
		IRpcRegisterCenter remoteRegister = new RemoteRegisterCenterImpl();
		remoteRegister.delServiceRegistration(request.getServiceName(), request);	
	}
	
	// ====================================================================================================
	// lookup
	// ====================================================================================================
	
	@Override
	public <S> S importerService(Class<S> interfaceType, Dictionary<String, ?> properties) throws ServiceNotFoundException {

		IRpcServiceReference serviceReference = getServiceReference(interfaceType, properties);
		return (S) serviceReference.getService();
	}

	// ====================================================================================================
	// IServiceReference
	// ====================================================================================================

	@Override
	public <S> IRpcServiceReference getServiceReference(final Class<S> interfaceType, Dictionary<String, ?> properties) throws ServiceNotFoundException {

		IRpcServiceRegistration registration = lookupRemoteService(interfaceType);
		IRpcRegisterCenter remoteRegister = new RemoteRegisterCenterImpl();
		return remoteRegister.getServiceReference(registration);
	}

	/**
	 * @param interfaceType
	 * @return
	 * @throws ServiceNotFoundException 
	 */
	private IRpcServiceRegistration lookupRemoteService(Class<?> interfaceType) {

		// request
		IRpcRegisterCenterRequest request = new RpcRegisterCenterRequestImpl();
		request.setRpcRegisterCenterHost(getRpcCenterHost());
		request.setRpcRegisterCenterPort(getRpcCenterPort());
		request.setServiceName(interfaceType.getName());

		IRpcRegisterCenter remoteRegister = new RemoteRegisterCenterImpl();
		IRpcServiceRegistration registration = remoteRegister.getServiceRegistration(request.getServiceName(), request);

		return registration;
	}

}
