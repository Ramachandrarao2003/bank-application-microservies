package com.bank.entity;

import java.time.LocalDateTime;

import com.bank.enums.TransactionStatus;
import com.bank.enums.TransactionType;

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
@Table(name = "BANK_TRANSACTIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
	
	@Id
	@SequenceGenerator(name = "txn_seq",sequenceName = "TXN_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "txn_seq",strategy = GenerationType.SEQUENCE)
	private Long transactionId;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	@Enumerated(EnumType.STRING)
	private TransactionType transactionType;
	@Enumerated(EnumType.STRING)
	private TransactionStatus status;
	private String description;
	private LocalDateTime transactionDate;

}
