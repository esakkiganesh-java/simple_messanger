package com.simplemessenger.inboxmanager;

import java.util.List;
import java.util.Map;
import com.simplemessenger.messagemanager.UserMessageFormatter;
import com.simplemessenger.usermanager.User;

public class UserInbox {
	 public static void viewInbox() {
	    	if(InboxMessageStorage.userMessages.isEmpty()) {
	    		System.out.println("No new Messages!");
	    		return;
	    	}
	    	for(Map.Entry<Integer,List<UserMessageFormatter>> entry: InboxMessageStorage.userMessages.entrySet()) {
	    		if(entry.getKey().equals(User.LOGGED_USERID)) {
	    		   if(entry.getValue().isEmpty()) {
	    			   System.out.println("Hi "+User.LOGGED_USER+" , no new messages!");
	    		   }
	    		   else {
	    			   System.out.println(User.LOGGED_USER+" your inbox Messages ");
	    			   for(int i = 0; i < entry.getValue().size(); i++) {
	    			   System.out.println(entry.getValue().get(i).receiverName+" : < "+entry.getValue().get(i).messageContent+" > send by "+entry.getValue().get(i).senderName);
	    			   }
	    			   return;
	    		  }
	    		}
	    	}
	    	
	    }
}

