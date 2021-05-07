package online.javabook.distributed.rpc.core.impl.engine;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Dictionary;

import javax.management.ServiceNotFoundException;

import online.javabook.distributed.rpc.server.api.reference.IRpcServiceReference;
import online.javabook.distributed.rpc.server.api.register.IRpcRegisterServer;
import online.javabook.distributed.rpc.server.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.server.api.request.register.IRpcRegisterRequest;
import online.javabook.distributed.rpc.server.impl.handler.RpcProviderServerHandler;
import online.javabook.distributed.rpc.server.impl.handler.RpcRegisterServerHandler;
import online.javabook.distributed.rpc.server.impl.reference.LocalRpcServiceReferenceImpl;
import online.javabook.distributed.rpc.server.impl.register.LocalRpcRegisterServerImpl;
import online.javabook.distributed.rpc.server.impl.register.RemoteRpcRegisterServerImpl;
import online.javabook.distributed.rpc.server.impl.request.register.RpcRegisterCenterRequestImpl;
import online.javabook.distributed.rpc.core.api.framework.IRPCFramework;
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
	 * rpcProviderServer
	 */
	private IoAcceptor rpcProviderServer;

	/**
	 * rpcServerHost
	 */
	private String rpcProviderServerHost = "localhost";
	
	/**
	 * rpcServerPort
	 */
	private int rpcProviderServerPort = 1234;

	@Override
	public String getProviderServerHost() {
		return rpcProviderServerHost;
	}

	@Override
	public void setProviderServerHost(String host) {
		this.rpcProviderServerHost = host;
	}

	@Override
	public int getProviderServerPort() {
		return rpcProviderServerPort;
	}

	@Override
	public void setProviderServerPort(int port) {
		this.rpcProviderServerPort = port;
	}

	@Override
	public boolean isStartProviderServer() {
		return rpcProviderServer !=null && rpcProviderServer.isActive();
	};
	
	@Override
	public IoAcceptor startProviderServer() throws IOException {

		// provider server
		rpcProviderServer = new NioSocketAcceptor();

		// filter
		rpcProviderServer.getFilterChain().addLast("loger", new LoggingFilter());
		
		// filter
		rpcProviderServer.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

		// register
		IRpcRegisterServer localRegisterImpl = new LocalRpcRegisterServerImpl();
		
		// handler
		RpcProviderServerHandler serverHandler = new RpcProviderServerHandler();
		serverHandler.setRpcRegisterServer(localRegisterImpl);
		rpcProviderServer.setHandler(serverHandler);

		// bind
		rpcProviderServer.bind(new InetSocketAddress(rpcProviderServerHost, rpcProviderServerPort));
		System.out.println("Start RPC Provider Server");

		return rpcProviderServer;
	}

	// ====================================================================================================
	// Register
	// ====================================================================================================

	/**
	 * rcpRegister
	 */
	private IoAcceptor rpcRegisterServer;

	/**
	 * registerHost
	 */
	private String registerServerHost = "localhost";
	
	/**
	 * registerPort
	 */
	private int registerServerPort = 1234;

	@Override
	public String getRegisterServerHost() {
		return registerServerHost;
	}

	@Override
	public void setRegisterServerHost(String host) {
		this.registerServerHost = host;
	}

	@Override
	public int getRegisterServerPort() {
		return registerServerPort;
	}

	@Override
	public void setRegisterServerPort(int port) {
		this.registerServerPort = port;
	}

	@Override
	public boolean isStartRegisterServer() {
		return rpcRegisterServer !=null && rpcRegisterServer.isActive();
	};
	
	@Override
	public IoAcceptor startRpcRegisterServer() throws IOException {

		// exporter
		rpcRegisterServer = new NioDatagramAcceptor();
		
		// filter
		rpcRegisterServer.getFilterChain().addLast("loger", new LoggingFilter());
		
		// filter
		rpcRegisterServer.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

		// register
		IRpcRegisterServer localRegisterImpl = new LocalRpcRegisterServerImpl();
		
		// handler
		RpcRegisterServerHandler registerHandler = new RpcRegisterServerHandler();
		registerHandler.setRpcRegisterServer(localRegisterImpl);
		rpcRegisterServer.setHandler(registerHandler);
		
		// bind
		rpcRegisterServer.bind(new InetSocketAddress(registerServerHost, registerServerPort));
		System.out.println("Start RPC Register Server");
		return rpcRegisterServer;
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
			
			IRpcRegisterRequest request = new RpcRegisterCenterRequestImpl();
			
			// server
			request.setServiceName(interfaceType.getName());
			request.setRpcProviderServerHost(getProviderServerHost());
			request.setRpcProviderServerPort(getProviderServerPort());
			
			// center
			request.setRpcRegisterServerHost(getRegisterServerHost());
			request.setRpcRegisterServerPort(getRegisterServerPort());

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
	private void localRpcCenterService(IRpcRegisterRequest request, final Object serviceObject) {
		IRpcRegisterServer localRegister = ((RpcProviderServerHandler) rpcProviderServer.getHandler()).getRpcRegisterServer();
		localRegister.addServiceRegistration(request.getServiceName(), serviceObject, request);
	}

	/**
	 * @param request
	 * @param serviceObject
	 */
	private void remoteRpcCenterService(IRpcRegisterRequest request, final Object serviceObject) {
		IRpcRegisterServer remoteRegister = new RemoteRpcRegisterServerImpl();
		remoteRegister.addServiceRegistration(request.getServiceName(), serviceObject, request);	
	}

	// ====================================================================================================
	// unregister
	// ====================================================================================================
	
	@Override
	public void unregisterService(String serviceName, Dictionary<String, ?> properties) throws ServiceNotFoundException {
		
		IRpcRegisterRequest request = new RpcRegisterCenterRequestImpl();
		request.setServiceName(serviceName);
		request.setRpcProviderServerHost(getProviderServerHost());
		request.setRpcProviderServerPort(getProviderServerPort());
		request.setRpcRegisterServerHost(getRegisterServerHost());
		request.setRpcRegisterServerPort(getRegisterServerPort());
		
		// local
		localUnregisterService(request);	
		// remote
		remoteUnregisterService(request);	
	}
		
	/**
	 * @param request
	 */
	private void localUnregisterService(IRpcRegisterRequest request) {
		IRpcRegisterServer localRegister = ((RpcProviderServerHandler) rpcProviderServer.getHandler()).getRpcRegisterServer();
		localRegister.delServiceRegistration(request.getServiceName(), request);
	}

	/**
	 * @param request
	 */
	private void remoteUnregisterService(IRpcRegisterRequest request) {
		IRpcRegisterServer remoteRegister = new RemoteRpcRegisterServerImpl();
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
		IRpcRegisterServer remoteRegister = new RemoteRpcRegisterServerImpl();
		return remoteRegister.getServiceReference(registration);
	}

	/**
	 *
	 * @param interfaceType
	 * @return
	 */
	private IRpcServiceRegistration lookupRemoteService(Class<?> interfaceType) {

		// request
		IRpcRegisterRequest request = new RpcRegisterCenterRequestImpl();
		request.setRpcRegisterServerHost(getRegisterServerHost());
		request.setRpcRegisterServerPort(getRegisterServerPort());
		request.setServiceName(interfaceType.getName());

		IRpcRegisterServer remoteRegister = new RemoteRpcRegisterServerImpl();
		IRpcServiceRegistration registration = remoteRegister.getServiceRegistration(request.getServiceName(), request);

		return registration;
	}

}
