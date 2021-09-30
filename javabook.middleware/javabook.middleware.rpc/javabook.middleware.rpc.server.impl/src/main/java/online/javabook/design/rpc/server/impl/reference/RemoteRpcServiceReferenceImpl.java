package online.javabook.design.rpc.server.impl.reference;

import online.javabook.design.rpc.server.api.reference.IRpcServiceReference;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IoSession;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RemoteRpcServiceReferenceImpl<S> implements IRpcServiceReference {

	/**
	 * session
	 */
	private IoSession session;
	
	/**
	 * service
	 */
	private S service;
	
	/**
	 * @param service
	 */
	public RemoteRpcServiceReferenceImpl(IoSession session, S service) {
		this.service = service;
		this.session = session;
	}
	
	@Override
	public S getService() {
		return service;
	}

	@Override
	public void close() {
		session.closeOnFlush();
		IoConnector connector = (IoConnector) session.getService();
		connector.dispose();
	}

}
