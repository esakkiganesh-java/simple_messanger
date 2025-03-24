package com.simplemessenger.usermanager;

public interface UserLoginService {
	
   public void getLoginDetails();
   public boolean validateLoginDetails(String username, int PIN);
 
}
