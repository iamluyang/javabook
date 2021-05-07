package online.javabook.distributed.rpc.server.impl.handler;

import online.javabook.distributed.rpc.server.api.register.IRpcRegisterServer;
import online.javabook.distributed.rpc.server.api.registration.IRpcServiceRegistration;
import online.javabook.distributed.rpc.server.api.request.register.IRpcRegisterRequest;
import online.javabook.distributed.rpc.server.api.request.register.IRpcRegisterRequestType;
import online.javabook.distributed.rpc.server.impl.registration.RpcServiceRegistrationImpl;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcRegisterServerHandler extends IoHandlerAdapter {

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
    public void exceptionCaught(IoSession session, Throwable cause) {

    }  
  
    @Override 
    public void messageReceived(IoSession session, Object message) {  

		// request
    	IRpcRegisterRequest request = (IRpcRegisterRequest)message;

    	// requestType
    	IRpcRegisterRequestType requestType = request.getRpcRegisterRequestType();
    	
    	// ADD
    	if(requestType == IRpcRegisterRequestType.ADD) {
    		
    		IRpcServiceRegistration registration = rpcRegisterServer.addServiceRegistration(request.getServiceName(), null, request);
    		response(session, registration);
    	}
    	
    	// DEL
    	else if(requestType == IRpcRegisterRequestType.DEL) {
    		
    		IRpcServiceRegistration registration = rpcRegisterServer.delServiceRegistration(request.getServiceName(), null);
    		response(session, registration);
    	}
    	
    	// GET
    	else if(requestType == IRpcRegisterRequestType.GET) {
    		
    		IRpcServiceRegistration registration = rpcRegisterServer.getServiceRegistration(request.getServiceName(), null);
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
