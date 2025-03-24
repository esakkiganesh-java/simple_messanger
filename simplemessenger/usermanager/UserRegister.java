package com.simplemessenger.usermanager;

import java.util.Scanner;

public class UserRegister implements UserRegisterService{ 
	    Scanner scanner = new Scanner(System.in);
	   private  UserDataStorage userDataStorage = new UserDataStorage();
	   private  RegisterUpdates registerUpdates = new RegisterUpdates();
	   @Override
	   //To get a details from User for Register
	   public void getUserDetails() {
	    	System.out.println("[-New User Registeration-]");
	    	System.out.println("Enter the userName : ");
	    	String userName = scanner.nextLine();
	    	boolean validUserName = checkValidUserName(userName);
	    	if(!validUserName) {
	    		System.out.println("This User Name is already found,please choose another user name and try again!");
	    		return;
	    	}
	    	System.out.println("Set PIN : ");
	    	int setPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	System.out.println("Confirm PIN : ");
	    	int confirmPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	boolean verify = verifyUserRegisteration(userName,setPIN,confirmPIN);
		        if(!verify) {
		        	System.out.println("your setPIN doesn't match confirmPIN try again");
		        	return;
		        }	
	   }
	@Override 
	// To the user name is already found or not
	public boolean checkValidUserName(String userName) {
	   if(userDataStorage.getUserList().isEmpty()) {
		   return true;
	   }
	   else {
		 for(UserData userData : userDataStorage.getUserList()) {
			 if(userData.getUserName().equals(userName)) {
				return false;
			 }
		 }
	   }
	 return true;
	}
	@Override
	//To check the setPIN matches confirmPIN
	public boolean verifyUserRegisteration(String userName,int setPIN, int confirmPIN) {
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


