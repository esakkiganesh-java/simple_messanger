package com.simplemessenger.pastmessagesmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.simplemessenger.messagemanager.UserMessageFormatter;

public class PastMessageStorage {
	 public static Map<Integer,List<UserMessageFormatter>>  pastMessages = new HashMap<>();
}
