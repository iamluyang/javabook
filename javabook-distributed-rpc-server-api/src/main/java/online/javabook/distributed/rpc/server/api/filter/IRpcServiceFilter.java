package online.javabook.distributed.rpc.server.api.filter;

import online.javabook.distributed.rpc.server.api.registration.IRpcServiceRegistration;

import java.util.Dictionary;
import java.util.Map;

/**
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public interface IRpcServiceFilter {
	
	/**
	 * Filter using a service's properties.
	 * <p>
	 * This {@code Filter} is executed using the keys and values of the
	 * referenced service's properties. The keys are looked up in a case
	 * insensitive manner.
	 * 
	 * @param reference The reference to the service whose properties are used
	 *        in the match.
	 * @return {@code true} if the service's properties match this
	 *         {@code Filter}; {@code false} otherwise.
	 */
	boolean match(IRpcServiceRegistration reference);

	/**
	 * Filter using a {@code Dictionary} with case insensitive key lookup. This
	 * {@code Filter} is executed using the specified {@code Dictionary}'s keys
	 * and values. The keys are looked up in a case insensitive manner.
	 * 
	 * @param dictionary The {@code Dictionary} whose key/value pairs are used
	 *        in the match.
	 * @return {@code true} if the {@code Dictionary}'s values match this
	 *         filter; {@code false} otherwise.
	 * @throws IllegalArgumentException If {@code dictionary} contains case
	 *         variants of the same key name.
	 */
	boolean match(Dictionary<String, ? > dictionary);

	/**
	 * Returns this {@code Filter}'s filter string.
	 * <p>
	 * The filter string is normalized by removing whitespace which does not
	 * affect the meaning of the filter.
	 * 
	 * @return This {@code Filter}'s filter string.
	 */
	String toString();

	/**
	 * Compares this {@code Filter} to another {@code Filter}.
	 * 
	 * <p>
	 * This implementation returns the result of calling
	 * {@code this.toString().equals(obj.toString())}.
	 * 
	 * @param obj The object to compare against this {@code Filter}.
	 * @return If the other object is a {@code Filter} object, then returns
	 *         the result of calling
	 *         {@code this.toString().equals(obj.toString())};
	 *         {@code false} otherwise.
	 */
	boolean equals(Object obj);

	/**
	 * Returns the hashCode for this {@code Filter}.
	 * 
	 * <p>
	 * This implementation returns the result of calling
	 * {@code this.toString().hashCode()}.
	 * 
	 * @return The hashCode of this {@code Filter}.
	 */
	int hashCode();

	/**
	 * Filter using a {@code Dictionary}. This {@code Filter} is executed using
	 * the specified {@code Dictionary}'s keys and values. The keys are looked
	 * up in a normal manner respecting case.
	 * 
	 * @param dictionary The {@code Dictionary} whose key/value pairs are used
	 *        in the match.
	 * @return {@code true} if the {@code Dictionary}'s values match this
	 *         filter; {@code false} otherwise.
	 * @since 1.3
	 */
	boolean matchCase(Dictionary<String, ? > dictionary);

	/**
	 * Filter using a {@code Map}. This {@code Filter} is executed using the
	 * specified {@code Map}'s keys and values. The keys are looked up in a
	 * normal manner respecting case.
	 * 
	 * @param map The {@code Map} whose key/value pairs are used in the match.
	 *        Maps with {@code null} key or values are not supported. A
	 *        {@code null} value is considered not present to the filter.
	 * @return {@code true} if the {@code Map}'s values match this filter;
	 *         {@code false} otherwise.
	 * @since 1.6
	 */
	boolean matches(Map<String, ? > map);
}
