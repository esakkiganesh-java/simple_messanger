package com.simplemessenger.messagemanager;

import java.util.List;
import java.util.Map.Entry;

import com.simplemessenger.inboxmanager.InboxMessageStorage;
import com.simplemessenger.pastmessagesmanager.PastMessageStorage;
import com.simplemessenger.usermanager.UserData;
import com.simplemessenger.usermanager.UserDataStorage;

public class MessageSender implements MessageSenderService{
	UserData userData = new UserData();
	UserDataStorage userDataStorage = new UserDataStorage();
	InboxMessageStorage inboxMessageStorage = new InboxMessageStorage();
	PastMessageStorage pastMessageStorage = new PastMessageStorage();
	
	@Override
	//To Send Message to the ReceiverInbox and user's PastMessages
	public void sendMessage(String receiverName,int receiverId,String messageContent) {
	   for(Entry<Integer, List<UserMessageFormatter>> msgEntry : inboxMessageStorage.getUserMessages().entrySet()) {
		   if(msgEntry.getKey() == receiverId) {
				msgEntry.getValue().add(new UserMessageFormatter(receiverName,messageContent,userData.getLOGGED_USER()));
				   for(Entry<Integer, List<UserMessageFormatter>> pastMsgEntry: pastMessageStorage.getpastMessages().entrySet()) {
				       if(pastMsgEntry.getKey() == userData.getLOGGED_USERID()) {
						  pastMsgEntry.getValue().add(new UserMessageFormatter(receiverName,messageContent,userData.getLOGGED_USER()));
						  break;
						}
				    }
					System.out.println("Message sent..!");
					return ;
				}
			}
		}	
}
