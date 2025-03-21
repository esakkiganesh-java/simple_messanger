package com.simplemessenger.usermanager;

import java.util.Scanner;

import com.simplemessenger.inbox.UserInboxService;
import com.simplemessenger.pastmessagesmanager.PastMessagesService;
import com.simplemessenger.messagemanager.UserMessageService;

public class UserMenu {
	 static Scanner scanner = new Scanner(System.in);	
	 private static  UserMessageService userMessageService;
	 private static UserInboxService userInboxService;
	 private  static PastMessagesService pastMessagesService;
		public UserMenu(UserMessageService userMessageService, UserInboxService userInboxService, PastMessagesService pastMessagesService) {
		     this.userMessageService = userMessageService;
		     this.userInboxService = userInboxService;
		     this.pastMessagesService = pastMessagesService;
		}
  public static void viewUserMenu() {
	   while(true) {
    	System.out.println("1.Message");
    	System.out.println("2.Inbox");
    	System.out.println("3.Past Messages");
    	System.out.println("4.Logout");
    	System.out.println("Enter your choice : ");
    	int choice = scanner.nextInt();
    	switch(choice) {
    	  case 1:{
    		  userMessageService.getReceiverDetails();
    		  break;
    	  }
    	  case 2:{
    		  userInboxService.viewInbox();
    		  break;
    	  }
    	  case 3:{
    		  pastMessagesService.viewPastMessages();
    		  break;
    	  }
    	  case 4 :{
    		  System.out.println("logging out..");
    		  return;
    	  }
    	  default :{
    		  System.out.println("Invalid option try again!");
    		  break;
    	  }
    	}
     }
    	
   }

}

