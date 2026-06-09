package com.bank.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountRequest {
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String accountType;
	@NotBlank
	private Double balance;

}
