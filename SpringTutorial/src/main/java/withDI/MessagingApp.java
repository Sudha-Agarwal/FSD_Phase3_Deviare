package withDI;

public class MessagingApp {
	Messaging emailMessaging;
	Messaging smsMessaging;
	
	
	//contructor injection
	public MessagingApp(Messaging emailMessaging, Messaging smsMessaging) {
		this.emailMessaging = emailMessaging;
		this.smsMessaging = smsMessaging;		
	}
	
	public void sendEmailMessage(String message) {
		this.emailMessaging.sendMessage(message);
	}
	
	

}
