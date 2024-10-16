package com.ashish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> 
{

}
