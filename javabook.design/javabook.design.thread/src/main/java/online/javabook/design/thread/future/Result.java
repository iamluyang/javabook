package online.javabook.design.thread.future;

/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public interface Result {
	
	/**
	 * @return
	 */
	public String getContent();

	public void addListener(IListener listener);

	public void removeListener(IListener listener);

	public void doOnResult(String result);

	public void doOnException(Exception exception);
}
