package online.javabook.security.policy.action.impl.bak;

import online.javabook.security.policy.action.api.bak.IAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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
