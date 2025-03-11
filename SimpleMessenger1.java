package esakkiganesh;
import java.util.*;
import java.util.ArrayList;

class User{
     int userId;
	 String userName;
     int PIN;
    static int idCounter;
	static String loggedUser ;
	static int loggedUserID;
	static List<User> userList = new ArrayList<>();
	   
		public User(String userName,int PIN) {
		this.userId = ++idCounter;
		this.userName = userName;
		this.PIN = PIN;
	}
}
class Login{
	static Scanner scanner = new Scanner(System.in);
	static void login() {
		System.out.println(" Note : Enter the correct required user details for login!");
		System.out.println("Enter the username : ");
		String userName = scanner.next();
		System.out.println("Enter the PIN : ");
		int PIN = scanner.nextInt();
		for(User user: User.userList) {
			if(user.userName.equals(userName)&&user.PIN == PIN) {
			   User.loggedUser = userName;
			   User.loggedUserID = user.userId;
			   System.out.println("Login Successfully!");
			   UserMenu.userMenu();
			   return;
			}
		}
		System.out.println("username or PIN is not found try Again");
		
	}
}
class Register{
	static Scanner scanner = new Scanner(System.in);
    static void register() {
		System.out.println("**Register for User**");
		System.out.println("Note: Please Enter the valid User deatils!");
		System.out.println("Enter your username : ");
		String userName = scanner.next();
		System.out.println("Set PIN : ");
		int setPIN = scanner.nextInt();
		System.out.println("Confirm PIN : ");
		int confirmPIN = scanner.nextInt();
		if(setPIN == confirmPIN) {
		   User.userList.add(new User(userName,setPIN));
		   Inbox.messageList.add(new ArrayList<>());
		   System.out.println("User Registered Successfully!");
		}
		else {
			System.out.println("Your PIN's doesn't Match Try again");
		}	   
     }
   }
class UserMenu{
	static Scanner scanner = new Scanner(System.in);
	static Messenger messenger = new Messenger();
	static void userMenu() {
	   while(true) {
		   System.out.println("1.Message");
		   System.out.println("2.Inbox");
		   System.out.println("3.Message History");
		   System.out.println("4.logout");
		   System.out.println("Enter your choice : ");
		   int choice = scanner.nextInt();
		   switch(choice) {
		        case 1 :
		        	messenger.sendMessage();
		        	break;
		        case 2 :
		        	messenger.viewInbox();
		        	break;
		        case 3 :
		        	messenger.messageHistory();
		        	break;
		        case 4 :
		        	System.out.println("Logging out...!");
		        	User.loggedUser = null;
		        	User.loggedUserID = -1;
		        	return;
		        default :
		        	System.out.println("Invalid option! try again");
		   }
	   }
	}
}
interface MessengerFunctionality{
	 void sendMessage();
	 void viewInbox() ;
	 void messageHistory();
}
class Messenger implements MessengerFunctionality{

	@Override
	public  void sendMessage() {
		// TODO Auto-generated method stub
		SendMessage.sendMessage();
	}

	@Override
	public void viewInbox() {
		// TODO Auto-generated method stub
		ViewInbox.viewInbox();
	}

	@Override
	public void messageHistory() {
		// TODO Auto-generated method stub
		MessageHistory.messageHistory();
	}
	
}
class SendMessage{
	static Scanner scanner = new Scanner(System.in);
	@SuppressWarnings("static-access")
	static void sendMessage() {
		System.out.println("Enter the UserId for send Message : ");
		int userID = scanner.nextInt();
		for(User user: User.userList) {
			if(user.userId == userID) {
				System.out.println("Enter the Message : ");
				String messageContent = scanner.nextLine();
				scanner.nextLine();
				String receiverName = user.userName;
				Inbox.messageList.get(userID-1).add(new Inbox(receiverName,messageContent,User.loggedUser));
				System.out.println("Message sent..!");
				return;
			}
		}
		System.out.println("userID not found! please enter a Valid userID");
	}
}
class Inbox {
	static List<List<Inbox>> messageList = new ArrayList<>();
	String receiverName;
	String messageContent;
	String senderName;
	
	public Inbox(String receiverName, String messageContent,String senderName) {
		this.receiverName = receiverName;
		this.messageContent = messageContent;
		this.senderName = senderName;
	} 
	
}
class ViewInbox{
	static void viewInbox() {
	   System.out.println(User.loggedUser+" your Inbox Messages : ");
	   if(Inbox.messageList.isEmpty()) {
		   System.out.println("No new Messages");
		   return;
	   }
	   else if(Inbox.messageList.get(User.loggedUserID-1).isEmpty()) {
		  System.out.println("No new Messages!");
		  return;
	   }
	   else {
		  for(int i = 0; i <  Inbox.messageList.get(User.loggedUserID-1).size(); i++) {
			  System.out.println(Inbox.messageList.get(User.loggedUserID-1).get(i).receiverName+" : < "+Inbox.messageList.get(User.loggedUserID-1).get(i).messageContent+" > send by "+Inbox.messageList.get(User.loggedUserID-1).get(i).senderName);
		  }
	   }
	}
}
class MessageHistory{
	static void messageHistory() {
		if(Inbox.messageList.isEmpty()) {
			System.out.println("No new Messages");
			 return;
		}
		for(int i = 0; i < Inbox.messageList.size(); i++) {
			if(Inbox.messageList.get(i).isEmpty()) {
				System.out.println(User.userList.get(i).userName+" have no new Messages");
				continue;
			}
			for(int j = 0; j < Inbox.messageList.get(i).size(); j++) {
				System.out.println(Inbox.messageList.get(i).get(j).receiverName+" : < "+Inbox.messageList.get(i).get(j).messageContent+" > send by "+Inbox.messageList.get(i).get(j).senderName);
			}
		}
		 
	}
}
public class SimpleMessenger1 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner scanner = new Scanner(System.in);
    while(true) {
    	System.out.println("|--Messenger--|");
    	System.out.println("1.Login");
    	System.out.println("2.Register");
    	System.out.println("3.Exit");
    	System.out.println("Enter your choice : ");
    	int choice = scanner.nextInt();
    	switch(choice) {
    	    case 1 :
    	    	Login.login();
    	    	break;
    	    case 2 :
    	    	Register.register();
    	    	break;
    	    case 3 :
    	    	System.out.println("Exiting...");
    	    	return ;
    	    default :
    	    	System.out.println("Invalid option! try again");
    	    	break;
    	}
     }
    
   }
}
