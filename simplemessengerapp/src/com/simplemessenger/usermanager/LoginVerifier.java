package com.simplemessenger.usermanager;

public class LoginVerifier implements LoginVerifierService{
    UserDataStorage userDataStorage = new UserDataStorage();
    LoginUpdateServices loginUpdateServices = new LoginUpdates();
	@Override
	//To verify the User Data's are found in the userList or not
	public boolean validateLoginDetails(String userName,int userPIN) {
		for(UserData user: userDataStorage.getUserList()) {
    		if(user.userName.equalsIgnoreCase(userName)&&user.getUserPIN() == userPIN) {
    		   System.out.println("Login Successfully!");
    		   loginUpdateServices.updateLoginDetails(userName,user.getUserId());
    		   return true;
    		}
    	}
	 return false;
	}

}
