package online.javabook.reference.finalize;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-9-25
 * 
 */
public class Earth1 {

	public static void main(String[] args) throws InterruptedException {

		Host  host  = new Host();  // 宿主
		Alien alien = new Alien(); // 异形
		System.out.println("异形alien第1次在地球出场" + alien + "\n");

		/**
		  * 异形获得宿主的引用
		 */
		alien.host = host;

		System.out.println("地球第1次尝试清除异形alien.");
		alien = null;

		System.out.println("地球第1次启动GC武器清除alien." + "\n");
		System.gc();

		System.out.println("地球先休息一下，好让finalize" + "\n");
		Thread.sleep(20000);

		if (host.copy != null) {
			System.out.println("异形alien在宿主中复活，因为异形alien的finalize方法被触发:" + host.copy + "\n");
			host.copy = null;
		} else {
			System.out.println("启动了GC武器但是根本没有打中异形alien，因为异形alien没有在宿主中复活.\n");
		}

		System.gc();
		System.out.println("地球第2次启动GC武器清除alien." + "\n");

		if (host.copy != null) {
			System.out.println("异形alien在宿主中出场:" + host.copy);
		} else
			System.out.println("异形alien在地球第2次清除中消灭了.");
	}
}
