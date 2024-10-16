package com.ashish.controllers.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.models.User;
import com.ashish.services.UserService;

@Controller(value ="user")
@RequestMapping("productstore/user")
public class HomeController 
{
	@Autowired
	private UserService service;
	@RequestMapping("")
	public String getLoginView()
	{
		return "user/home/login";
	}
	
	@RequestMapping("home")
	public String getHomeView()
	{
		return "user/home/home";
	}
	
	@RequestMapping("profile")
	public String getUserProfile(String userid,Model model)
	{
		User user = service.getUser(userid);
		model.addAttribute("user", user);
		return "user/home/profile";
	}
	
	@RequestMapping("logout")
	public String logoutUser(HttpSession ses)
	{
		ses.invalidate();
		return "redirect:/productstore/user";
	}
	
}
