package com.infyme.InfymeMobileAccount.services;

import com.infyme.InfymeMobileAccount.exceptions.InfymeMobileException;

public interface DigitalBankAccountService {
	String linkAccount(Long mobileNo, Long accountNo) throws InfymeMobileException;
	String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfymeMobileException;
	Double checkBalance(Long mobileNo, Long accountNo) throws InfymeMobileException;

}
