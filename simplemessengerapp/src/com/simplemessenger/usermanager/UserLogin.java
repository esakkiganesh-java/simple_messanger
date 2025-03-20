package com.simplemessenger.usermanager;

import java.util.Scanner;

public class UserLogin implements UserLoginService{
	 Scanner scanner = new Scanner(System.in);
	 LoginVerifierService loginVerifier = new LoginVerifier();
	@Override
	// To get a User Details for login
	public void getLoginDetails()  {
	    	System.out.println("< Note: Enter the valid User details for Login!>");
	    	System.out.println("Enter userName : ");
	    	String userName = scanner.nextLine();
	    	System.out.println("Enter your PIN : ");
	    	int userPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	boolean valid = loginVerifier.validateLoginDetails(userName,userPIN);
	    	if(!valid) {
	    	    System.out.println("Your UserName or PIN is not found ! please register or try again");
	    	}
	    }
 }
