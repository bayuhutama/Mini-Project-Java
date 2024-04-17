package com.MiniProject.Controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MiniProject.Models.CustomerWalletModel;
import com.MiniProject.Services.CustomerWalletServices;

@Controller
public class WalletWithdrawController {

	@Autowired
	private CustomerWalletServices cs;

	@RequestMapping("walletWithdraw")
	public String WalletWithdraw(HttpServletRequest req) {
		//int custId=1;
		//int customId=cs.custWalletById(custId);
		//req.getSession().setAttribute("customId", customId);
		return "walletWithdraw/walletWithdraw";
	}
	
	@RequestMapping("withdrawConfrim")
	public String withdrawConfrim() {
		return "walletWithdraw/withdrawConfirm";
	}
	
	@RequestMapping("konfirmasiPin")
	public String konfirmasiPin() {
		return "walletWithdraw/konfirmasiPin";
	}
	
	@RequestMapping("otpWithdraw")
	public String otpWithdraw() {
		return "walletWithdraw/otpWithdraw";
	}
}
