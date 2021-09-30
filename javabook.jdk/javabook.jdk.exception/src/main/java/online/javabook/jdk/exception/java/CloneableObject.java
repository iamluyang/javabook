package online.javabook.jdk.exception.java;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class CloneableObject /*implements Cloneable*/ {

	/**
	 * name
	 */
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param name
	 */
	public CloneableObject(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return
	 */
	public CloneableObject shallowCopy() {
		
		try {
			return (CloneableObject) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return
	 */
	public CloneableObject deepCopy() {
		
		try {
			return (CloneableObject) this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		return name;
	}
	
}
