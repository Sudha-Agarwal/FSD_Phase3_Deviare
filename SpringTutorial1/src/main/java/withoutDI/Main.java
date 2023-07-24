package withoutDI;

public class Main {

	public static void main(String[] args) {
		MessagingApp messagingApp = new MessagingApp();
		
		messagingApp.sendEmailMessage("Hello! this is an email");
		messagingApp.sendSMSMessage("Hello! This is an sms");
		

	}

}
