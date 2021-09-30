package online.javabook.design.rpc.server.impl.register;

import online.javabook.design.rpc.server.api.reference.IRpcServiceReference;
import online.javabook.design.rpc.server.api.request.register.IRpcRegisterRequestType;
import online.javabook.design.rpc.server.impl.reference.RemoteRpcServiceReferenceImpl;
import online.javabook.design.rpc.proxy.api.handler.IProxySource;
import online.javabook.design.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.design.rpc.proxy.impl.factory.ProxySourceFactoryImpl;
import online.javabook.design.rpc.proxy.impl.handler.jdk.JdkProxySource;
import online.javabook.design.rpc.server.api.exception.ServiceNotFoundException;
import online.javabook.design.rpc.server.api.listener.IRpcServiceListener;
import online.javabook.design.rpc.server.api.register.IRpcRegisterServer;
import online.javabook.design.rpc.server.api.registration.IRpcServiceRegistration;
import online.javabook.design.rpc.server.api.request.register.IRpcRegisterRequest;
import online.javabook.design.rpc.server.impl.handler.RpcProviderClientHandler;
import online.javabook.design.rpc.server.impl.handler.RpcRegisterClientHandler;
import online.javabook.design.rpc.server.impl.proxy.ServiceClientProxyInvokerImpl;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioDatagramConnector;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RemoteRpcRegisterServerImpl implements IRpcRegisterServer {

	// ====================================================================================================
	// ServiceListener
	// ====================================================================================================

	@Override
	public void addRpcServiceListener(IRpcServiceListener listener) {

	}

	@Override
	public void removeRpcServiceListener(IRpcServiceListener listener) {

	}
	
	// ====================================================================================================
	// ServiceListener
	// ====================================================================================================

	@Override
	public IRpcServiceRegistration addServiceRegistration(String serviceName, Object service, IRpcRegisterRequest request) {

		// create
		IoSession session = createRegisterClientSession(request);
	
		// register
		request.setRpcRegisterRequestType(IRpcRegisterRequestType.ADD);
		session.write(request);
		
		// read
		IRpcServiceRegistration registration = null;
		try {
			registration = readServiceRegistration(session);
			closeRegisterClientSession(session);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return registration;
	}

	@Override
	public IRpcServiceRegistration delServiceRegistration(String serviceName, IRpcRegisterRequest request) {

		// create
		IoSession session = createRegisterClientSession(request);
	
		// register
		request.setRpcRegisterRequestType(IRpcRegisterRequestType.DEL);
		session.write(request);
		
		// read
		IRpcServiceRegistration registration = null;
		try {
			registration = readServiceRegistration(session);
			closeRegisterClientSession(session);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return registration;
	}

	@Override
	public IRpcServiceRegistration getServiceRegistration(String serviceName, IRpcRegisterRequest request) {

		// create
		IoSession session = createRegisterClientSession(request);
	
		// request
		request.setRpcRegisterRequestType(IRpcRegisterRequestType.GET);
		session.write(request);
		
		// read
		IRpcServiceRegistration registration = null;
		try {
			registration = readServiceRegistration(session);
			closeRegisterClientSession(session);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return registration;
	}

	// ----------------------------------------------------------------------------------------------------
	// createRegisterClientSession
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @param request
	 * @return
	 */
	private IoSession createRegisterClientSession(IRpcRegisterRequest request) {
		
		// connector
		IoConnector connector = new NioDatagramConnector();
		connector.getSessionConfig().setUseReadOperation(true);
		
		// filter
		connector.getFilterChain().addLast("loger", new LoggingFilter());

		// filter
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

		// handler
		RpcRegisterClientHandler registerClientHandler = new RpcRegisterClientHandler();
		connector.setHandler(registerClientHandler);

		// connect
		ConnectFuture future = connector.connect(new InetSocketAddress(request.getRpcRegisterServerHost(), request.getRpcRegisterServerPort()));

		// session
		future.awaitUninterruptibly();

		IoSession session = future.getSession();
		return session;
	}

	// ----------------------------------------------------------------------------------------------------
	// readServiceRegistration
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @param session
	 * @throws ServiceNotFoundException 
	 */
	private IRpcServiceRegistration readServiceRegistration(IoSession session) throws ServiceNotFoundException {
		
		// read
		IRpcServiceRegistration registration = null;
		try {
			ReadFuture readFuture = session.read();
			readFuture.await();
			registration = (IRpcServiceRegistration) readFuture.getMessage();			
		} catch (InterruptedException e) {
			e.printStackTrace();	
		} catch (Exception e) {
			throw new ServiceNotFoundException("ServiceNotFoundException", e);
		}
		return registration;
	}

	// ====================================================================================================
	// getServiceReference
	// ====================================================================================================

	@Override
	public IRpcServiceReference getServiceReference(IRpcServiceRegistration registration) {

		// session
		IoSession session = getServiceClientSession(registration);
		
		// interfaceType - newProxyInstance
		Object service = null;
		
		// serviceClientInvocation
		IProxyInvoker proxyInvoker;
		try {
			// clazz
			Class clazz  = Class.forName(registration.getServiceName());
			
			// proxyInvoker
			proxyInvoker = new ServiceClientProxyInvokerImpl(session, clazz);
			
			// proxySource
			IProxySource proxySource  = new JdkProxySource(this.getClass().getClassLoader(), new Class[]{clazz});
			
			// proxyInvoker
			service = ProxySourceFactoryImpl.getInstance().createProxySource(proxySource, proxyInvoker, null);

			// reference
			return new RemoteRpcServiceReferenceImpl(session, service);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}	

	}

	// ----------------------------------------------------------------------------------------------------
	// getServiceClientSession
	// ----------------------------------------------------------------------------------------------------

	/**
	 *
	 * @param registration
	 * @return
	 */
	private IoSession getServiceClientSession(IRpcServiceRegistration registration) {
		
		if(registration == null) return null;
		
		// connector
		IoConnector connector = new NioSocketConnector();
		connector.getSessionConfig().setUseReadOperation(true);
		
		// filter
		connector.getFilterChain().addLast("loger", new LoggingFilter());

		// filter
		connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));

		// handler
		RpcProviderClientHandler serviceClientHandler = new RpcProviderClientHandler();
		connector.setHandler(serviceClientHandler);			

		// bind
		ConnectFuture future = connector.connect(new InetSocketAddress(registration.getRpcProviderHost(), registration.getRpcProviderPort()));
		future.awaitUninterruptibly();
		IoSession session = future.getSession();
		
		return session;
	}
	
	// ----------------------------------------------------------------------------------------------------
	// closeRegisterClientSession
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @param session
	 */
	private void closeRegisterClientSession(IoSession session) {
		session.close(true);
		IoConnector connector = (IoConnector) session.getService();
		connector.dispose();
	}	
	
}
