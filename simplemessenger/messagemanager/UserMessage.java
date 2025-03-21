package com.simplemessenger.messagemanager;

import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;
import com.simplemessenger.usermanager.UserData;
import com.simplemessenger.usermanager.UserDataStorage;

public class UserMessage implements UserMessageService{
	Scanner scanner = new Scanner(System.in);
	UserData userData = new UserData();
	UserDataStorage userDataStorage = new UserDataStorage();
	MessageStorage messageStorage = new MessageStorage();
	@Override
	//To get a Receiver details from User
	 public void getReceiverDetails() {
		 System.out.println("Enter the userName for send message : ");
	     String receiverName = scanner.nextLine();
	     boolean verify = verifyReceiverDetails(receiverName);
	     if(!verify) {
	    	System.out.println("Sorry, Receiver details not found");
	    	return;
	    		
	     }
	 }
	 @Override
	 public boolean verifyReceiverDetails(String receiverName) {
		 for(UserData userData: userDataStorage.getUserList()) {
		    	if(userData.getUserName().equals(receiverName)) {
		    	   int receiverId = userData.getUserId();
		    	   getMessageContent(receiverName,receiverId);
		    	   return true;
		         }
			 }
		    return false;
		
	}
	@Override
	public void getMessageContent(String receiverName,int receiverId) {
		System.out.println("Enter the messageContent: ");
		String messageContent = scanner.nextLine();
		sendMessage(receiverName,receiverId,messageContent);
	}
	@Override
	public void sendMessage(String receiverName,int receiverId,String messageContent) {
		 for(Entry<Integer, List<MessageData>> msgEntry : messageStorage.getUserMessages().entrySet()) {
			   if(msgEntry.getKey() == receiverId) {
					msgEntry.getValue().add(new MessageData(receiverName,messageContent,userData.getLOGGED_USER()));
					break;
			   }
		 }
		 for(Entry<Integer, List<MessageData>> pastMsgEntry: messageStorage.getPastMessages().entrySet()) {
				if(pastMsgEntry.getKey() == userData.getLOGGED_USERID()) {
				   pastMsgEntry.getValue().add(new MessageData(receiverName,messageContent,userData.getLOGGED_USER()));
				   break;
				}
		 }
		 System.out.println("Message sent..!");
		 return ;		
	 }	
  }
	 
