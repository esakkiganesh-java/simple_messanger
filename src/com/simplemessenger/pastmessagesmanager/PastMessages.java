package com.simplemessenger.pastmessagesmanager;

import java.util.List;
import java.util.Map.Entry;

import com.simplemessenger.messagemanager.UserMessageFormatter;
import com.simplemessenger.usermanager.User;

public class PastMessages {
	public static void viewPastMessages() {
		
		   for(Entry<Integer, List<UserMessageFormatter>> pastMsg: PastMessageStorage.pastMessages.entrySet()) {
			   if(pastMsg.getKey() == User.LOGGED_USERID) {
				   if(pastMsg.getValue().isEmpty()) {
					   System.out.println("No Past Messages");
					   return;
				   }
				   else {
					 for(int i = 0; i < pastMsg.getValue().size(); i++) {
						 System.out.println(pastMsg.getValue().get(i).receiverName+" :  < "+pastMsg.getValue().get(i).messageContent+" > send by "+pastMsg.getValue().get(i).senderName);
					 }
					 return;
				   }
			   }
		   }
		 }
}
