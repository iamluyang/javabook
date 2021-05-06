package online.javabook.distributed.rpc.center.impl.handler;

import online.javabook.distributed.rpc.center.api.register.IRpcRegisterCenter;
import online.javabook.distributed.rpc.center.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.center.api.request.register.IRpcRegisterCenterRequest;
import online.javabook.distributed.rpc.center.api.request.register.IRpcRegisterCenterRequestType;
import online.javabook.distributed.rpc.center.impl.registration.RpcServiceRegistrationImpl;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcRegisterCenterHandler extends IoHandlerAdapter {

	/**
	 * rpcRegisterCenterContent
	 */
	private IRpcRegisterCenter rpcRegisterCenter;
	
	/**
	 * @return the rpcRegisterCenterContent
	 */
	public IRpcRegisterCenter getRpcRegisterCenter() {
		return rpcRegisterCenter;
	}

	/**
	 * @param rpcRegisterCenter the rpcRegisterCenter to set
	 */
	public void setRpcRegisterCenter(IRpcRegisterCenter rpcRegisterCenter) {
		this.rpcRegisterCenter = rpcRegisterCenter;
	}

    @Override  
    public void exceptionCaught(IoSession session, Throwable cause) {

    }  
  
    @Override 
    public void messageReceived(IoSession session, Object message) {  

		// request
    	IRpcRegisterCenterRequest request = (IRpcRegisterCenterRequest)message;

    	// requestType
    	IRpcRegisterCenterRequestType requestType = request.getRpcRegisterCenterRequestType();
    	
    	// ADD
    	if(requestType == IRpcRegisterCenterRequestType.ADD) {
    		
    		IRpcServiceRegistration registration = rpcRegisterCenter.addServiceRegistration(request.getServiceName(), null, request);
    		response(session, registration);
    	}
    	
    	// DEL
    	else if(requestType == IRpcRegisterCenterRequestType.DEL) {
    		
    		IRpcServiceRegistration registration = rpcRegisterCenter.delServiceRegistration(request.getServiceName(), null);
    		response(session, registration);
    	}
    	
    	// GET
    	else if(requestType == IRpcRegisterCenterRequestType.GET) {
    		
    		IRpcServiceRegistration registration = rpcRegisterCenter.getServiceRegistration(request.getServiceName(), null);    
    		response(session, registration);
    	}

    }  

    /**
     * @param session
     * @param registration
     */
    private void response(IoSession session, IRpcServiceRegistration registration) {
    	
    	if(registration==null) {
			session.write( RpcServiceRegistrationImpl.NOTFOUND );
		}else{
    		session.write( registration );
		}
    }
}  
