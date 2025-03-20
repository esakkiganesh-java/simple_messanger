package com.simplemessenger.messagemanager;

import java.util.Scanner;

public class UserMessage implements UserMessageService{
	Scanner scanner = new Scanner(System.in);
	ReceiverVerifier receiverVerifier = new ReceiverVerifier();
	@Override
	//To get a Receiver details from User
	 public void getReceiverDetails() {
		 System.out.println("Enter the userName for send message : ");
	     String receiverName = scanner.nextLine();
	     boolean verify = receiverVerifier.verifyReceiverDetails(receiverName);
	     if(!verify) {
	    	System.out.println("Sorry, Receiver details not found");
	    	return;
	    		
	     }
	}
}
