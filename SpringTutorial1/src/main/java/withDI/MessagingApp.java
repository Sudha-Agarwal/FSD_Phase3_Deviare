package withDI;

public class MessagingApp {
	Messaging emailmessaging;
	Messaging smsMessaging;	
	
	
	//constructor dependency injection
	MessagingApp(Messaging emailMessaging, Messaging smsMessaging){
		this.emailmessaging = emailMessaging;
		this.smsMessaging = smsMessaging;		
		//this.emailmessaging = new EmailMessaging();
		//this.smsMessaging = new SMSMessaging();
	}
	
	public void sendEmailMessage(String message) {
		emailmessaging.sendMessage(message);
		
	}
	
	public void sendSMSMessage(String message) {
		smsMessaging.sendMessage(message);
	}
	

}
