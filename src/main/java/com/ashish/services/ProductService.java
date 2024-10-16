package com.ashish.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.models.Product;
import com.ashish.repositories.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository repo;

	public List<Product> getList() 
	{
		return repo.findAll();
	}

	public void insertProduct(Product product) 
	{
		repo.save(product);
	}

	public Product getProduct(int pid) 
	{
		return repo.findById(pid).orElseGet(null);
	}

	public void removeProduct(int pid) 
	{
		repo.deleteById(pid);
	}

	public void updateProduct(Product product) 
	{
		repo.save(product);
	}
	public void purchaseUpdate(int q, int pid) 
	{
		Product p = repo.findById(pid).orElse(null);
		int value = p.getUnit_in_stock() - q;
		p.setUnit_in_stock(value);
		repo.save(p);
	}
}
