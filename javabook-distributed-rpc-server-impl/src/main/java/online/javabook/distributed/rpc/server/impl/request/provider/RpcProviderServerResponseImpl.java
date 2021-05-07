package online.javabook.distributed.rpc.server.impl.request.provider;

import online.javabook.distributed.rpc.server.api.request.provider.IRpcProviderResponse;

import java.io.Serializable;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcProviderServerResponseImpl implements IRpcProviderResponse, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5295281999736154513L;

	/**
	 * result
	 */
	private Object result;

	/**
	 * methodName
	 */
	private Throwable throwable;

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public Throwable getThrowable() {
		return throwable;
	}

	@Override
	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
		
}
