package com.simplemessenger.usermanager;

public interface UserRegisterService {
    
	public void getUserDetails();
	public boolean checkValidUserName(String userName);
	public boolean verifyUserRegisteration(String userName,int setPIN,int confirmPIN);
	public void register(String userName,int confirmPIN);
	
}
