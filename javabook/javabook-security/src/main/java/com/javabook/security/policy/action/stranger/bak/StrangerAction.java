package com.javabook.security.policy.action.stranger.bak;

import java.security.AccessController;
import java.security.PrivilegedAction;

import com.javabook.security.policy.action.api.bak.IAction;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-25
 *
 */
public class StrangerAction implements IAction {
	
	/**
	 * next
	 */
	private IAction next;
	
	/**
	 * direct
	 */
	private boolean direct;

	/**
	 * @param next
	 * @param direct
	 */
	public StrangerAction(IAction next, boolean direct) {
		super();
		this.next   = next;
		this.direct = direct;
	}

	@Override
	public void execute() {
		
		if(direct){
			next.execute();
		}else{
			AccessController.doPrivileged( 
				new PrivilegedAction<Object>() {
					@Override
					public Object run() {
						next.execute();
						return null;
					}
				}
			);
		}
	}
}
