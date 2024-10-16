package com.ashish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.models.User;
import com.ashish.repositories.UserRepository;

@Service
public class UserService 
{
	@Autowired
	private UserRepository repo;

	public void saveUser(User user) 
	{
		repo.save(user);
	}

	public User getUser(String uid) 
	{
		return repo.findById(uid).orElse(null);
	}
}
