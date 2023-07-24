package withoutDI;

public class Main {
	
	public static void main(String[] args) {
		Messaging emailMessaging = new EmailMessaging("abc@gmail.com");
		
		Messaging smsMessaging = new SMSMessaging();
		
		emailMessaging.sendMessage("Hello! this is an email message");
		smsMessaging.sendMessage("Hello! This is an SMS message");
		
	}

}
