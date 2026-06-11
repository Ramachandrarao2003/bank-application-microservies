package com.bank.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.bank.dto.NotificationEvent;
import com.bank.service.EmailService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
	
	private final EmailService emailService;
	
	@KafkaListener(topics = "bank-notifications",groupId = "notification-group")
	public void consume(NotificationEvent event) {
		
		log.info("Message Received {}",event);
		
		emailService.sendEmail(event.getEmail(),
								event.getSubject(),
								event.getMessage());
	}

}
