package com.bank.dto;

import lombok.Data;

@Data
public class AccountResponse {
	
	private Long accountId;
	private Long userId;
	private String accountNumber;
	private String phone;
	private String accountType;
	private Double balance;
	private String status;

}
