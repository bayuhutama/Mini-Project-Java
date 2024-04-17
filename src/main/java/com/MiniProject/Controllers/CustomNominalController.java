package com.MiniProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomNominalController {
	@RequestMapping("addCustom")
	public String addNominal() {
		return "walletWithdraw/addCustom";
	}
}
