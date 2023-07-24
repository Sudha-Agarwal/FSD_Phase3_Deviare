package withDI;

public class EmailMessaging implements Messaging{
	String recepient;
	public EmailMessaging(String recepient) {
		
		
	}
	
	public void sendMessage(String message) {
		System.out.println("Sending email message: " + message);		
	}

}
