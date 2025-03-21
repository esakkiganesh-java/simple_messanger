package com.simplemessenger.usermanager;

import java.util.ArrayList;
import java.util.List;

public class UserDataStorage {
	//To store the UserData's using userList
	public static List<UserData> userList = new ArrayList<>();
	
	public  List<UserData> getUserList(){
		return userList;
	}
 }

