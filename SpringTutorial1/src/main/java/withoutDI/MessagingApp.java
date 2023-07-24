package withoutDI;

public class MessagingApp {
	Messaging emailmessaging;
	Messaging smsMessaging;	
	
	MessagingApp(){
		this.emailmessaging = new EmailMessaging();
		this.smsMessaging = new SMSMessaging();
	}
	
	public void sendEmailMessage(String message) {
		emailmessaging.sendMessage(message);
		
	}
	
	public void sendSMSMessage(String message) {
		smsMessaging.sendMessage(message);
	}
	

}
