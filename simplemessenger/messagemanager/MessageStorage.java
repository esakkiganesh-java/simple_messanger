package com.simplemessenger.messagemanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageStorage {
	
    public static Map<Integer,List<MessageData>> userMessages = new HashMap<>();
    
    public static Map<Integer,List<MessageData>> pastMessages = new HashMap<>();
    
    public Map<Integer,List<MessageData>> getUserMessages(){
    	return userMessages;
    }
    public Map<Integer,List<MessageData>> getPastMessages(){
    	return pastMessages;
    }
}
