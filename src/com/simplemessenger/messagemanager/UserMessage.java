package com.simplemessenger.messagemanager;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.simplemessenger.inboxmanager.InboxMessageStorage;
import com.simplemessenger.pastmessagesmanager.PastMessageStorage;
import com.simplemessenger.usermanager.User;
import com.simplemessenger.usermanager.UserDataStorage;

public class UserMessage {
	 public static void sendMessage() {
		 Scanner scanner = new Scanner(System.in);
	    	System.out.println("Enter the userName for send message : ");
	    	String receiverName = scanner.nextLine();
	    	for(User user: UserDataStorage.userList) {
	    		if(user.userName.equals(receiverName)) {
	    		   int receiverId = user.userId;
	    		   System.out.println("Enter the messageContent: ");
	    		   String messageContent = scanner.nextLine();
	    		   for(Entry<Integer, List<UserMessageFormatter>> entry : InboxMessageStorage.userMessages.entrySet()) {
	    			   if(entry.getKey() == receiverId) {
	    				  entry.getValue().add(new UserMessageFormatter(receiverName,messageContent,User.LOGGED_USER));
	    				  for(Entry<Integer, List<UserMessageFormatter>> pastMsgEntry: PastMessageStorage.pastMessages.entrySet()) {
	    					  if(pastMsgEntry.getKey() == User.LOGGED_USERID) {
	    						 pastMsgEntry.getValue().add(new UserMessageFormatter(receiverName,messageContent,User.LOGGED_USER));
	    						 break;
	    					  }
	    				  }
	    				  System.out.println("Message sent..!");
	    				  return ;
	    			   }
	    		   }
	    		  
	    		}
	    	} 
	    	System.out.println("UserName not found try again!");
	    }
}
