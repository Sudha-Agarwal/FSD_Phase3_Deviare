package withDI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public Messaging emailMessaging() {
		return new EmailMessaging();
	}
	
	@Bean
	public Messaging smsMessaging() {
		return new SMSMessaging();
	}
	
	@Bean 
	public Messaging whatAppMessaging() {
		return new WhatAppMessaging();
	}
	
	@Bean
	public MessagingApp messagingApp() {
		return new MessagingApp(emailMessaging(), whatAppMessaging());
	}	

}
