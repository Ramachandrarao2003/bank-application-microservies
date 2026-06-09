package com.bank.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {
	
	private Long transactionId;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	private String transactionType;
	private String status;
	private String description;
	private LocalDateTime transactionDate;

}
