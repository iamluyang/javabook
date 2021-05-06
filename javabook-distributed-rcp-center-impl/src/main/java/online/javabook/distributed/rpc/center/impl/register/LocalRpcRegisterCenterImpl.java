package online.javabook.distributed.rpc.center.impl.register;

import java.util.concurrent.ConcurrentHashMap;

import online.javabook.distributed.rpc.center.api.listener.IRpcServiceListener;
import online.javabook.distributed.rpc.center.api.reference.IRpcServiceReference;
import online.javabook.distributed.rpc.center.api.register.IRpcRegisterCenter;
import online.javabook.distributed.rpc.center.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.center.api.request.register.IRpcRegisterCenterRequest;
import online.javabook.distributed.rpc.center.impl.reference.LocalRpcServiceReferenceImpl;
import online.javabook.distributed.rpc.center.impl.registration.RpcServiceRegistrationImpl;
import online.javabook.distributed.rpc.center.impl.utils.ClassUtils;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class LocalRpcRegisterCenterImpl implements IRpcRegisterCenter {

	/**
	 * rpcCenterContent
	 */
	private ConcurrentHashMap<String, IRpcServiceRegistration> serviceRegistrations =
	new ConcurrentHashMap<String, IRpcServiceRegistration>();

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
	// IServiceRegistration
	// ====================================================================================================

	@Override
	public IRpcServiceRegistration addServiceRegistration(String serviceName, Object service, IRpcRegisterCenterRequest request) {

		// registration
		IRpcServiceRegistration registration = new RpcServiceRegistrationImpl(service);
		registration.setRpcProviderCenterHost(request.getRpcProviderCenterHost());
		registration.setRpcProviderCenterPort(request.getRpcProviderCenterPort());
		registration.setServiceName(serviceName);		
		registration.setInterfaceNames(ClassUtils.getInterfaceNames(service));
		
		serviceRegistrations.put(serviceName, registration);

		return registration;
	}

	@Override
	public IRpcServiceRegistration delServiceRegistration(String serviceName, IRpcRegisterCenterRequest request) {
		return serviceRegistrations.remove(serviceName);
	}

	@Override
	public IRpcServiceRegistration getServiceRegistration(String serviceName, IRpcRegisterCenterRequest request) {
		return serviceRegistrations.get(serviceName);
	}
	
	// ====================================================================================================
	// Service
	// ====================================================================================================

	@Override
	public IRpcServiceReference getServiceReference(IRpcServiceRegistration registration) {
		
		Object service = registration.getServiceObject();
		IRpcServiceReference reference = new LocalRpcServiceReferenceImpl(service);
		return reference;
	}
	
}
