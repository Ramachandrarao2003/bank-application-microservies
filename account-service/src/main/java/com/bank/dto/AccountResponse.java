package com.bank.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponse {
	
	private Long accountId;
	private Long userId;
	private String customerName;
	private String accountNumber;
	private String phone;
	private String accountType;
	private Double balance;
	private String status;
	private LocalDateTime createdAt;

}
