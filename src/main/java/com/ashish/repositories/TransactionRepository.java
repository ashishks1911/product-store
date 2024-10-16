package com.ashish.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.models.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Integer>
{
	List<Transaction> findByUserId(String userId);
}
