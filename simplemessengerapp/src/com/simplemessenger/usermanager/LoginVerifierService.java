package com.simplemessenger.usermanager;

public interface LoginVerifierService {
	
     boolean validateLoginDetails(String userName,int userPIN);
}
