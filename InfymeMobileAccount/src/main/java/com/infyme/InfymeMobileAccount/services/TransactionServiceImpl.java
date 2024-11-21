package com.infyme.InfymeMobileAccount.services;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infyme.InfymeMobileAccount.dtos.TransactionDTO;
import com.infyme.InfymeMobileAccount.entities.BankAccount;
import com.infyme.InfymeMobileAccount.entities.DigitalBankAccount;
import com.infyme.InfymeMobileAccount.entities.Transaction;
import com.infyme.InfymeMobileAccount.exceptions.InfymeMobileException;
import com.infyme.InfymeMobileAccount.repositories.DigitalBankAccountRepository;
import com.infyme.InfymeMobileAccount.repositories.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	private DigitalBankAccountRepository digitalBankAccountRepository;
	@Autowired
	private TransactionRepository transactionRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private Environment env;
	@Override
	public String fundTransfer(TransactionDTO transactionDTO) throws InfymeMobileException {
		Double amountTransfer = transactionDTO.getAmount();
		Long senderAccountNumber = transactionDTO.getSenderAccountNumber();
		Long receiverAccountNumber = transactionDTO.getReceiverAccountNumber();
		Long senderMobileNumber =  transactionDTO.getPaidFrom();
		Long receiverMobileNumber = transactionDTO.getPaidTo();		
		Boolean senderDigiExists = false;
		Boolean receiverDigiExists = false;
		BankAccount senderBankAcc = null;
		BankAccount receiverBankAcc = null;
		//first check if the mobile number and account number is linked to digital bank account
		List<DigitalBankAccount> senderDigiBankAccs = digitalBankAccountRepository.findBymobileNumber(senderMobileNumber);
		List<DigitalBankAccount> receiverDigiBankAccs = digitalBankAccountRepository.findBymobileNumber(receiverMobileNumber);
		//checking if sender bank account is linked in digitally
		for(DigitalBankAccount acc: senderDigiBankAccs) {
			if(acc.getBankAcc().getAccountNumber()==senderAccountNumber) {
				senderDigiExists = true;
				senderBankAcc = acc.getBankAcc();
				break;
			}
		}
		//checking if receiver bank account is linked in digitally
		for(DigitalBankAccount acc: receiverDigiBankAccs) {
			if(acc.getBankAcc().getAccountNumber()==receiverAccountNumber) {
				receiverDigiExists = true;
				receiverBankAcc = acc.getBankAcc();
				break;
			}
		}
		if(senderDigiExists && receiverDigiExists) {
			if(senderBankAcc.getBalance()>=amountTransfer) {
				senderBankAcc.setBalance(senderBankAcc.getBalance()-amountTransfer);
				receiverBankAcc.setBalance(receiverBankAcc.getBalance()+amountTransfer);
				transactionRepository.save(modelMapper.map(transactionDTO, Transaction.class));
				return "Transaction Successfull";
			}
			else {
				throw new InfymeMobileException(env.getProperty("insufficient.funds"));
			}
			
		}
		return null;
	}

	@Override
	public List<TransactionDTO> accountStatement(Long mobileNo) throws InfymeMobileException {
		List<TransactionDTO> dtos = new ArrayList<>();
		List<Transaction> txns = transactionRepository.findAllBypaidFrom(mobileNo);
		for(Transaction txn: txns) {
			dtos.add(modelMapper.map(txn, TransactionDTO.class));
		}
		if(dtos.size()==0) {
			throw new InfymeMobileException(env.getProperty("no.active.transactions"));
		}
		return dtos;
	}

}
