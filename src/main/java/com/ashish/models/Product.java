package com.ashish.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(generator = "product_seq")
	@SequenceGenerator(name = "product_seq",initialValue = 11111,allocationSize = 1)
	private int pid;
	private String name;
	
	@ManyToOne
	private ProductCategory category;
	
	private String brand;
	private int unit_in_stock;
	private int price;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getUnit_in_stock() {
		return unit_in_stock;
	}
	public void setUnit_in_stock(int unit_in_stock) {
		this.unit_in_stock = unit_in_stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	 
		
}
