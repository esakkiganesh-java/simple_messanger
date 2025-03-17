package com.simplemessenger.main;
import com.simplemessenger.usermanager.UserLogin;
import com.simplemessenger.usermanager.UserRegister;

import java.util.Scanner;

public class SimpleMessenger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner scanner = new Scanner(System.in);
     while(true) {
    	 System.out.println("|..Messenger..|");
    	 System.out.println("1.Login");
    	 System.out.println("2.Register");
    	 System.out.println("3.Exit");
    	 System.out.println("Enter your Choice : ");
    	 int choice = scanner.nextInt();
    	 switch(choice) {
    	      case 1:
    	    	  UserLogin.login();
    	    	  break;
    	      case 2:
    	    	   UserRegister.register();
    	    	  break;
    	      case 3:
    	    	  System.out.println("Exiting..");
    	    	  return ;
    	      default:
    	    	  System.out.println("Invalid option try again!");
    	    	  break;
    	 }
     }
	}

}


