package com.simplemessenger.usermanager;

import java.util.ArrayList;

import com.simplemessenger.inboxmanager.InboxMessageStorage;
import com.simplemessenger.pastmessagesmanager.PastMessageStorage;

public class RegisterUpdates {
	UserData userData = new UserData();
	InboxMessageStorage inboxMessageStorage = new InboxMessageStorage();
    PastMessageStorage pastMessageStorage = new PastMessageStorage(); 
	//To create the registered new user Inbox and PastMessagesStorage
		public void updateNewUserRegister() {
			inboxMessageStorage.getUserMessages().put(userData.getIdCounter(),new ArrayList<>());
			pastMessageStorage.getpastMessages().put(userData.getIdCounter(),new ArrayList<>());
			System.out.println("Registered Successfully!");
		}
		
}
