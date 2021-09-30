package online.javabook.jvm.gc;

/**
 * 配置参数:
 * -Xms90M -Xmx90M -Xmn20M -XX:+PrintGCDetails
 * 
 * 内存分配比例:
 * Old 70
 * New 17.5(20)
 *  - Eden   15
 *  - S0      2.5
 *  - S1      2.5
 *  
 * @author LuYang
 *
 */
public class JvmMemory {

	public static void main(String[] args) throws InterruptedException {
		
		// Iint - 983K
		
		// Eden 16M
		byte[] _01M_In_Eden = new byte[1024*1024];  // 1M -> Eden 1 
		byte[] _02M_In_Eden = new byte[1024*1024];  // 1M -> Eden 2
		byte[] _03M_In_Eden = new byte[1024*1024];  // 1M -> Eden 3
		byte[] _04M_In_Eden = new byte[1024*1024];  // 1M -> Eden 4
		byte[] _05M_In_Eden = new byte[1024*1024];  // 1M -> Eden 5
		byte[] _06M_In_Eden = new byte[1024*1024];  // 1M -> Eden 6
		byte[] _07M_In_Eden = new byte[1024*1024];  // 1M -> Eden 7
		byte[] _08M_In_Eden = new byte[1024*1024];  // 1M -> Eden 8
		byte[] _09M_In_Eden = new byte[1024*1024];  // 1M -> Eden 9
		byte[] _10M_In_Eden = new byte[1024*1024];  // 1M -> Eden 10
		byte[] _11M_In_Eden = new byte[1024*1024];  // 1M -> Eden 11
		byte[] _12M_In_Eden = new byte[1024*1024];  // 1M -> Eden 12
		byte[] _13M_In_Eden = new byte[1024*1024];  // 1M -> Eden 13
		byte[] _14M_In_Eden = new byte[1024*1024];  // 1M -> Eden 14
		byte[] _15M_In_Eden = new byte[1024*1024];  // 1M -> Eden 15
		
		//Heap - 临界点
		// def new generation   total 18432K, used 16343K [0x2e900000, 0x2fd00000, 0x2fd00000)
		//  eden space 16384K,  99% used(1024*15+983) [0x2e900000, 0x2f8f5f28, 0x2f900000)
		//  from space 2048K,   0% used [0x2f900000, 0x2f900000, 0x2fb00000)
		//  to   space 2048K,   0% used [0x2fb00000, 0x2fb00000, 0x2fd00000)
		// tenured generation   total 71680K, used 0K [0x2fd00000, 0x34300000, 0x34300000)
		//   the space 71680K,   0% used [0x2fd00000, 0x2fd00000, 0x2fd00200, 0x34300000)
		// compacting perm gen  total 12288K, used 129K [0x34300000, 0x34f00000, 0x38300000)
		//   the space 12288K,   1% used [0x34300000, 0x343204c0, 0x34320600, 0x34f00000)
		//    ro space 10240K,  45% used [0x38300000, 0x38782e40, 0x38783000, 0x38d00000)
		//    rw space 12288K,  54% used [0x38d00000, 0x393867b8, 0x39386800, 0x39900000)
		
		//开始GC
		byte[] _16M_In_Eden = new byte[1024*1024];
		//[GC [DefNew: 16016K->1385K(18432K), 0.0190261 secs] 16016K->15721K(90112K)), 0.0190775 secs] [Times: user=0.02 sys=0.00, real=0.02 secs] 
		//             14631K(1024*14+295)    (Eden+S*1)      295           (Old+Eden+S*1)
		//	Heap
		//	 def new generation   total 18432K, used 3065K [0x2e900000, 0x2fd00000, 0x2fd00000)
		//	  eden space 16384K,  10% used() [0x2e900000, 0x2eaa3e50, 0x2f900000)
		//	  from space 2048K,   67% used() [0x2fb00000, 0x2fc5a660, 0x2fd00000)
		//	  to   space 2048K,    0% used   [0x2f900000, 0x2f900000, 0x2fb00000)
		//	 tenured generation   total 71680K, used 14336K [0x2fd00000, 0x34300000, 0x34300000)
		//	   the space 71680K,  20% used(1024*14) [0x2fd00000, 0x30b000e0, 0x30b00200, 0x34300000)
		//	 compacting perm gen  total 12288K, used 129K [0x34300000, 0x34f00000, 0x38300000)
		//	   the space 12288K,   1% used [0x34300000, 0x343204d8, 0x34320600, 0x34f00000)
		//	    ro space 10240K,  45% used [0x38300000, 0x38782e40, 0x38783000, 0x38d00000)
		//	    rw space 12288K,  54% used [0x38d00000, 0x393867b8, 0x39386800, 0x39900000)		
	}
}
