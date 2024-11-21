package com.infyme.InfymeMobileAccount.dtos;

public class LinkAccountDTO {
	private Long accountNo;
	private Integer otp;
	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public Integer getOtp() {
		return otp;
	}
	public void setOtp(Integer otp) {
		this.otp = otp;
	}

}
