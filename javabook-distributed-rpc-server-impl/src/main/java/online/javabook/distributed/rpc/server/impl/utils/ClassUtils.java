package online.javabook.distributed.rpc.server.impl.utils;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class ClassUtils {

	/**
	 * EMPTY_INTERFACES
	 */
	private final static Class[] EMPTY_INTERFACES = new Class[]{};

	/**
	 * EMPTY_INTERFACE_NAMES
	 */
	private final static String[] EMPTY_INTERFACE_NAMES = new String[]{};

	/**
	 *
	 * @param object
	 * @return
	 */
	public static Class[] getInterfaces(Object object) {

		if(object!=null) {
			Class<?>[] interfaces = object.getClass().getInterfaces();
			return interfaces;
		}else
			return EMPTY_INTERFACES;
	}

	/**
	 *
	 * @param object
	 * @return
	 */
	public static String[] getInterfaceNames(Object object) {

		if(object!=null) {
			Class[]  interfaces = getInterfaces(object);
			String[] interfaceNames = new String[interfaces.length];
			for (int i = 0; i < interfaces.length; i++) {
				String interfaceName = interfaces[i].getName();
				interfaceNames[i] = interfaceName;
			}
			return interfaceNames;
		}else{
			return EMPTY_INTERFACE_NAMES;
		}
	}
}
