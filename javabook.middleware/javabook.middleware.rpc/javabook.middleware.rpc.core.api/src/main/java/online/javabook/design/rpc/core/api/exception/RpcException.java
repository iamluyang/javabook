package online.javabook.design.rpc.core.api.exception;

import java.io.IOException;

/**
 * Indicates an exception during the execution of remote procedure call.
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcException extends IOException {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs exception with the specified detail message.
	 * 
	 * @param message
	 *            detailed message.
	 */
	RpcException(final String message) {
		super(message);
	}

	/**
	 * Constructs exception with the specified detail message and cause.
	 * 
	 * @param message
	 *            message.
	 * @param cause
	 *            that cause this exception
	 * @param cause
	 *            the cause (can be retried by the {@link #getCause()} method).
	 *            (A <tt>null</tt> value is permitted, and indicates that the
	 *            cause is nonexistent or unknown.)
	 */
	RpcException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
