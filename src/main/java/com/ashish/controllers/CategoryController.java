package com.ashish.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.models.ProductCategory;
import com.ashish.services.CategoryService;

@Controller
@RequestMapping("productstore/inventory/category")
public class CategoryController 
{
	@Autowired
	private CategoryService service;
	
	@RequestMapping("manage")
	public String getManageCategoryView(Model model)
	{
		List<ProductCategory> list = service.getList();
		model.addAttribute("clist", list);
		return "inventory/category/category-list";
	}
	
	@RequestMapping("add")
	public String getAddCategoryView()
	{
		return "inventory/category/add-category";
	}
	
	@RequestMapping("insert")
	public String insertNewCategory(ProductCategory category)
	{
		service.insertCategory(category);
		return "redirect:manage";
	}
	
	@RequestMapping("edit")
	public String editCategoryDetails(int catid,Model model)
	{
		ProductCategory cat = service.editCategory(catid);
		model.addAttribute("category", cat);
		return "inventory/category/edit-category";
	}
	@RequestMapping("update")
	public String updateCategory(ProductCategory category)
	{
		service.insertCategory(category);
		return "redirect:manage";
	}
	
	@RequestMapping("remove")
	public String removeCategoryDetails(int catid)
	{
		service.removeCategory(catid);
		return "redirect:manage";
	}
}
