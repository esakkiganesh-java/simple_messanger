package com.simplemessenger;

import com.simplemessenger.usermanager.UserLogin;
import com.simplemessenger.usermanager.UserLoginService;
import com.simplemessenger.usermanager.UserRegisterService;
import com.simplemessenger.usermanager.UserRegister;
import java.util.Scanner;

public class SimpleMessenger {
	private static UserLoginService userLoginService;
	private static UserRegisterService userRegisterService;
	public SimpleMessenger(UserLogin userLoginService,UserRegister userRegisterService) {
		this.userLoginService = userLoginService;
		this.userRegisterService = userRegisterService;
	}

	public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     SimpleMessenger simpleMessenger = new SimpleMessenger(new UserLogin(),new UserRegister());
     simpleMessenger.showMenu(scanner);
     System.out.println("..Thank You..");
	}
	public void showMenu(Scanner scanner) {
		 while(true) {
	    	 System.out.println("[-^-Messenger-^-]");
	    	 System.out.println("1.Login");
	    	 System.out.println("2.Register");
	    	 System.out.println("3.Exit");
	    	 System.out.println("Enter your Choice : ");
	    	 int choice = scanner.nextInt();
	    	 switch(choice) {
	    	      case 1:{
	    	    	  userLoginService.getLoginDetails();
	    	    	  break;
	    	      }
	    	      case 2:{
	    	    	   userRegisterService.getUserDetails();
	    	    	  break;
	    	      }
	    	      case 3:{
	    	    	  System.out.println("Exiting..");
	    	    	  return ;
	    	      }
	    	      default:{
	    	    	  System.out.println("Invalid option try again!");
	    	    	  break;
	    	      }
	    	 }
	     }
	}

}


