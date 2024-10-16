package com.ashish.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.models.Product;
import com.ashish.models.ProductCategory;
import com.ashish.services.CategoryService;
import com.ashish.services.ProductService;

@Controller
@RequestMapping("productstore/inventory/product")
public class ProductController 
{
	@Autowired
	private ProductService service;
	@Autowired
	private CategoryService cservice;
	
	@RequestMapping("manage")
	public String getManageProductView(Model model)
	{
		List<Product> list = service.getList();
		model.addAttribute("plist",list);
		return "inventory/product/product-list";
	}
	
	@RequestMapping("add")
	public String getAddProductView(Model model)
	{
		List<ProductCategory> list = cservice.getList();
		model.addAttribute("clist",list);
		return "inventory/product/add-product";
	}
	
	@RequestMapping("insert")
	public String insertNewProduct(Product product)
	{
		service.insertProduct(product);
		return "redirect:manage";
	}
	
	@RequestMapping("edit")
	public String editProductDetails(int pid,Model model)
	{
		List<ProductCategory> list = cservice.getList();
		model.addAttribute("clist",list);
		Product p = service.getProduct(pid);
		model.addAttribute("product", p);
		return "inventory/product/edit-product";
	}
	
	@RequestMapping("update")
	public String updateProductDetails(Product product)
	{
		service.updateProduct(product);
		return "redirect:manage";
	}
	@RequestMapping("remove")
	public String removeProductDetails(int pid)
	{
		service.removeProduct(pid);
		return "redirect:manage";
	}
	
}
