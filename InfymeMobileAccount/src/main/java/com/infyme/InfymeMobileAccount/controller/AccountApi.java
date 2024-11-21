package com.infyme.InfymeMobileAccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infyme.InfymeMobileAccount.dtos.BankAccountDTO;
import com.infyme.InfymeMobileAccount.dtos.LinkAccountDTO;
import com.infyme.InfymeMobileAccount.dtos.TransactionDTO;
import com.infyme.InfymeMobileAccount.exceptions.InfymeMobileException;
import com.infyme.InfymeMobileAccount.services.BankAccountService;
import com.infyme.InfymeMobileAccount.services.DigitalBankAccountService;
import com.infyme.InfymeMobileAccount.services.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountApi {
	@Autowired
	private BankAccountService accountService;
	@Autowired
	private DigitalBankAccountService digitalBankAccountService;
	@Autowired
	private TransactionService transactionService;
	@PostMapping
	public ResponseEntity<String> createAccount(@Valid @RequestBody BankAccountDTO accountDTO){
		
		return ResponseEntity.ok().body(accountService.createAccount(accountDTO));
		
	}
	@GetMapping({"/{mobileNo}"})
	public ResponseEntity<List<BankAccountDTO>> listAccounts(@PathVariable("mobileNo") Long mobileNo) throws InfymeMobileException{
		return ResponseEntity.ok().body(accountService.listAccounts(mobileNo));
	}
	@PostMapping({"/{mobileNo}"})
	public ResponseEntity<String> linkAccount(@PathVariable("mobileNo") Long mobileNo,@RequestBody LinkAccountDTO linkAccountDTO) throws InfymeMobileException{
		if(linkAccountDTO.getOtp()==null) {
			return ResponseEntity.ok().body(digitalBankAccountService.linkAccount(mobileNo, linkAccountDTO.getAccountNo()));
		}
		return ResponseEntity.ok().body(digitalBankAccountService.linkAccount(mobileNo, linkAccountDTO.getAccountNo(), linkAccountDTO.getOtp()));				
	}
	@GetMapping(value = "/balance/{mobileNo}")
	public ResponseEntity<Double> checkBalance(@PathVariable("mobileNo") Long mobileNo, @RequestParam("accountNo") Long accountNo) throws InfymeMobileException {
		
		return ResponseEntity.ok().body(digitalBankAccountService.checkBalance(mobileNo, accountNo));
		
	}
	@PatchMapping(value="/fundtransfer")
	public ResponseEntity<String> fundTransfer(@RequestBody TransactionDTO transactionDTO) throws InfymeMobileException {
		return ResponseEntity.ok().body(transactionService.fundTransfer(transactionDTO));		
	}
	@GetMapping("/statement/{mobileNo}")
	public ResponseEntity<List<TransactionDTO>> accountStatement(@PathVariable Long mobileNo)throws InfymeMobileException{
		return ResponseEntity.ok().body(transactionService.accountStatement(mobileNo));		
	}

}
