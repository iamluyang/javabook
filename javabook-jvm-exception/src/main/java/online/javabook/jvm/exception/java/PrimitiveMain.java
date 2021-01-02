package online.javabook.jvm.exception.java;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-21
 *
 */
public class PrimitiveMain {

	public static void main(String[] args) {
		
		// 数据截断
		int  i = Integer.MAX_VALUE;
		byte b = (byte)i;
		
		System.out.println( i  + " : " + Integer.toBinaryString(i) );
		System.out.println( b + " : " + Integer.toBinaryString(b) );
		
		// 浮点数乘法精度-问题(除法/加法/减法雷同)
		double dx = 1.025;
		double dy = 1.003;
		double dv = dx * dy;
		System.out.println();
		System.out.println( dx + " * " + dy + " != " + dv);
		
		// 浮点数乘法精度-解决1
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMinimumFractionDigits( 6 );
		System.out.println( dx + " * " + dy + " != " + numberFormat.format(dv));
		
		// 浮点数乘法精度-解决2(除法/加法/减法雷同)
		BigDecimal bdx = new BigDecimal(Double.toString(1.025));  
        BigDecimal bdy = new BigDecimal(Double.toString(1.003));  
        BigDecimal bdv = bdx.multiply(bdy);   
		System.out.println( dx + " * " + dy + " != " + bdv);
		
		// 科学计数法精度-问题
		float e = 10000000001L;
		System.out.println();
		System.out.println( e + " != " + "10000000001L" );
		
		// 科学计数法精度-解决
		BigDecimal de = new BigDecimal(Double.toString(10000000001L));  
		System.out.println( de + " = " + "10000000001L" );
		
		// java.lang.ArithmeticException
		int arithmetic = 100 / 0;
		System.out.println( arithmetic );
	}
}