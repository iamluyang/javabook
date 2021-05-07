package online.javabook.distributed.rpc.server.impl.handler;

import online.javabook.distributed.rpc.server.api.register.IRpcRegisterServer;
import online.javabook.distributed.rpc.server.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.server.api.request.provider.IRpcProviderRequest;
import online.javabook.distributed.rpc.server.api.request.provider.IRpcProviderResponse;
import online.javabook.distributed.rpc.server.impl.request.provider.RpcProviderServerResponseImpl;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import javax.management.ServiceNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcProviderServerHandler extends IoHandlerAdapter {

	/**
	 * rpcRegisterServer
	 */
	private IRpcRegisterServer rpcRegisterServer;

	/**
	 *
	 * @return
	 */
	public IRpcRegisterServer getRpcRegisterServer() {
		return rpcRegisterServer;
	}

	/**
	 *
	 * @param rpcRegisterServer
	 */
	public void setRpcRegisterServer(IRpcRegisterServer rpcRegisterServer) {
		this.rpcRegisterServer = rpcRegisterServer;
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
	}

	@Override
	public void messageReceived(IoSession session, Object message) {

		// request
		IRpcProviderRequest request = (IRpcProviderRequest)message;

		// serviceName
		String serviceName = request.getServiceName();

		// methodName
		String methodName = request.getMethodName();

		// parameterTypes
		Class<?>[] parameterTypes = request.getParameterTypes();

		// arguments
		Object[] arguments = request.getArguments();

		// response
		IRpcProviderResponse response = new RpcProviderServerResponseImpl();

		try {
			// serviceRegistration
			IRpcServiceRegistration registration = getRpcRegisterServer().getServiceRegistration(serviceName, null);

			// hasServiceRegistration
			checkServiceRegistration(request, registration);

			// method
			Method method = createMethod(registration.getServiceObject().getClass(), methodName, parameterTypes);

			// invoke
			Object result = method.invoke(registration.getServiceObject(), arguments);

			// result
			response.setResult(result);

		} catch (ServiceNotFoundException e) {
			response.setThrowable(e);

		} catch (SecurityException e) {
			response.setThrowable(e);

		} catch (IllegalAccessException e) {
			response.setThrowable(e);

		} catch (IllegalArgumentException e) {
			response.setThrowable(e);

		} catch (InvocationTargetException e) {
			response.setThrowable(e);

		} catch (NoSuchMethodException e) {
			response.setThrowable(e);

		}catch (Exception e) {
			response.setThrowable(e);

		} finally {
			// write
			session.write(response);
		}

	}

	// ----------------------------------------------------------------------------------------------------
	// hasServiceRegistration
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @param request
	 * @param serviceRegistration
	 * @return
	 * @throws ServiceNotFoundException
	 */
	private void checkServiceRegistration(IRpcProviderRequest request, IRpcServiceRegistration serviceRegistration)
			throws ServiceNotFoundException {

		if(serviceRegistration==null)
			throw new ServiceNotFoundException(request.getServiceName());
	}

	// ----------------------------------------------------------------------------------------------------
	// createMethod
	// ----------------------------------------------------------------------------------------------------

	/**
	 * @param serviceClass
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	private Method createMethod(Class<?> serviceClass, String methodName, Class<?>[] parameterTypes)
			throws NoSuchMethodException, SecurityException {

		Method method = serviceClass.getMethod(methodName, parameterTypes);
		return method;
	}

}