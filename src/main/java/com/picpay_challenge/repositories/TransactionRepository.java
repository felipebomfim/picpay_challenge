package com.picpay_challenge.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.picpay_challenge.domain.transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    
}
