package com.bank.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.bank.dto.NotificationEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationProducer {
	
	private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;
	
	public void publish(NotificationEvent event) {
		
		kafkaTemplate.send("bank-notifications",event);
	}

}
