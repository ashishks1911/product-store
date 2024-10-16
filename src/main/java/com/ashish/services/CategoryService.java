package com.ashish.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.models.ProductCategory;
import com.ashish.repositories.CategoryRepository;
import com.ashish.repositories.ProductRepository;

@Service
public class CategoryService 
{
	@Autowired
	private CategoryRepository repo;

	public List<ProductCategory> getList() 
	{
		return repo.findAll();
	}

	public void insertCategory(ProductCategory category) 
	{
		repo.save(category);
	}

	public ProductCategory editCategory(int catid) 
	{
		return repo.findById(catid).orElse(null);
	}

	public void removeCategory(int catid) 
	{
		repo.deleteById(catid);
	}
}
