package com.ashish.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.models.Transaction;
import com.ashish.repositories.TransactionRepository;

@Service
public class TransactionService 
{
	@Autowired
	private TransactionRepository repo;
	
	public void saveTransaction(Transaction tr) 
	{
		repo.save(tr);
	}

	public List<Transaction> getList(String userId) 
	{
		return repo.findByUserId(userId);
		
	}

	
}
