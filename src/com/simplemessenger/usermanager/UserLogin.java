package com.simplemessenger.usermanager;
import java.util.Scanner;
public class UserLogin {
	 public static void login() {
		 Scanner scanner = new Scanner(System.in);
	    	System.out.println("Note: Enter the valid User details for Login!");
	    	System.out.println("Enter userName : ");
	    	String userName = scanner.nextLine();
	    	System.out.println("Enter your PIN : ");
	    	int userPIN = scanner.nextInt();
	    	scanner.nextLine();
	    	for(User user: UserDataStorage.userList) {
	    		if(user.userName.equalsIgnoreCase(userName)&&user.userPIN == userPIN) {
	    		   System.out.println("Login Successfully!");
	    		   User.LOGGED_USER = userName;
	    		   User.LOGGED_USERID = user.userId;
	    		   UserMenu.viewUserMenu();
	    		   return;
	    		}
	    	}
	    	System.out.println("Your UserName or PIN is not found ! please register or try again");
	    }
}
