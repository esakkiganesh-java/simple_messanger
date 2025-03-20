package com.simplemessenger.messagemanager;

public class UserMessageFormatter {
    public String receiverName;
    public String messageContent;
    public String senderName;
    public UserMessageFormatter(String receiverName,String messageContent,String senderName) {
    	this.receiverName = receiverName;
    	this.messageContent = messageContent;
    	this.senderName = senderName;
    }
}