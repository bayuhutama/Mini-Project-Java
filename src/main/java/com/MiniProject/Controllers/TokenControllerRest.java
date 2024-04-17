package com.MiniProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.TokenModel;
import com.MiniProject.Services.TokenServices;

@RestController
@RequestMapping(value="api/token")
public class TokenControllerRest {

	@Autowired
	private TokenServices ts;
	
	@PostMapping("addTokenWithdraw")
	public void addTokenWithdraw(@RequestBody TokenModel tm) {
		ts.addTokenWithdraw(tm.getEmail(), tm.getUserId(), tm.getToken());
	}
	
	@PostMapping("addTokenEmail")
	public void addTokenEmail(@RequestBody TokenModel tm) {
		ts.addTokenEmail(tm.getEmail(), tm.getUserId(), tm.getToken());
	}
	
	@PutMapping("invalidateTokenEmail")
	public void invalidateTokenEmail(@RequestBody TokenModel tm) {
		ts.invalidateTokenEmail(tm.getEmail());
	}
	
	@PutMapping("expireToken")
	public void expireToken() {
		ts.expireToken();
	}
	
	@PostMapping("cekTokenEmail")
	public String cekTokenEmail(@RequestBody TokenModel tm) {
		String cek=ts.cekTokenEmail(tm.getToken(),tm.getEmail());
		Boolean cek2=ts.cekTokenExpiry(tm.getToken(), tm.getEmail());
		String result="";
		if(cek==null){
			result="2";
		}else if(cek!=null && cek2==false){
			result="1";
		}else {
			result="3";
		}
		return result;
	}
	
	@PostMapping("cekIntervalToken")
	public String cekIntervalToken(@RequestBody TokenModel tm) {
		int cek=ts.cekIntervalToken(tm.getEmail());
		String result="";
		if(cek==0){
			result="2";
		}else {
			result="1";
		}
		return result;
	}
	
}
