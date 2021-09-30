package online.javabook.design.thread.immutable;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public final class Person {

	/**
	 * name
	 */
	private final String name;
	
	/**
	 * address
	 */
	private final String address;

	/**
	 * @param name
	 * @param address
	 */
	public Person(String name, String address) {
		this.name    = name;
		this.address = address;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	public String toString() {
		return "[ Person: name = " + name + ", address = " + address + " ]";
	}
}
