package com.simplemessenger.pastmessagesmanager;

import java.util.List;
import java.util.Map;
import com.simplemessenger.messagemanager.MessageStorage;
import com.simplemessenger.messagemanager.MessageData;
import com.simplemessenger.usermanager.UserData;

public class PastMessages implements PastMessagesService{
   private UserData userData = new UserData();
   private MessageStorage messageStorage = new MessageStorage();
    @Override
    //To view User PastMessages using LoggedIn UserID
	public void viewPastMessages() {
		for(Map.Entry<Integer, List<MessageData>> pastMsgEntry: messageStorage.getPastMessages().entrySet()) {
			if(pastMsgEntry.getKey() == userData.getLOGGED_USERID()) {
			   // To check the User's PastMessages found or not
			   if(pastMsgEntry.getValue().isEmpty()) {
				  System.out.println("Hi "+userData.getLOGGED_USER()+", No Past Messages");
				  return;
			   }
			   else {
				  System.out.println("Hi "+userData.getLOGGED_USER()+" , your past MessageHistory!");
				  for(int i = 0; i < pastMsgEntry.getValue().size(); i++) {
					  System.out.println(pastMsgEntry.getValue().get(i).receiverName+" :  [ "+pastMsgEntry.getValue().get(i).messageContent+" ] send by < "+pastMsgEntry.getValue().get(i).senderName+" >");
				   }
				return;
			   }
		    }
		}
	}
}
