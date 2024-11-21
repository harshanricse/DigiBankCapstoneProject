package com.infyme.InfymeMobileAccount.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyme.InfymeMobileAccount.entities.DigitalBankAccount;
@Repository
public interface DigitalBankAccountRepository extends JpaRepository<DigitalBankAccount, String>{
	List<DigitalBankAccount> findBymobileNumber(Long mobileNo);

}
