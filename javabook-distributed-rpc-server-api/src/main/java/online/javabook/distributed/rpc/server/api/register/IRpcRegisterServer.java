package online.javabook.distributed.rpc.server.api.register;

import online.javabook.distributed.rpc.server.api.listener.IRpcServiceListener;
import online.javabook.distributed.rpc.server.api.reference.IRpcServiceReference;
import online.javabook.distributed.rpc.server.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.server.api.request.register.IRpcRegisterRequest;

/**
 * A bundle's execution context within the Framework. The context is used to
 * grant access to other methods so that this bundle can interact with the
 * Framework.
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-20
 *
 */
public interface IRpcRegisterServer {

	// ====================================================================================================
	// ServiceListener
	// ====================================================================================================

	/**
	 * @param listener
	 */
	void addRpcServiceListener(IRpcServiceListener listener);

	/**
	 * @param listener
	 */
	void removeRpcServiceListener(IRpcServiceListener listener);

	// ====================================================================================================
	// IServiceRegistration
	// ====================================================================================================
	
	/**
	 * @param serviceName
	 * @param service
	 * @param request
	 * @return
	 */
	public IRpcServiceRegistration addServiceRegistration(String serviceName, Object service, IRpcRegisterRequest request);

	/**
	 * @param serviceName
	 * @param request
	 */
	public IRpcServiceRegistration delServiceRegistration(String serviceName, IRpcRegisterRequest request);

	/**
	 * @param serviceName
	 * @param request
	 */
	public IRpcServiceRegistration getServiceRegistration(String serviceName, IRpcRegisterRequest request);

	// ====================================================================================================
	// IServiceReference
	// ====================================================================================================
	
	/**
	 * @param registration
	 * @return
	 */
	public IRpcServiceReference getServiceReference(IRpcServiceRegistration registration);

}
