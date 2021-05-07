package online.javabook.distributed.rpc.server.api.exception;

/**
 * A Framework exception used to indicate that a filter string has an invalid
 * syntax.
 * 
 * <p>
 * An {@code InvalidSyntaxException} object indicates that a filter string
 * parameter has an invalid syntax and cannot be parsed. See {@link online.javabook.distributed.rpc.server.api.filter.IRpcServiceFilter} for
 * a description of the filter string syntax.
 * 
 * <p>
 * This exception conforms to the general purpose exception chaining mechanism.
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-20
 */
public class InvalidSyntaxException extends Exception {

	/**
	 * serialVersionUID
	 */
	static final long serialVersionUID = -4295194420816491875L;

	/**
	 * The invalid filter string.
	 */
	private final String filter;

	/**
	 * Creates an exception of type {@code InvalidSyntaxException}.
	 * 
	 * <p>
	 * This method creates an {@code InvalidSyntaxException} object with the
	 * specified message and the filter string which generated the exception.
	 * 
	 * @param msg
	 *            The message.
	 * @param filter
	 *            The invalid filter string.
	 */
	public InvalidSyntaxException(String msg, String filter) {
		super(msg);
		this.filter = filter;
	}

	/**
	 * Creates an exception of type {@code InvalidSyntaxException}.
	 * 
	 * <p>
	 * This method creates an {@code InvalidSyntaxException} object with the
	 * specified message and the filter string which generated the exception.
	 * 
	 * @param msg
	 *            The message.
	 * @param filter
	 *            The invalid filter string.
	 * @param cause
	 *            The cause of this exception.
	 */
	public InvalidSyntaxException(String msg, String filter, Throwable cause) {
		super(msg, cause);
		this.filter = filter;
	}

	/**
	 * Returns the filter string that generated the
	 * {@code InvalidSyntaxException} object.
	 * 
	 * @return The invalid filter string.
	 */
	public String getFilter() {
		return filter;
	}

	/**
	 * Returns the cause of this exception or {@code null} if no cause was set.
	 * 
	 * @return The cause of this exception or {@code null} if no cause was set.
	 */
	public Throwable getCause() {
		return super.getCause();
	}

	/**
	 * Initializes the cause of this exception to the specified value.
	 * 
	 * @param cause
	 *            The cause of this exception.
	 * @return This exception.
	 * @throws IllegalArgumentException
	 *             If the specified cause is this exception.
	 * @throws IllegalStateException
	 *             If the cause of this exception has already been set.
	 */
	public Throwable initCause(Throwable cause) {
		return super.initCause(cause);
	}
}
