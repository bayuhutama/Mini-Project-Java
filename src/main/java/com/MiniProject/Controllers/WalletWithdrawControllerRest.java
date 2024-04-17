package com.MiniProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.WalletWithdrawModel;
import com.MiniProject.Services.WalletWithdrawServices;

@RestController
@RequestMapping(value="api/withdraw")
public class WalletWithdrawControllerRest {
	
	@Autowired
	private WalletWithdrawServices ws;
	
	@PostMapping("addWithdraw")
	public void addWithdraw(@RequestBody WalletWithdrawModel wm) {
		ws.addWithdraw(wm.getCustomerId(), wm.getWalletDefaultNominalId(), wm.getAmmount(), wm.getBankName(), wm.getAccountNumber(), wm.getAccountName(), wm.getOtp());
	}

}
