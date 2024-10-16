package com.ashish.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.models.Product;
import com.ashish.models.ProductCategory;
import com.ashish.repositories.CategoryRepository;
import com.ashish.repositories.ProductRepository;

@Service
public class SearchService 
{
	@Autowired private ProductRepository repo;
	@Autowired private CategoryRepository crepo;
	
	public List<Product> priceUnder(Integer under) 
	{
		return repo.underPrice(under);	
	}

	public List<Product> priceBetween(Integer price1, Integer price2) 
	{
		return repo.betweenPrice(price1, price2);
	}

	public List<Product> priceAbove(Integer above) 
	{
		return repo.abovePrice(above);
	}

	public List<Product> searchByBrand(String brand) 
	{
		return repo.findByBrand(brand);
	}

	public List<Product> searchByCategory(String category) 
	{
		ProductCategory cat = crepo.findByCategory(category);
		return repo.findByCategory(cat);
	}
	
}
