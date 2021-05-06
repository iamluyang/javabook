package online.javabook.distributed.rpc.center.impl.proxy;

import java.lang.reflect.Method;

import online.javabook.distributed.rpc.center.api.request.provider.IRpcProviderCenterRequest;
import online.javabook.distributed.rpc.center.api.request.provider.IRpcProviderCenterResponse;
import online.javabook.distributed.rpc.center.impl.request.provider.RpcProviderCenterRequestImpl;
import online.javabook.distributed.rpc.proxy.proxy.api.invoker.IProxyInvoker;
import org.apache.mina.core.future.ReadFuture;
import org.apache.mina.core.session.IoSession;

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
		IRpcProviderCenterRequest request = new RpcProviderCenterRequestImpl();

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
		IRpcProviderCenterResponse serviceResponse = (IRpcProviderCenterResponse) readFuture.getMessage();

		// throw or return
		if(serviceResponse.getThrowable()!=null) 
			throw serviceResponse.getThrowable();
		else {
			return serviceResponse.getResult();
		}
	}
}
