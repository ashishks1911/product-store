package com.ashish.controllers.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.models.User;
import com.ashish.services.UserService;

@Controller
@RequestMapping("productstore/user/login")
public class LoginController 
{
	@Autowired
	private UserService service;
	
	@RequestMapping("register")
	public String getRegistrationView()
	{
		return "user/login/user-registration";
	}
	@RequestMapping("registeruser")
	public String newUserRegister(User user)
	{
		service.saveUser(user);
		return "user/login/register";
	}
	
	@RequestMapping("authenticate")
	public String userAuthentication(HttpSession ses,String uid ,String pass,Model model)
	{
		User user = service.getUser(uid);
		if(user!=null)
		{
			if(pass.equals(user.getPassword())) 
			{
				ses.setAttribute("uid", uid);
				return "redirect:/productstore/user/home";
			}
		}
		model.addAttribute("msg","Invalid Cresidentials");
		return "user/home/login";
	}
	
	@RequestMapping("profile")
	public String getUserProfile(String userid,Model model)
	{
		User user = service.getUser(userid);
		model.addAttribute("user", user);
		return "user/home/profile";
	}
}
