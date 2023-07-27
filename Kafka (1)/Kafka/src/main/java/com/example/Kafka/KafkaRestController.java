package com.example.Kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaRestController {
	private final KafkaProducerService kafkaProducerService;
	
	@Autowired
	KafkaRestController(KafkaProducerService kafkaProducerService)
	{
		this.kafkaProducerService = kafkaProducerService;
	}
	
	@GetMapping("/send/{topic}/{message}")
	public String sendMessage(@PathVariable String topic, @PathVariable String message) {
		kafkaProducerService.sendMessage(topic, message);
		return "Message Sent to Kafka Topic: " + topic;
	}
		
	

}
