package com.simplemessenger.inboxmanager;

import com.simplemessenger.messagemanager.UserMessageFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InboxMessageStorage {
	
	public static Map<Integer,List<UserMessageFormatter>> userMessages = new HashMap<>();
	
}
