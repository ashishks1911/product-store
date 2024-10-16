package com.ashish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.models.Card;

public interface CardRepository extends JpaRepository<Card, String> 
{

}
