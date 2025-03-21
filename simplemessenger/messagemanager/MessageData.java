package com.simplemessenger.messagemanager;

public class MessageData {
    public String receiverName;
    public String messageContent;
    public String senderName;
    public MessageData(String receiverName,String messageContent,String senderName) {
    	this.receiverName = receiverName;
    	this.messageContent = messageContent;
    	this.senderName = senderName;
    }
}