package withDI;

public class EmailMessaging implements Messaging{

	public void sendMessage(String message) {
		System.out.println("Sending email " + message);
		
	}
	

}
