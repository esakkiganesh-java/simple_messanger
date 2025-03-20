package com.simplemessenger.inboxmanager;

import com.simplemessenger.messagemanager.UserMessageFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InboxMessageStorage {
	//Store the User inbox Messages using HashMap , key = UserId, value = message details
	public static Map<Integer,List<UserMessageFormatter>> userMessages = new HashMap<>();
	
	public Map<Integer,List<UserMessageFormatter>> getUserMessages(){
		return userMessages;
	}
	
}
