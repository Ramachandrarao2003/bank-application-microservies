package com.bank.entity;

import java.time.LocalDateTime;

import com.bank.enums.AccountStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
	
	@Id
	@SequenceGenerator(name="account_seq",sequenceName="ACCOUNT_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "account_seq",strategy = GenerationType.SEQUENCE)
	private Long accountId;
	private Long userId;
	private String customerName;
	@Column(unique = true)
	private String accountNumber;
	private String phone;
	private String accountType;
	private Double balance;
	@Enumerated(EnumType.STRING)
	private AccountStatus status;
	private LocalDateTime createdAt;

}
