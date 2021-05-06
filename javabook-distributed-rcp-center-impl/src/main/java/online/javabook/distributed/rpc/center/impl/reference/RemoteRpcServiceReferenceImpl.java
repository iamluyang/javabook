package online.javabook.distributed.rpc.center.impl.reference;

import online.javabook.distributed.rpc.center.api.reference.IRpcServiceReference;
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
		session.close(true);
		IoConnector connector = (IoConnector) session.getService();
		connector.dispose();
	}

}
