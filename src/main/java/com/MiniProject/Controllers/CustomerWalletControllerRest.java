package com.MiniProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.CustomerWalletModel;
import com.MiniProject.Repository.UserRepository;
import com.MiniProject.Services.CustomerWalletServices;
import com.MiniProject.Services.UserServices;

@RestController
@RequestMapping(value="api/wallet")
public class CustomerWalletControllerRest {

	int pinAttempt=0;
	
	@Autowired
	private CustomerWalletServices ws;
	
	@Autowired
	private UserServices us;
	
	@GetMapping("walletById/{id}")
	public CustomerWalletModel walletById(@PathVariable int id){
		return ws.walletById(id);
	}
	
	@PostMapping("cekPin")
	public String cekPin(@RequestBody CustomerWalletModel cwm) {
		//System.out.println(cwm.getPin());
		//int custId=1;
		Integer cekPin=ws.cekPin(cwm.getCustomerId(), cwm.getPin());
		String result="";
		if (cekPin!=0) {
			result= "1";
			pinAttempt=0;
		}else {
			result= "0";
			pinAttempt+=1;
			if(pinAttempt>=3) {
				us.lockUser(cwm.getCustomerId());
				pinAttempt=0;
			}
		}
		//System.out.println(pinAttempt);
		//System.out.println(result);
		return result;
	}
	
	
	
	@PutMapping("editWallet")
	public void editUser(@RequestBody CustomerWalletModel wm) {
		//Object idUser = session.getAttribute("idUser");
		//int iduser1=Integer.valueOf(idUser.toString());
		//int Iduser1=1;
		ws.editWallet(wm.getBalance(),wm.getCustomerId());
	}
}
