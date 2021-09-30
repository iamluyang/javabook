package online.javabook.jvm.security.policy.action.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import online.javabook.jvm.security.policy.action.api.IAction;


/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class ActionImpl implements IAction {

	// file
	private String file;
	
	/**
	 * @param file
	 */
	public ActionImpl(String file) {		
		this.file = file;
	}

	@Override
	public void execute() {		
		try {
			File f = new File(file);
			FileInputStream is = new FileInputStream(f);			
			is.read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
}
