package com.ashish.controllers.user;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.models.Card;
import com.ashish.models.Product;
import com.ashish.models.Transaction;
import com.ashish.repositories.CardRepository;
import com.ashish.services.ProductService;
import com.ashish.services.TransactionService;

@Controller
@RequestMapping("productstore/user/product")
public class PurchaseController 
{
	Random ra = new Random();
	@Autowired
	private ProductService service;
	@Autowired
	private CardRepository repo;
	
	@RequestMapping("purchase")
	public String getProductList(Model model)
	{
		
		List<Product> list = service.getList();
		model.addAttribute("plist", list);
		return "user/purchase/product-list";
	}
	
	@RequestMapping("order")
	public String OrderNow(int pid, Model model)
	{
		
		Product product = service.getProduct(pid);
		model.addAttribute("product",product);
		return "user/purchase/order";
	}
	
	@RequestMapping("confirm-pay")
	public String confirmPayment(Model model,int quantity,int price,Transaction tr,HttpSession ses)
	{

		ses.setAttribute("trans",tr);
		LocalDate dt = LocalDate.now();
		int y =dt.getYear();
		model.addAttribute("year", y);
		model.addAttribute("cost",quantity*price);
		return "user/purchase/confirm-pay";
	}
	
	@RequestMapping("otp")
	public String otpVerification(Model model)
	{
		int num = ra.nextInt(2000)+2000;
		model.addAttribute("otpn",num);
		return "user/purchase/otp";
	}
	
	@RequestMapping("verify-card")
	public String cardVerification(String cardNumber, Model model,int cost)
	{
		Card card = repo.findById(cardNumber).orElse(null);
		if(card==null)
		{
			LocalDate dt = LocalDate.now();
			model.addAttribute("year",dt.getYear());
			model.addAttribute("cost",cost);
			model.addAttribute("msg","Please Enter Valid Card details");
			return "user/purchase/confirm-pay";
		}
		return "redirect:otp";
	}
	
}
