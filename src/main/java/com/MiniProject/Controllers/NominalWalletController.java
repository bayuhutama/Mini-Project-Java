package com.MiniProject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NominalWalletController {

	@RequestMapping("nominalwallet")
	public String NominalWallet() {
		return "nominalwallet/nominalwallet";
	}
	
	@RequestMapping("addNominal")
	public String addNominal() {
		return "nominalwallet/addNominal";
	}
	
	@RequestMapping("editNominal")
	public String editNominal() {
		return "nominalwallet/editNominal";
	}
	
	@RequestMapping("deleteNominal")
	public String deleteNominal() {
		return "nominalwallet/deleteNominal";
	}
}
