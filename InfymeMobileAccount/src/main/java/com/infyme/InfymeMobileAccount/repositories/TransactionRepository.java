package com.infyme.InfymeMobileAccount.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infyme.InfymeMobileAccount.entities.Transaction;
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

	List<Transaction> findAllBypaidFrom(Long mobileNo);

}
