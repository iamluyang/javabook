package online.javabook.jvm.security.policy.action.friend;

import java.security.AccessController;
import java.security.PrivilegedAction;

import online.javabook.jvm.security.policy.action.api.IAction;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class FriendAction implements IAction {
	
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
	public FriendAction(IAction next, boolean direct) {
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
