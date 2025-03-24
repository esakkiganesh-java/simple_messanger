package com.simplemessenger.messagemanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageStorage {
	//To Store the User messages in hashMap key = UserId , value = inbox messages
    public static Map<Integer,List<MessageData>> userMessages = new HashMap<>();
    
    //To store the User past messages in hashMap key = UserId, value -= User  sent messages
    public static Map<Integer,List<MessageData>> pastMessages = new HashMap<>();
    
    public Map<Integer,List<MessageData>> getUserMessages(){
    	return userMessages;
    }
    public Map<Integer,List<MessageData>> getPastMessages(){
    	return pastMessages;
    }
}
