package online.javabook.jvm.security.policy.main;

import online.javabook.jvm.security.policy.action.api.IAction;
import online.javabook.jvm.security.policy.action.friend.FriendAction;
import online.javabook.jvm.security.policy.action.impl.ActionImpl;
import online.javabook.jvm.security.policy.action.stranger.StrangerAction;

/**
 * @author Summer Lu
 * @email gmluyang@gmail.com
 * @date 2014-8-25
 *
 */
public class MainStrangPolicy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// action
		IAction action = new ActionImpl("./pom.xml");
		IAction friend = new FriendAction(action, true);
		IAction strang = new StrangerAction(friend, true);
		strang.execute();
	}
}