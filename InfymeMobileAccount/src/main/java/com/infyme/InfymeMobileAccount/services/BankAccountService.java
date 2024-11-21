package com.infyme.InfymeMobileAccount.services;

import java.util.List;

import com.infyme.InfymeMobileAccount.dtos.BankAccountDTO;
import com.infyme.InfymeMobileAccount.exceptions.InfymeMobileException;

public interface BankAccountService {
	String createAccount(BankAccountDTO accountDTO);
	List<BankAccountDTO> listAccounts(Long mobileNo) throws InfymeMobileException;
}
