package esakkiganesh;
import java.util.ArrayList;
import java.util.*;

interface MessageFunctions{
	void sendMessage(int receiverId,String receiverName,String messageContent,String senderName);
	void viewInbox();
	void viewMessageHistory();
}
class User{
	private int userId;
	private String userName;
	private int PIN;
	private static int idCounter;
	
	public User(String userName,int PIN) {
		this.userId = ++idCounter;
		this.userName = userName;
		this.PIN = PIN;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public int getPIN() {
		return PIN;
	}
}
class Message{
	 String messageContent;
	 String senderName;
	 String receiverName;
	 
	public Message(String receiverName, String messageContent, String loggedUser) {
		this.receiverName = receiverName;
		 this.messageContent = messageContent;
		 this.senderName = loggedUser;
	}
}
class Messenger implements MessageFunctions{
    private static List<User> userList = new ArrayList<>();
    private static List<List<Message>> msgList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private String loggedUser;
    private int loggedUserID;
  
	
	public static void register() {
		System.out.println("**New User register your Profile**");
		System.out.println("Enter Your userName : ");
		String userName = scanner.next();
		System.out.println("Set PIN : ");
		int setPIN = scanner.nextInt();
		System.out.println("Confirm your PIN : ");
		int confirmPIN = scanner.nextInt();
		if(setPIN == confirmPIN) {
			userList.add(new User(userName,setPIN));
			System.out.println("User Registered Successfully!");
		}
		else {
			System.out.println("Your setPIN doesn't Match confirmPIN try again");
		}
		
		
	}
	public void login() {
		System.out.println("Enter the Valid User details for Login");
		System.out.println("Enter the correct username :");
		String userName = scanner.next();
		System.out.println("Enter the PIN : ");
		int PIN = scanner.nextInt();
		for(User user : userList) {
			if(user.getUserName().equals(userName)&&user.getPIN() ==  PIN) {
				System.out.println("Login Successfully ! ");
				loggedUser = userName;
				loggedUserID = user.getUserId();
				userMenu();
				return;
			}
		}
		System.out.println("Your username or PIN is incorrect! try Again");
	}
	
	public void userMenu() {
		while(true) {
			System.out.println("1.send Message");
			System.out.println("2.inbox");
			System.out.println("3.Message History");
			System.out.println("4.Logout");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();
			switch(choice) {
			      case 1:
			    	  sendMessageFlow();
			    	  break;
			      case 2:
			    	  viewInbox();
			    	  break;
			      case 3:
			    	  viewMessageHistory();
			    	  break;
			      case 4:
			    	  System.out.println("Logout Successfully!");
			    	  loggedUser = null;
			    	  loggedUserID = -1;
			    	  return;
			      default :
			    	  System.out.println("Please Enter Valid option only!");
			}
		}
	}
	public void sendMessageFlow() {
		System.out.println("Enter the receiverId for send a Message : ");
		int receiverId = scanner.nextInt();
		for(int i = msgList.size(); i < userList.size(); i++) {
			msgList.add(new ArrayList<>());
		}
		for(User user: userList) {
			if(user.getUserId() == receiverId) {
			   String receiverName = user.getUserName();
			   System.out.println("Enter the Message : ");
			   String messageContent = scanner.next();
			   sendMessage(receiverId,receiverName,messageContent,loggedUser);
			   return ;
			}
		}
		System.out.println("ReceiverID not found");	
	}
	@Override
	public void sendMessage(int receiverId,String receiverName,String messageContent,String senderName) {
		msgList.get(receiverId-1).add(new Message(receiverName,messageContent,senderName));
		System.out.println("Message sent..");
	}

	@Override
	public void viewInbox() {
		System.out.println(loggedUser+" Your Inbox Messages");
		if(msgList.isEmpty()) {
			System.out.println("No new Messages");
			return;
		}
		if(msgList.get(loggedUserID-1).isEmpty()) {
			System.out.println("No new Messages");
			return;
		}
		for(int i = 0; i < msgList.size();i++) {
			for(int j = 0; j < msgList.get(i).size(); j++) {
				if( i == loggedUserID -1) {
					System.out.println(msgList.get(i).get(j).receiverName+" : < "+msgList.get(i).get(j).messageContent+" > send by "+msgList.get(i).get(j).senderName);
				}
			}
		}
	}

	@Override
	public void viewMessageHistory() {
		// TODO Auto-generated method stub
	System.out.println("Message History");
	if(msgList.isEmpty()) {
		System.out.println("No new Messages");
	}
	for(int i = 0; i < msgList.size();i++) {
		if(msgList.get(i).isEmpty()) {
		   System.out.println("No new Messages");
		   continue;
		}
		for(int j = 0; j < msgList.get(i).size(); j++) {
				System.out.println(msgList.get(i).get(j).receiverName+" : < "+msgList.get(i).get(j).messageContent+" > send by"+msgList.get(i).get(j).senderName);
		}
	}
	
    }
}
public class SimpleMessenger {
	static private int logIdCounter;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Messenger messenger = new Messenger();
		
		while(true) {
			System.out.println("..Messenger..");
			System.out.println("1.login");
			System.out.println("2.Register");
			System.out.println("3.Exit");
			System.out.println("Enter Your choice :");
			int choice = scanner.nextInt();
			switch(choice) {
			   case 1:
				   messenger.login();
				 break;
			   case 2:
				   messenger.register();
				 break;
			   case 3:
				   System.out.println("Exiting...");
				   return;
			   default :
				   System.out.println("Invalid option try again!");
				
			}
		}
		
	}

}
