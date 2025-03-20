package com.simplemessenger.inboxmanager;

import java.util.List;
import java.util.Map;
import com.simplemessenger.messagemanager.UserMessageFormatter;
import com.simplemessenger.usermanager.UserData;

public class UserInbox implements UserInboxService{
	UserData userData = new UserData();
	InboxMessageStorage inboxMessageStorage = new InboxMessageStorage();
	 @Override
	 // To View User Inbox Using Current LoggedIn UserId
	 public  void viewInbox() {
		 for(Map.Entry<Integer,List<UserMessageFormatter>> msgEntry: inboxMessageStorage.getUserMessages().entrySet()) {
	    	if(msgEntry.getKey().equals(userData.getLOGGED_USERID())) {
	    		// To check the User Inbox is Empty or not
	    	    if(msgEntry.getValue().isEmpty()) {
	    		   System.out.println("Hi "+userData.getLOGGED_USER()+" , no new messages!");
	    	    }
	    	    else {
	    		    System.out.println(userData.getLOGGED_USER()+" your inbox Messages ");
	    		    //To print the User Inbox Messages
	    			for(int i = 0; i < msgEntry.getValue().size(); i++) {
	    			   System.out.println(msgEntry.getValue().get(i).receiverName+" : [ "+msgEntry.getValue().get(i).messageContent+" ] send by < "+msgEntry.getValue().get(i).senderName+" > ");
	    		    }
	    		 return;
	    	    }
	       }
		} 	
    }
}

