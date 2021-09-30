package online.javabook.jvm.gc.others.promotion;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -Xms23m -Xmx23m -Xmn13m -XX:+PrintGCDetails
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class BigObjectPromotionToOldSpaceDemo2 {

	public static void main(String[] args) throws InterruptedException {
		byte[] _1MB = new byte[1024 * 1024 * 2];
		byte[] _3MB = new byte[1024 * 1024 * 2];
		byte[] _5MB = new byte[1024 * 1024 * 2];
		byte[] _7MB = new byte[1024 * 1024 * 4];

		Thread.sleep(1000);
	}
}
