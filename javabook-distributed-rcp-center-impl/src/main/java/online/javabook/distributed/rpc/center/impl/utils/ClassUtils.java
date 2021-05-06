package online.javabook.distributed.rpc.center.impl.utils;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-11-21
 *
 */
public class ClassUtils {

	/**
	 * EMPRY_INTERFACES
	 */
	private static Class[] EMPRY_INTERFACES = new Class[]{};

	/**
	 * EMPRY_INTERFACENAMES
	 */
	private static String[] EMPRY_INTERFACENAMES = new String[]{};
	
	/**
	 * @param object
	 * @return
	 */
	public static Class[] getInterfaces(Object object) {
		
		if(object!=null) {
			Class<?>[] interfaces = object.getClass().getInterfaces();
			return interfaces;
		}else
			return EMPRY_INTERFACES;
	}
	
	/**
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
			return EMPRY_INTERFACENAMES;
		}
	}
}
