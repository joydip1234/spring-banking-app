package jbr.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.service.UserService;

@Controller
public class DashboardController {
	@Autowired
	public UserService userService;

	@RequestMapping(value = "/CheckBalance", method = RequestMethod.GET)
	public ModelAndView getUserDetails(HttpSession session) {

		ModelAndView model = new ModelAndView("balance");
		Float balance = userService.getBalance(session.getAttribute("username").toString());
		model.addObject("balance", balance);
		return model;
	}

	@RequestMapping(value = "/WithdrawMoney", method = RequestMethod.GET)
	public ModelAndView transactionRequest() {

		ModelAndView model = new ModelAndView("transaction");
		model.addObject("type", "withdraw");
		return model;
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public ModelAndView withdrawMoney(@RequestParam("amount") Float amount,HttpSession session) {
		ModelAndView model = new ModelAndView("transactionStatement");
		String username = session.getAttribute("username").toString();
		String status = userService.withdrawMoney(username,amount);
		model.addObject("status", status);
		
		return model;
	}
	
	@RequestMapping(value = "/DepositMoney", method = RequestMethod.GET)
	public ModelAndView depositRequest() {

		ModelAndView model = new ModelAndView("transaction");
		model.addObject("type", "deposit");
		return model;
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public ModelAndView depositMoney(@RequestParam("amount") Float amount,HttpSession session) {
		ModelAndView model = new ModelAndView("transactionStatement");
		String username = session.getAttribute("username").toString();
		String status = userService.depositMoney(username,amount);
		model.addObject("status", status);
		
		return model;
	}
	
	@RequestMapping(value = "/CheckBalanceofUser", method = RequestMethod.GET)
	public ModelAndView checkUserBalance() {

		ModelAndView model = new ModelAndView("accounts");
		List<String> userList = userService.getUserList();
		model.addObject("userList",userList);
		return model;
	}
	
	@RequestMapping(value = "/checkaccounts", method = RequestMethod.GET)
	public ModelAndView checkAccounts(@RequestParam("user") String accountHolderName) {

		ModelAndView model = new ModelAndView("accounts");
		Float balance = userService.getBalance(accountHolderName);
		String accountRemarks ="The account balance of " + accountHolderName + " is : "+ balance;
		model.addObject("balance", accountRemarks);
		return model;
	}
	
	@RequestMapping(value = "/verifyCode", method = RequestMethod.GET)
	public ModelAndView verifyCode(@RequestParam("code") String verifyCode,HttpSession session) {

		ModelAndView model = new ModelAndView("welcome","firstname",session.getAttribute("username").toString());
		String status = userService.validateCode(verifyCode,session.getAttribute("verificationUser").toString());
		model.addObject("status", status);
		return model;
	}

}
