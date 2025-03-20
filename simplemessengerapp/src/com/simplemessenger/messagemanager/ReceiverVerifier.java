package com.simplemessenger.messagemanager;

import com.simplemessenger.usermanager.UserData;
import com.simplemessenger.usermanager.UserDataStorage;

public class ReceiverVerifier {
	UserDataStorage userDataStorage = new UserDataStorage();
	MessageContent messageContent = new MessageContent();
	   // To Verify the Receiver details are found in UserData
	public boolean verifyReceiverDetails(String receiverName) {
		for(UserData userData: userDataStorage.getUserList()) {
	    	if(userData.getUserName().equals(receiverName)) {
	    	   int receiverId = userData.getUserId();
	    	   messageContent.getMessageContent(receiverName,receiverId);
	    	   return true;
	         }
		 }
	    return false;
	}
}
