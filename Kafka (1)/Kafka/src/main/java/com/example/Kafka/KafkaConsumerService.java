package com.example.Kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {
	
	@KafkaListener(topics = "test-topic2")
	public void readMessage(String message) {
		System.out.println("Received Message: " + message);
		
		
	}

}
