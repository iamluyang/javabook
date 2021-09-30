package online.javabook.design.thread.balking;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;


/**
 * 
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2015年7月19日
 *
 */
public class Resource {
	
	/**
	 * filename
	 */
	private String filename;
	
	/**
	 * content
	 */
	private String content;
	
	/**
	 * changed
	 */
	private boolean changed;

	/**
	 * @param filename
	 * @param content
	 */
	public Resource(String filename, String content) {
		this.filename = filename;
		this.content  = content;
		this.changed  = true;
	}

	/**
	 * @param newContent
	 */
	public synchronized void change(String newContent) {
		content = newContent;
		changed = true;
	}

	/**
	 * @throws IOException
	 */
	public synchronized void save() throws IOException {
		if (!changed) {
			System.out.println(Thread.currentThread().getName() + " balks");
			return;
		}
		doSave();
		changed = false;
	}

	/**
	 * @throws IOException
	 */
	private void doSave() throws IOException {
		System.out.println(Thread.currentThread().getName()	+ " calls doSave, content = " + content);
		Writer writer = new FileWriter(filename);
		writer.write(content);
		writer.close();
	}
}
