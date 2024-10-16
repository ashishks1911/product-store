package com.ashish.controllers.user;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.standard.processor.StandardInlineHTMLTagProcessor;

import com.ashish.models.Product;
import com.ashish.models.Transaction;
import com.ashish.services.ProductService;
import com.ashish.services.TransactionService;

@Controller
@RequestMapping("productstore/user/product/buy")
public class TransactionController 
{
	@Autowired
	private TransactionService service;
	
	@Autowired
	private ProductService pservice;
	
	@RequestMapping("transaction")
	public String saveTransaction(HttpSession ses)
	{
		Transaction tr = (Transaction)ses.getAttribute("trans");
		tr.setUserId((String)ses.getAttribute("uid"));
		tr.setDate(LocalDate.now().toString());
		service.saveTransaction(tr);
		int q =tr.getQuantity();
		int pid =tr.getPid();
		pservice.purchaseUpdate(q,pid);
		return "user/purchase/payment-done";
	}
	@RequestMapping("transaction-list")
	public String getTransactionInfo(Model model,HttpSession ses)
	{
		List<Transaction> list = service.getList((String)ses.getAttribute("uid"));
		model.addAttribute("tlist", list);
		return "user/transaction/transaction-list";
	}
	
	@RequestMapping("product-details")
	public String productInformation(int pid,Model model)
	{
		Product p = pservice.getProduct(pid);
		model.addAttribute("product", p);
		return "user/transaction/product-info";
	}
}
