package com.simplemessenger.usermanager;

import java.util.Scanner;

import com.simplemessenger.inboxmanager.UserInbox;
import com.simplemessenger.pastmessagesmanager.PastMessages;
import com.simplemessenger.messagemanager.UserMessage;

public class UserMenu {
	public static void viewUserMenu() {
	    Scanner scanner = new Scanner(System.in);
    	while(true) {
    	System.out.println("1.Message");
    	System.out.println("2.Inbox");
    	System.out.println("3.Past Messages");
    	System.out.println("4.Logout");
    	System.out.println("Enter your choice : ");
    	int choice = scanner.nextInt();
    	switch(choice) {
    	  case 1:
    		  UserMessage.sendMessage();
    		  break;
    	  case 2:
    		  UserInbox.viewInbox();
    		  break;
    	  case 3:
    		  PastMessages.viewPastMessages();
    		  break;
    	  case 4 :
    		  System.out.println("logging out..");
    		  User.LOGGED_USER = null;
    		  User.LOGGED_USERID = -1;
    		  return;
    	  default :
    		  System.out.println("Invalid option try again!");
    		  break;
    	}
     }
    	
   }

}

