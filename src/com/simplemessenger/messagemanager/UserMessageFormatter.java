package com.simplemessenger.messagemanager;

import java.util.Scanner;

public class UserMessageFormatter {
	static Scanner scanner = new Scanner(System.in);
    public String receiverName;
    public String messageContent;
    public String senderName;
    public UserMessageFormatter(String receiverName,String messageContent,String senderName) {
    	this.receiverName = receiverName;
    	this.messageContent = messageContent;
    	this.senderName = senderName;
    }
}