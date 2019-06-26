package com.javabook.security.policy.main;

import com.javabook.security.policy.action.api.bak.IAction;
import com.javabook.security.policy.action.friend.bak.FriendAction;
import com.javabook.security.policy.action.impl.bak.ActionImpl;
import com.javabook.security.policy.action.stranger.bak.StrangerAction;

/**
 * @author Summer Lu
 * @email summer.lu@software.dell.com
 * @date 2014-8-25
 *
 */
public class MainFriendPolicy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// action
		IAction action = new ActionImpl("answer.txt");
		IAction strang = new StrangerAction(action, true);
		IAction friend = new FriendAction(strang, false);
		friend.execute();
	}
}