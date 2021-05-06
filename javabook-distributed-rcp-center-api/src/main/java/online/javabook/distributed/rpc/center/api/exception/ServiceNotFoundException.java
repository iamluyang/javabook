package online.javabook.distributed.rpc.center.api.exception;


/**
 * Indicates an exception during the execution of remote procedure call.
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-20
 */
public class ServiceNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2823302786367244200L;

	/**
	 * Constructs exception with the specified detail message.
	 * 
	 * @param message
	 *            detailed message.
	 */
	public ServiceNotFoundException(final String message) {
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
	public ServiceNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
