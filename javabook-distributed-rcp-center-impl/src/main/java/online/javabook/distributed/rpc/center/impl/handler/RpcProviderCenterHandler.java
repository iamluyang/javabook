package online.javabook.distributed.rpc.center.impl.handler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import online.javabook.distributed.rpc.center.api.exception.ServiceNotFoundException;
import online.javabook.distributed.rpc.center.api.register.IRpcRegisterCenter;
import online.javabook.distributed.rpc.center.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.center.api.request.provider.IRpcProviderCenterRequest;
import online.javabook.distributed.rpc.center.api.request.provider.IRpcProviderCenterResponse;
import online.javabook.distributed.rpc.center.impl.request.provider.RpcProviderCenterResponseImpl;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcProviderCenterHandler extends IoHandlerAdapter {

	/**
	 * rpcRegisterCenter
	 */
	private IRpcRegisterCenter rpcRegisterCenter;
	
	/**
	 * @return the rpcRegisterCenter
	 */
	public IRpcRegisterCenter getRpcRegisterCenter() {
		return rpcRegisterCenter;
	}

	/**
	 * @param rpcRegisterCenter the rpcRegisterCenter to set
	 */
	public void setRpcRegisterCenterContent(IRpcRegisterCenter rpcRegisterCenter) {
		this.rpcRegisterCenter = rpcRegisterCenter;
	}

	@Override
	public void sessionClosed(IoSession session) throws Exception {
		super.sessionClosed(session);
	}
	
	@Override
	public void messageReceived(IoSession session, Object message) {

		// request
		IRpcProviderCenterRequest request = (IRpcProviderCenterRequest)message;

		// serviceName
		String serviceName = request.getServiceName();

		// methodName
		String methodName = request.getMethodName();
		
		// parameterTypes
		Class<?>[] parameterTypes = request.getParameterTypes();
		
		// arguments
		Object[] arguments = request.getArguments();
		
		// response
		IRpcProviderCenterResponse response = new RpcProviderCenterResponseImpl();
		
		try {
			// serviceRegistration
			IRpcServiceRegistration registration = getRpcRegisterCenter().getServiceRegistration(serviceName, null);
				
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
	private void checkServiceRegistration(IRpcProviderCenterRequest request, IRpcServiceRegistration serviceRegistration) 
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