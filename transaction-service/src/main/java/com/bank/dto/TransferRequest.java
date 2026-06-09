package com.bank.dto;

import lombok.Data;

@Data
public class TransferRequest {
	
	private String fromAccount;
	private String toaccount;
	private Double amount;

}
