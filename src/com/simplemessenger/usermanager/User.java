package com.simplemessenger.usermanager;

public class User {
	  public int userId;
	    public String userName;
	    int userPIN;
	    public static String LOGGED_USER;
	    public static int LOGGED_USERID;
	    static int idCounter;
	    public User(String userName,int userPIN) {
	    	this.userId = ++idCounter;
	    	this.userName = userName;
	    	this.userPIN = userPIN;
	    }
}
