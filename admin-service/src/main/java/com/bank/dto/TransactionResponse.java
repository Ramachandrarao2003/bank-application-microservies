package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponse {
	
	private Long transactionId;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	private String transactionType;
	private String status;

}
