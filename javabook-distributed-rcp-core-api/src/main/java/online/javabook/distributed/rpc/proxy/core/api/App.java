package online.javabook.distributed.rpc.proxy.core.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Hello world!
 *
 */
public class App 
{

	public void test() {
		Integer i = new Integer(5);
		System.out.println(this.getClass().getClassLoader());
		System.out.println(i.getClass().getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
	}
	
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	InputStream is = new FileInputStream(new File("App.class"));
    	byte[] heads = new byte[4];
    	is.read(heads);    	
    	for (byte head : heads) {
			Integer.toHexString( 0xFF & head ); // 0xCAFEBABE
		}
    	
    }
}
