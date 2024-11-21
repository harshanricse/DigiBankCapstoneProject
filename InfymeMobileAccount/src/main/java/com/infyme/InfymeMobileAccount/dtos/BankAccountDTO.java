package com.infyme.InfymeMobileAccount.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class BankAccountDTO {
	
	@Min(value=2, message = "{bankaccount.accountnumber.invalid}")
	@NotNull(message = "{bankaccount.accountnumber.must}")
	private long accountNumber;
	@NotNull(message = "{bankaccount.bankname.must}")
	@Size(min=5, max=15, message = "{bankaccount.bankname.invalid}")
	private String bankName;
	@Positive
	private Double balance;
	@NotNull(message = "{bankaccount.accounttype.must}")
	@Size(min=1, max=10, message = "{bankaccount.accounttype.invalid}")
	private String accountType;
	@NotNull(message = "{bankaccount.ifsccode.must}")
	@Size(min=1, max=15, message = "{bankaccount.ifsccode.invalid}")
	private String ifscCode;
	@Past
	private LocalDate openingDate;
	@NotNull(message = "{bankaccount.mobilenumber.must}")
	@Min(value=10, message = "{bankaccount.mobilenumber.invalid}")
	@Max(value=10, message = "{bankaccount.mobilenumber.invalid}")
	private Long mobileNumber;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public LocalDate getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(LocalDate openingDate) {
		this.openingDate = openingDate;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
