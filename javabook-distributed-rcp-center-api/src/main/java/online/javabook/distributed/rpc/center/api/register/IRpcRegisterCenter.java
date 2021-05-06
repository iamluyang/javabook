package online.javabook.distributed.rpc.center.api.register;

import online.javabook.distributed.rpc.center.api.listener.IRpcServiceListener;
import online.javabook.distributed.rpc.center.api.reference.IRpcServiceReference;
import online.javabook.distributed.rpc.center.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.center.api.request.register.IRpcRegisterCenterRequest;

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
public interface IRpcRegisterCenter {

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
	public IRpcServiceRegistration addServiceRegistration(String serviceName, Object service, IRpcRegisterCenterRequest request);

	/**
	 * @param serviceName
	 * @param request
	 */
	public IRpcServiceRegistration delServiceRegistration(String serviceName, IRpcRegisterCenterRequest request);

	/**
	 * @param serviceName
	 * @param request
	 */
	public IRpcServiceRegistration getServiceRegistration(String serviceName, IRpcRegisterCenterRequest request);

	// ====================================================================================================
	// IServiceReference
	// ====================================================================================================
	
	/**
	 * @param registration
	 * @return
	 */
	public IRpcServiceReference getServiceReference(IRpcServiceRegistration registration);

}
