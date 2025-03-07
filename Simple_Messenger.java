package esakkiganesh;
import java.util.ArrayList;
import java.util.*;
class User{
	String user_name;
	int pin;
	int user_id;
	public User(String user_name,int pin){
		Simple_Messenger.id_num++;
		this.user_name = user_name;
		this.pin = pin;
		this.user_id = Simple_Messenger.id_num;
	}
}
class inbox{
	 String sender_name;
	 String Message;
	 public inbox(String sender_name,String message) {
		 this.Message = message;
		 this.sender_name = sender_name;
	 }
}

public class Simple_Messenger {
    static List<User> user_list = new ArrayList<>();
    static List<List<inbox>> Inbox = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int id_num = 0;
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		
 	 user_list.add(new User("Henry",1));
 	 user_list.add(new User("Josh",2));
 	 user_list.add(new User("Lisa",3));
 	 user_list.add(new User("Rob",4));
 	 for(User usr : user_list) {
 		 System.out.println("User id:"+usr.user_id+" user:"+usr.user_name+" pin :"+usr.pin);
 	 }
 	 outer:
 	 while(true) {
     System.out.println("..Messenger..");
     System.out.println("1.login");
     System.out.println("2.Register");
     System.out.println("3.Exit");
     System.out.println("Enter your option :");
     int opt = sc.nextInt();
         switch(opt) {
             case 1:
                login();
                break;
             case 2:
        	    Register();
        	    break;
             default :
            	System.out.println("Exiting.../invalid option");
        	    break outer;
          
        }
     }
     
   }
   public static void Register() {
	   System.out.println("Register for a new User");
	   System.out.println("Please Enter Valid details");
	   System.out.println("Enter your user name:");
	   String name = sc.next();
	   System.out.println("Set your Pin:");
	   int pin = sc.nextInt();
	   System.out.println("Confirm your pin:");
	   int pin1 = sc.nextInt();
	   if(pin == pin1) {
		   user_list.add(new User(name,pin));
		   System.out.println("User Registered Successfully!");
		   for(User usr : user_list) {
		 		 System.out.println("User id:"+usr.user_id+" user:"+usr.user_name+" pin :"+usr.pin);
		 	 }
	   }
	   else {
		   System.out.println("Your pins doesn't Match Try again!");
	   }
	   
   }
   public static  void login() {
	   System.out.println("Enter the User login details");
	   System.out.println("Enter the User Name : ");
	   String log_name = sc.next();
	   System.out.println("Enter the pin :");
	   int log_pin = sc.nextInt();
	   for(User user: user_list) {
		   if(user.user_name.equals(log_name)) {
			   if(user.pin == log_pin) {
				  System.out.println("Login Successfully!");
				  System.out.println("1.send Message");
				  System.out.println("2.inbox");
				  System.out.println("3.Message History");
				  System.out.println("4.Exit");
				  System.out.println("Enter Your Choice : ");
				  int opt = sc.nextInt();
				    switch (opt) {
				         case 1:
				        	 send_message(log_name);
				        	 break;
				         case 2:
				        	 inbox_messages(log_name);
				        	 break;
				         case 3:
				        	 Message_history();
				        	 break;
				         default :
				        	 System.out.println("Exit/Go to Home page");
				    }
			   }
			   else {
				   System.out.println("Incorrect pin try again!");
			   }
		   }
	   }
   }
   public static void send_message(String name) {
	   System.out.println("Enter the User_id for send Message :");
	   int id = sc.nextInt();
	   if(id >= Inbox.size()) {
	       for(int i = Inbox.size();i < user_list.size(); i++) {
		        Inbox.add(new ArrayList<>());
	       }
	   }
	   String s = "";
	   for(User usr : user_list) {
	 	   if(usr.user_id == id) {
	 		   s = usr.user_name;
	 	       System.out.println("Enter your Message :");
	 	       String msg = sc.next();
	 		   Inbox.get(id-1).add(new inbox(name,msg));
	 		   System.out.println("sent..");
	 	   }
	   }
	   
	   
   }
   public static void inbox_messages(String name) {
	   System.out.println(name+" your inbox Messages");
	   int ref_id = 0;
	   String rec_name = "";
	   for(User usr: user_list) {
		   if(usr.user_name.equals(name)) {
			  ref_id = usr.user_id;
			  rec_name = usr.user_name;
			  break;
		   }
	   }
	  // System.out.println("ref_id  = "+ref_id);
	   if(Inbox.isEmpty()) {
		   System.out.println("No new Messages!");
		   return;
	   }
	   else if(Inbox.get(ref_id-1).isEmpty()) {
		   System.out.println("No new Messages!");
		   return;
	   }
	   for(int i = 0;i < Inbox.get(ref_id-1).size(); i++) {
		   System.out.println(rec_name+": "+(Inbox.get(ref_id-1).get(i)).Message+"! by < @" +(Inbox.get(ref_id-1).get(i)).sender_name+">");
	   }
	   
   }
   public static void Message_history() {
	   if(Inbox.isEmpty()) {
		   System.out.println("No Messages so far!");
	   }
	   else {
		   for(int k = 0; k < Inbox.size();k++) {
			   String s = user_list.get(k).user_name;
			   if(Inbox.get(k).isEmpty()) {
				   System.out.println("User : "+s+" have no Messages so far");
				   continue;
			   }
			   for(int j = 0; j < Inbox.get(k).size();j++) {
				   System.out.println(s+":"+Inbox.get(k).get(j).Message+"! by < @"+Inbox.get(k).get(j).sender_name+"> ");
			   }
		   }
	   }
   }

}
