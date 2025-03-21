package com.simplemessenger.messagemanager;

public interface UserMessageService {

	 public void getReceiverDetails();
	 public boolean  verifyReceiverDetails(String receiverName);
	 public void getMessageContent(String receiverName,int receiverId);
	 public void sendMessage(String receiverName,int receiverId,String messageContent);
	 
}
