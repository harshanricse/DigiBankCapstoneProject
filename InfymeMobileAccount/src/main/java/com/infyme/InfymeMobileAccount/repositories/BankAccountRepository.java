package com.infyme.InfymeMobileAccount.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyme.InfymeMobileAccount.entities.BankAccount;
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
	List<BankAccount> findBymobileNumber(Long mobileNo);
	Optional<BankAccount> findByMobileNumberAndAccountNumber(Long mobileNo, Long accountNo);

}
