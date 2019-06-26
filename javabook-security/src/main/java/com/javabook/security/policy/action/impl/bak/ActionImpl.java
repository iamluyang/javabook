package com.javabook.security.policy.action.impl.bak;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.javabook.security.policy.action.api.bak.IAction;


/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
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
