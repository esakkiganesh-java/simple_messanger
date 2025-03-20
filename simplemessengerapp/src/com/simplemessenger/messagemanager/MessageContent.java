package com.simplemessenger.messagemanager;

import java.util.Scanner;

public class MessageContent {
	//To get a MessageContent from a User
	MessageSenderService messageSenderService = new MessageSender();
	Scanner scanner = new Scanner(System.in);
	public void getMessageContent(String receiverName,int receiverId) {
		System.out.println("Enter the messageContent: ");
		String messageContent = scanner.nextLine();
		messageSenderService.sendMessage(receiverName,receiverId,messageContent);
	}
}
