package online.javabook.distributed.rpc.server.impl.reference;

import online.javabook.distributed.rpc.server.api.reference.IRpcServiceReference;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class LocalRpcServiceReferenceImpl<S> implements IRpcServiceReference {

	/**
	 * service
	 */
	private S service;
	
	/**
	 * @param service
	 */
	public LocalRpcServiceReferenceImpl(S service) {
		this.service = service;
	}
	
	@Override
	public S getService() {
		return service;
	}

	@Override
	public void close() {
		
	}

}
