package online.javabook.design.rpc.server.impl.proxy;

import online.javabook.design.rpc.server.impl.request.provider.RpcProviderServerRequestImpl;
import online.javabook.design.rpc.proxy.api.invoker.IProxyInvoker;
import online.javabook.design.rpc.server.api.request.provider.IRpcProviderRequest;
import online.javabook.design.rpc.server.api.request.provider.IRpcProviderResponse;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.session.IoSession;

import java.lang.reflect.Method;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class ServiceClientProxyInvokerImpl<T> implements IProxyInvoker<T> {

	/**
	 * session
	 */
	private IoSession session;

	/**
	 * serviceClass
	 */
	private Class<?> serviceClass;

	/**
	 * @param session
	 * @param serviceClass
	 */
	public ServiceClientProxyInvokerImpl(IoSession session, Class<?> serviceClass) {
		super();
		this.session      = session;
		this.serviceClass = serviceClass;
	}

	/**
	 * @return the session
	 */
	public IoSession getSession() {
		return session;
	}

	/**
	 * @return the serviceName
	 */
	public Class<?> getServiceClass() {
		return serviceClass;
	}

	@Override
	public Object doInvoke(Method method, Object[] arguments) throws Throwable {
		
		// rpcRequest
		IRpcProviderRequest request = new RpcProviderServerRequestImpl();

		// interfaceType
		request.setServiceName(serviceClass.getName());
		
		// method Name
		request.setMethodName(method.getName());

		// method ParameterTypes
		request.setParameterTypes(method.getParameterTypes());

		// method arguments
		request.setArguments(arguments);
		
		// write rpcRequest
		session.write(request);
		
		// readFuture
		ReadFuture readFuture = session.read();
		readFuture.await();
		
		// serviceResponse
		IRpcProviderResponse serviceResponse = (IRpcProviderResponse) readFuture.getMessage();

		// throw or return
		if(serviceResponse.getThrowable()!=null) 
			throw serviceResponse.getThrowable();
		else {
			return serviceResponse.getResult();
		}
	}
}
