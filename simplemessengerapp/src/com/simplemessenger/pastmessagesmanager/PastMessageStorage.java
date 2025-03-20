package com.simplemessenger.pastmessagesmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simplemessenger.messagemanager.UserMessageFormatter;

public class PastMessageStorage {
	//To store User past messages in map key = UserId , value = message details
	 public static Map<Integer,List<UserMessageFormatter>>  pastMessages = new HashMap<>();
	 
	 public Map<Integer,List<UserMessageFormatter>> getpastMessages(){
			return pastMessages;
	 }
}
