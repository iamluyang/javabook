package online.javabook.jvm.security.policy.main;

import online.javabook.jvm.security.policy.action.api.bak.IAction;
import online.javabook.jvm.security.policy.action.friend.bak.FriendAction;
import online.javabook.jvm.security.policy.action.impl.bak.ActionImpl;
import online.javabook.jvm.security.policy.action.stranger.bak.StrangerAction;

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
		IAction action = new ActionImpl("question.txt");
		IAction friend = new FriendAction(action, true);
		IAction strang = new StrangerAction(friend, true);
		strang.execute();
	}
}