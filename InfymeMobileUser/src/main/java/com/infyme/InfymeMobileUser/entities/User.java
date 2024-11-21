package com.infyme.InfymeMobileUser.entities;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity(name="user")
public class User {
	@Id 
	@Min(value = 10)
	@Max(value = 10)
	Long mobileNumber;
	@Column(unique = true)
	@Pattern(regexp = "^[U]")    
	String userId;
	@NotNull
	@Size(min =3, max=50)
	String accountHolderName;
	@NotNull
	@Pattern(regexp = "?:Male|Female$")
	String gender;
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull
	LocalDate dateOfBirth;
	@NotNull
	@Size(min=5, max=10)
	@Pattern(regexp="^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")
	String password;
	@NotNull
	@Email
	String email;
	@NotNull
	@Size(min=3, max=50)
	String communicationAddress;
	@NotNull
	String PAN;
	
	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommunicationAddress() {
		return communicationAddress;
	}

	public void setCommunicationAddress(String communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	@Override
	public String toString() {
		return "User [mobileNumber=" + mobileNumber + ", userId=" + userId + ", accountHolderName=" + accountHolderName
				+ ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", password=" + password + ", email=" + email
				+ ", communicationAddress=" + communicationAddress + ", PAN=" + PAN + "]";
	}
	

}
