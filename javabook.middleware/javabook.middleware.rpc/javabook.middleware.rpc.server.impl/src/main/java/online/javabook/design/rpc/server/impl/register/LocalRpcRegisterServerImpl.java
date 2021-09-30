package online.javabook.design.rpc.server.impl.register;

import online.javabook.design.rpc.server.api.reference.IRpcServiceReference;
import online.javabook.design.rpc.server.impl.reference.LocalRpcServiceReferenceImpl;
import online.javabook.design.rpc.server.impl.registration.RpcServiceRegistrationImpl;
import online.javabook.design.rpc.server.api.listener.IRpcServiceListener;
import online.javabook.design.rpc.server.api.register.IRpcRegisterServer;
import online.javabook.design.rpc.server.api.registration.IRpcServiceRegistration;
import online.javabook.design.rpc.server.api.request.register.IRpcRegisterRequest;
import online.javabook.design.rpc.server.impl.utils.ClassUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class LocalRpcRegisterServerImpl implements IRpcRegisterServer {

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
	public IRpcServiceRegistration addServiceRegistration(String serviceName, Object service, IRpcRegisterRequest request) {

		// registration
		IRpcServiceRegistration registration = new RpcServiceRegistrationImpl(service);
		registration.setRpcProviderHost(request.getRpcProviderServerHost());
		registration.setRpcProviderPort(request.getRpcProviderServerPort());
		registration.setServiceName(serviceName);		
		registration.setInterfaceNames(ClassUtils.getInterfaceNames(service));
		
		serviceRegistrations.put(serviceName, registration);

		return registration;
	}

	@Override
	public IRpcServiceRegistration delServiceRegistration(String serviceName, IRpcRegisterRequest request) {
		return serviceRegistrations.remove(serviceName);
	}

	@Override
	public IRpcServiceRegistration getServiceRegistration(String serviceName, IRpcRegisterRequest request) {
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
