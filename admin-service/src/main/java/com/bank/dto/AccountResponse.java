package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountResponse {
	
	private Long accountId;
	private Long userId;
	private String customerName;
	private String accountNumber;
	private String phone;
	private String accountType;
	private Double balance;
	private String status;

}
