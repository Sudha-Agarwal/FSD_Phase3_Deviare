package withDI;

public class WhatAppMessaging implements Messaging{

	public void sendMessage(String message) {
		System.out.println("Sending WhatsApp " + message);		
		
	}
	

}
