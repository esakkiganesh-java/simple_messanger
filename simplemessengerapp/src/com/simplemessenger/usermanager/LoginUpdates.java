package com.simplemessenger.usermanager;

import com.simplemessenger.inboxmanager.UserInbox;
import com.simplemessenger.inboxmanager.UserInboxService;
import com.simplemessenger.messagemanager.UserMessage;
import com.simplemessenger.messagemanager.UserMessageService;
import com.simplemessenger.pastmessagesmanager.PastMessages;
import com.simplemessenger.pastmessagesmanager.PastMessagesService;

public class LoginUpdates implements LoginUpdateServices{
    UserData userData = new UserData();
	@Override
	//To update the Current loggedIn user Details and show UserMenu
	public void updateLoginDetails(String userName,int userId) {
		 userData.setLOGGED_USER(userName);  
		 userData.setLOGGED_USERID(userId); 
		 UserMessageService userMessageService = new UserMessage();
         UserInboxService userInboxService = new UserInbox();
         PastMessagesService pastMessagesService = new PastMessages();
		   UserMenu userMenu = new UserMenu(userMessageService, userInboxService, pastMessagesService);
		   UserMenu.viewUserMenu();
		   return;
	}

}
