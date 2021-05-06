package online.javabook.pattern.thread.guardedsuspension;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Request {
	
	/**
	 * name
	 */
	private final String name;

	/**
	 * @param name
	 */
	public Request(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	public String toString() {
		return "[ Request " + name + " ]";
	}
}
