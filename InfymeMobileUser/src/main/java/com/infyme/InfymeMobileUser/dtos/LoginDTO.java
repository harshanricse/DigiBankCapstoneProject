package com.infyme.InfymeMobileUser.dtos;

import lombok.Getter;
import lombok.Setter;

public class LoginDTO {
	private long mobileNumber;
	private String password;
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
