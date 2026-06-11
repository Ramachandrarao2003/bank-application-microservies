package com.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {
	
	private Integer totalUsers;
	private Integer totalAccounts;
	private Integer totalTransactions;
	private Double totalBalance;

}
