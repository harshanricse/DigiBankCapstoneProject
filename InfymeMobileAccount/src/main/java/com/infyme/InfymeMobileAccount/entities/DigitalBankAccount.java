package com.infyme.InfymeMobileAccount.entities;

import org.antlr.v4.runtime.misc.NotNull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DigitalBankAccount {
	@Id
	private String digitalBankingId;
	@NotNull
	private long mobileNumber;
	
	@ManyToOne
	@JoinColumn(name = "accountNumber")
	private  BankAccount bankAcc;
	@NotNull
	private String accountType;
	public String getDigitalBankingId() {
		return digitalBankingId;
	}
	public void setDigitalBankingId(String digitalBankingId) {
		this.digitalBankingId = digitalBankingId;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public BankAccount getBankAcc() {
		return bankAcc;
	}
	public void setBankAcc(BankAccount bankAcc) {
		this.bankAcc = bankAcc;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
