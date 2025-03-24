package com.simplemessenger.usermanager;

import java.util.Scanner;

public class UserLogin implements UserLoginService{
	 static Scanner scanner = new Scanner(System.in);
	 private UserDataStorage userDataStorage = new UserDataStorage();
	 private LoginUpdates loginUpdates = new LoginUpdates();
	@Override
	// To get a User Details for login
	public void getLoginDetails()  {
	    	System.out.println("< Note: Enter the valid User details for Login!>");
	    	System.out.println("Enter userName : ");
	    	String userName = scanner.nextLine();
	    	System.out.println("Enter your PIN : ");
	    	int userPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	boolean valid = validateLoginDetails(userName,userPIN);
	    	if(!valid) {
	    	    System.out.println("Your UserName or PIN is not found ! please register or try again");
	    	}
	 }
	 @Override
	 // To verify the User details are found in the userList
	 public boolean validateLoginDetails(String userName, int userPIN) {
		 for(UserData userData: userDataStorage.getUserList()) {
	    		if(userData.getUserName().equalsIgnoreCase(userName) && userData.getUserPIN() == userPIN) {
	    		   System.out.println("Login Successfully!");
	    		   loginUpdates.updateLoginDetails(userName,userData.getUserId());
	    		   return true;
	    		}
	     }
		 return false;
	 }
 }
