package com.simplemessenger.usermanager;

import java.util.ArrayList;
import java.util.Scanner;

public class UserRegister implements UserRegisterService{ 
	    UserData userData = new UserData();
	    UserDataStorage userDataStorage = new UserDataStorage();
	    RegisterUpdates registerUpdates = new RegisterUpdates();
	   @Override
	   //To get a details from User for Register
	   public void getUserDetails() {
		    Scanner scanner = new Scanner(System.in);
	    	System.out.println("[-New User Registeration-]");
	    	System.out.println("Enter the userName : ");
	    	String userName = scanner.nextLine();
	    	System.out.println("Set PIN : ");
	    	int setPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	System.out.println("Confirm PIN : ");
	    	int confirmPIN = scanner.nextInt();
	    	scanner.nextLine();
	        boolean verify = verifyUserRegisteration(userName,setPIN,confirmPIN);
	        if(!verify) {
	        	System.out.println("Your setPIN doesn't Match confirmPIN try again");
	        	return;
	        }		
	 }
	@Override
	//To verify the user Details
	public boolean verifyUserRegisteration(String userName,int setPIN,int confirmPIN) {
		if(setPIN == confirmPIN) {
			register(userName,confirmPIN);
			return true;
		}
     return false;
	}
	@Override
	//new user registeration, add the user data's to the UserList
	public void register(String userName,int confirmPIN) {
		userDataStorage.getUserList().add(new UserData(userName,confirmPIN));
		registerUpdates.updateNewUserRegister();
	}
	
 }


