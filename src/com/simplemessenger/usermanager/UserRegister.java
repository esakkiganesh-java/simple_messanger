package com.simplemessenger.usermanager;

import java.util.ArrayList;
import java.util.Scanner;
import com.simplemessenger.inboxmanager.InboxMessageStorage;
import com.simplemessenger.pastmessagesmanager.PastMessageStorage;

public class UserRegister {
	   public static void register() {
		    Scanner scanner = new Scanner(System.in);
	    	System.out.println("New User Registeration");
	    	System.out.println("Please Enter the required valid details");
	    	System.out.println("Enter the userName : ");
	    	String userName = scanner.nextLine();
	    	System.out.println("Set PIN : ");
	    	int setPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	System.out.println("Confirm PIN : ");
	    	int confirmPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	if(setPIN == confirmPIN) {
	    		UserDataStorage.userList.add(new User(userName,setPIN));
	    		InboxMessageStorage.userMessages.put(User.idCounter,new ArrayList<>());
	    		PastMessageStorage.pastMessages.put(User.idCounter,new ArrayList<>());
	    		System.out.println("Registered Successfully!");
	    	}
	    	else {
	    		System.out.println("Your PIN's dosen't Match try again!");
	    	}
	    }
}

