package com.infyme.InfymeMobileAccount.entities;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	@Id
	private Integer transactionId;
	@NotNull
	private String modeOfTransaction;
	@NotNull
	private Long paidTo;
	@NotNull
	private Long receiverAccountNumber;
	@NotNull
	private Double amount;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime transactionDateTime;
	@NotNull
	private String remarks;
	@NotNull
	private Long paidFrom;
	@NotNull
	private Long senderAccountNumber;
	public Integer getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Integer transactionId) {
		this.transactionId = transactionId;
	}
	public String getModeOfTransaction() {
		return modeOfTransaction;
	}
	public void setModeOfTransaction(String modeOfTransaction) {
		this.modeOfTransaction = modeOfTransaction;
	}
	public Long getPaidTo() {
		return paidTo;
	}
	public void setPaidTo(Long paidTo) {
		this.paidTo = paidTo;
	}
	public Long getReceiverAccountNumber() {
		return receiverAccountNumber;
	}
	public void setReceiverAccountNumber(Long receiverAccountNumber) {
		this.receiverAccountNumber = receiverAccountNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getPaidFrom() {
		return paidFrom;
	}
	public void setPaidFrom(Long paidFrom) {
		this.paidFrom = paidFrom;
	}
	public Long getSenderAccountNumber() {
		return senderAccountNumber;
	}
	public void setSenderAccountNumber(Long senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}
	

}
