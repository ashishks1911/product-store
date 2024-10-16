package com.ashish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashish.models.ProductCategory;

public interface CategoryRepository extends JpaRepository<ProductCategory,Integer> 
{
	ProductCategory findByCategory(String category);
}
