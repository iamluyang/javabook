package online.javabook.pattern.thread.future;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Host {

	public Result requestAsync(final String string) {

		System.out.println("request(" + string + ") BEGIN");

		final FutureResult future = new FutureResult();

		new Thread() {
			public void run() {
				RealResult realdata = new RealResult(string);
				future.setRealResult(realdata);

				future.doOnResult(realdata.getContent());
			}
		}.start();

		System.out.println("request(" + string + ") END");

		return future;
	}
}
