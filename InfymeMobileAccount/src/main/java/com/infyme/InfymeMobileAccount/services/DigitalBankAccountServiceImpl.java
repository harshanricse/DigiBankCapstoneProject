package com.infyme.InfymeMobileAccount.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infyme.InfymeMobileAccount.entities.BankAccount;
import com.infyme.InfymeMobileAccount.entities.DigitalBankAccount;
import com.infyme.InfymeMobileAccount.exceptions.InfymeMobileException;
import com.infyme.InfymeMobileAccount.repositories.BankAccountRepository;
import com.infyme.InfymeMobileAccount.repositories.DigitalBankAccountRepository;
import com.infyme.InfymeMobileAccount.util.OTPUtility;

@Service
public class DigitalBankAccountServiceImpl implements DigitalBankAccountService {
	@Autowired
	private DigitalBankAccountRepository digitalBankAccountRepository;
	@Autowired
	private BankAccountRepository bankAccountRepository;
	@Autowired
	private OTPUtility otpUtility; 
	@Autowired
	private Environment env;
	@Override
	public String linkAccount(Long mobileNo, Long accountNo) throws InfymeMobileException {
		Optional<BankAccount> bankAccount = bankAccountRepository.findByMobileNumberAndAccountNumber(mobileNo, accountNo);
		if(bankAccount.isPresent()) {
			DigitalBankAccount digibankacc = new DigitalBankAccount();
			digibankacc.setAccountType(bankAccount.get().getAccountType());
			digibankacc.setMobileNumber(bankAccount.get().getMobileNumber());
			digibankacc.setBankAcc(bankAccount.get());
			digibankacc.setDigitalBankingId(UUID.randomUUID().toString());
			digitalBankAccountRepository.save(digibankacc);
			return "BankAccount is successfully linked with DigitalBankId "+digibankacc.getDigitalBankingId();
		}
		throw new InfymeMobileException(env.getProperty("no.account.found"));
	}

	@Override
	public String linkAccount(Long mobileNo, Long accountNo, Integer OTP) throws InfymeMobileException {
		Optional<BankAccount> bankAccount = bankAccountRepository.findByMobileNumberAndAccountNumber(mobileNo, accountNo);
		if(bankAccount.isPresent()) {
			if(otpUtility.sendOTP().equals(OTP)) {		
			DigitalBankAccount digibankacc = new DigitalBankAccount();
			digibankacc.setAccountType(bankAccount.get().getAccountType());
			digibankacc.setMobileNumber(bankAccount.get().getMobileNumber());
			digibankacc.setBankAcc(bankAccount.get());
			digibankacc.setDigitalBankingId(UUID.randomUUID().toString());
			digitalBankAccountRepository.save(digibankacc);
				return "BankAccount is successfully linked with DigitalBankId "+digibankacc.getDigitalBankingId()+"After OTP verificaiton";
			}
			else {
				throw new InfymeMobileException("OTP DOESNOT MATCH");
			}
		}
		else {
			throw new InfymeMobileException(env.getProperty("no.account.found"));
		}
	}
	

	@Override
	public Double checkBalance(Long mobileNo, Long accountNo) throws InfymeMobileException {
		List<DigitalBankAccount> digiBankAccounts = digitalBankAccountRepository.findBymobileNumber(mobileNo);
		for(DigitalBankAccount dbacc: digiBankAccounts) {
			if(dbacc.getBankAcc().getAccountNumber()==accountNo) {
				return dbacc.getBankAcc().getBalance(); 
			}
		}		
		throw new InfymeMobileException(env.getProperty("no.account.is.linked"));
	}

}
