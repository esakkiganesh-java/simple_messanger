package com.simplemessenger.usermanager;

public class UserData {
	    public int userId;
	    public String userName;
	    int userPIN;
	    public static String LOGGED_USER;
	    public static int LOGGED_USERID;
	    static int idCounter = 0;
	    public UserData(String userName,int userPIN) {
	    	this.userId = ++idCounter;
	    	this.userName = userName;
	    	this.userPIN = userPIN;
	    }
	    public UserData() {
	    	
	    }
	    public void setLOGGED_USER(String LOGGED_USER) {
	    	this.LOGGED_USER = LOGGED_USER;
	    }
	    public void setLOGGED_USERID(int LOGGED_USERID) {
	    	this.LOGGED_USERID = LOGGED_USERID;
	    }
	    int getUserPIN() {
	    	return userPIN;
	    }
	    public int getUserId() {
	    	return userId;
	    }
	    public int getIdCounter() {
	    	return idCounter;
	    }
	    public String getUserName() {
	    	return userName;
	    }
	    public String getLOGGED_USER() {
	    	return LOGGED_USER;
	    }
	    public int getLOGGED_USERID() {
	    	return LOGGED_USERID;
	    }
}
