package com.ashish.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.models.Product;
import com.ashish.services.SearchService;

@Controller
@RequestMapping("productstore/search")
public class SearchController 
{
	@Autowired private SearchService service;
	
	
	@RequestMapping(" ")
	public String getSearchView()
	{
		return "search/search";
	}
	
	@RequestMapping("byBrand")
	public String searchProductByBrand(String brand,Model mo)
	{
		List<Product> list = service.searchByBrand(brand);
		mo.addAttribute("plist", list);
		mo.addAttribute("result","Product with Brand: "+brand);
		return "search/result";
	}
	
	@RequestMapping("byCategory")
	public String searchProductByCategory(String category,Model mo)
	{
		List<Product> list = service.searchByCategory(category);
		mo.addAttribute("plist", list);
		mo.addAttribute("result","Product with Category : "+category);
		return "search/result";
	}
	
	
	@RequestMapping("byPrice")
	public String searchProductByPrice(String under,String price1,String price2,String above,Model model)
	{
		if(under!="")
		{
			List<Product> list = service.priceUnder(Integer.valueOf(under));
			model.addAttribute("plist", list);
			model.addAttribute("result","Product under: \u20B9"+under);
			return "search/result";
		}
		if(price1!="" || price2!="")
		{
			List<Product> list = service.priceBetween(Integer.valueOf(price1),Integer.valueOf(price2));
			model.addAttribute("plist", list);
			model.addAttribute("result","Product between \u20B9"+price1+" and \u20B9"+price2);
			return "search/result";
		}
		if(above!="")
		{
			List<Product> list = service.priceAbove(Integer.valueOf(above));
			model.addAttribute("plist", list);
			model.addAttribute("result","Product above : \u20B9"+above);
			return "search/result";
		}
		return "redirect: ";
	}
	
	@RequestMapping("logout")
	public String logoutUser(HttpSession ses)
	{
		ses.invalidate();
		return "redirect:/productstore/search";
	}
}
