package withDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MessagingApp messagingApp = context.getBean(MessagingApp.class);
		
		messagingApp.sendEmailMessage("Hello! This is an email Message");
	}

}
