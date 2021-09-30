package online.javabook.jvm.gc.others.promotion;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html
 *
 * -Xms256m -Xmx256m -XX:-UseAdaptiveSizePolicy -XX:+PrintGCDetails
 *
 * 针对不同年龄段的对象分配原则如下所示:
 * 1.优先分配到Eden
 * 2.大对象直接分配到老年代，尽量避免程序中出现过多的大对象
 * 3.长期存活的对象分配到老年代
 * 4.动态对象年龄判断，如果survivor区中相同年龄的所有对象大小的总和大于survivor空间的一半，
 * 年龄大于或等于该年龄的对象可以直接进入老年代，无须等到MaxTenuringThreshold 中要求的年龄
 * 5.空间分配担保 -XX : HandlePromotionFailure
 *
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class BigObjectPromotionToOldSpaceDemo1 {

	/**
	 Heap
	 PSYoungGen      total 76288K, used 5243K [0x00000000fab00000, 0x0000000100000000, 0x0000000100000000)
	 eden space 65536K, 8% used [0x00000000fab00000,0x00000000fb01ed38,0x00000000feb00000)
	 from space 10752K, 0% used [0x00000000ff580000,0x00000000ff580000,0x0000000100000000)
	 to   space 10752K, 0% used [0x00000000feb00000,0x00000000feb00000,0x00000000ff580000)
	 ParOldGen       total 175104K, used 102400K [0x00000000f0000000, 0x00000000fab00000, 0x00000000fab00000)
	 object space 175104K, 58% used [0x00000000f0000000,0x00000000f6400010,0x00000000fab00000)
	 Metaspace       used 3186K, capacity 4496K, committed 4864K, reserved 1056768K
	 class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
	 */
	public static void main(String[] args) throws InterruptedException {

		List<byte[]> headMemorys = new LinkedList<>();

		// 这是一个大对象，无法分配在新生代，因此直接晋级到年老代
		byte[] _100MB = new byte[1024 * 1024 * 100];
		headMemorys.add(_100MB);
		Thread.sleep(1000000);
		System.out.println(headMemorys);
	}
}
