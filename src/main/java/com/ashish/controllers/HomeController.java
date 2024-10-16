package com.ashish.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value="manager")
@RequestMapping("productstore/inventory")
public class HomeController 
{
	@RequestMapping("")
	public String getLoginView()
	{
		return "inventory/home/login";
	}
	@RequestMapping("/login")
	public String authenticateUser(String uid,String pass,Model model)
	{
		if(uid.equals("admin") && pass.equals("12345"))
		{
			return "redirect:home";	
		}
		model.addAttribute("msg","Invalid Cresidentials");
		return "inventory/home/login";
	}
	
	@RequestMapping("/home")
	public String getHomeView()
	{
		return "inventory/home/home";
	}
	@RequestMapping("logout")
	public String logoutAdmin()
	{
		return "redirect: ";
	}
}
