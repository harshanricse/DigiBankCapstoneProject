package com.infyme.InfymeMobileAccount.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infyme.InfymeMobileAccount.dtos.BankAccountDTO;
import com.infyme.InfymeMobileAccount.entities.BankAccount;
import com.infyme.InfymeMobileAccount.exceptions.InfymeMobileException;
import com.infyme.InfymeMobileAccount.repositories.BankAccountRepository;
@PropertySource("classpath:ValidationMessages.properties")
@PropertySource("classpath:custom.properties")
@Service
public class BankAccountServiceImpl implements BankAccountService{
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private Environment env;
	
	@Override
	public String createAccount(BankAccountDTO accountDTO) {
		BankAccount bankAccount = modelMapper.map(accountDTO, BankAccount.class);
		bankAccountRepository.save(bankAccount);
		return "Bank Account is successfully created for AccountNumber"+accountDTO.getAccountNumber();
	}

	@Override
	public List<BankAccountDTO> listAccounts(Long mobileNo) throws InfymeMobileException {
		List<BankAccount> bankAccounts = bankAccountRepository.findBymobileNumber(mobileNo);
		List<BankAccountDTO> bankAccountDTOs = new ArrayList<>();
		for(BankAccount bankAccount: bankAccounts ) {
			bankAccountDTOs.add(modelMapper.map(bankAccount, BankAccountDTO.class));
		}	
		//throw InfyMeMobileException with the message NO_ACCOUNTS_FOUND.
		if(bankAccounts.size()==0) {
			throw new InfymeMobileException(env.getProperty("no.account.found"));
		}
		return bankAccountDTOs;
	}
}
