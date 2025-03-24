package com.simplemessenger.usermanager;

import java.util.ArrayList;
import com.simplemessenger.messagemanager.MessageStorage;


public class RegisterUpdates {
	private UserData userData = new UserData();
	private MessageStorage messageStorage = new MessageStorage();
	//To create the registered new user Inbox and PastMessagesStorage
		public void updateNewUserRegister() {
			messageStorage.getUserMessages().put(userData.getIdCounter(),new ArrayList<>());
			messageStorage.getPastMessages().put(userData.getIdCounter(),new ArrayList<>());
			System.out.println("Registered Successfully!");
		}	
}
