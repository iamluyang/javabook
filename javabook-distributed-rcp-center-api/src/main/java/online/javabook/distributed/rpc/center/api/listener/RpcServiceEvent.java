package online.javabook.distributed.rpc.center.api.listener;

import java.util.Dictionary;
import java.util.EventObject;

import online.javabook.distributed.rpc.center.api.registration.IRpcServiceRegistration;

/**
 * An event from the Framework describing a service lifecycle change.
 * <p>
 * {@code ServiceEvent} objects are delivered to {@code ServiceListener}s and
 * {@code AllServiceListener}s when a change occurs in this service's lifecycle.
 * A type code is used to identify the event type for future extendability.
 * 
 * @Immutable
 * @see IRpcServiceListener
 * @see AllServiceListener
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class RpcServiceEvent extends EventObject {

	/**
	 * serialVersionUID
	 */
	static final long serialVersionUID = 8792901483909409299L;

	/**
	 * Reference to the service that had a change occur in its lifecycle.
	 */
	private final IRpcServiceRegistration reference;

	/**
	 * Type of service lifecycle change.
	 */
	private final int type;

	/**
	 * This service has been registered.
	 * <p>
	 * This event is synchronously delivered <strong>after</strong> the service
	 * has been registered with the Framework.
	 * 
	 * @see BundleContext#addServiceRegistration(String[],Object,Dictionary)
	 */
	public final static int REGISTERED = 0x00000001;

	/**
	 * The properties of a registered service have been modified.
	 * <p>
	 * This event is synchronously delivered <strong>after</strong> the service
	 * properties have been modified.
	 * 
	 * @see ServiceRegistration#setProperties
	 */
	public final static int MODIFIED = 0x00000002;

	/**
	 * This service is in the process of being unregistered.
	 * <p>
	 * This event is synchronously delivered <strong>before</strong> the service
	 * has completed unregistering.
	 * 
	 * <p>
	 * If a bundle is using a service that is {@code UNREGISTERING}, the bundle
	 * should release its use of the service when it receives this event. If the
	 * bundle does not release its use of the service when it receives this
	 * event, the Framework will automatically release the bundle's use of the
	 * service while completing the service unregistration operation.
	 * 
	 * @see ServiceRegistration#unregister
	 * @see BundleContext#ungetService
	 */
	public final static int UNREGISTERING = 0x00000004;

	/**
	 * The properties of a registered service have been modified and the new
	 * properties no longer match the listener's filter.
	 * <p>
	 * This event is synchronously delivered <strong>after</strong> the service
	 * properties have been modified. This event is only delivered to listeners
	 * which were added with a non-{@code null} filter where the filter matched
	 * the service properties prior to the modification but the filter does not
	 * match the modified service properties.
	 * 
	 * @see ServiceRegistration#setProperties
	 * @since 1.5
	 */
	public final static int MODIFIED_ENDMATCH = 0x00000008;

	/**
	 * Creates a new service event object.
	 * 
	 * @param type
	 *            The event type.
	 * @param reference
	 *            A {@code ServiceReference} object to the service that had a
	 *            lifecycle change.
	 */
	public RpcServiceEvent(int type, IRpcServiceRegistration reference) {
		super(reference);
		this.reference = reference;
		this.type = type;
	}

	/**
	 * Returns a reference to the service that had a change occur in its
	 * lifecycle.
	 * <p>
	 * This reference is the source of the event.
	 * 
	 * @return Reference to the service that had a lifecycle change.
	 */
	public IRpcServiceRegistration getServiceReference() {
		return reference;
	}

	/**
	 * Returns the type of event. The event type values are:
	 * <ul>
	 * <li>{@link #REGISTERED}</li>
	 * <li>{@link #MODIFIED}</li>
	 * <li>{@link #MODIFIED_ENDMATCH}</li>
	 * <li>{@link #UNREGISTERING}</li>
	 * </ul>
	 * 
	 * @return Type of service lifecycle change.
	 */

	public int getType() {
		return type;
	}
}
