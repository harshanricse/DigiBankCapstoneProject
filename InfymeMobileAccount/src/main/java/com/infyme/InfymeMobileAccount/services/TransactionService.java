package com.infyme.InfymeMobileAccount.services;

import java.util.List;

import com.infyme.InfymeMobileAccount.dtos.TransactionDTO;
import com.infyme.InfymeMobileAccount.exceptions.InfymeMobileException;

public interface TransactionService {
	public String fundTransfer(TransactionDTO transactionDTO) throws InfymeMobileException;
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfymeMobileException;
}
