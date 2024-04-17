package com.MiniProject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Repository.TokenRepository;

@Service
@Transactional
public class TokenServices {

	@Autowired
	private TokenRepository tr;
	
	public void addTokenWithdraw(String email, long uid,String tkn) {
		tr.addTokenWithdraw(email, uid, tkn);
	}
	
	public void addTokenEmail(String email, long uid,String tkn) {
		tr.addTokenEmail(email, uid, tkn);
	}
	
	public void invalidateTokenEmail(String email) {
		tr.invalidateTokenEmail(email);
	}
	
	public void expireToken() {
		tr.expireToken();
	}
	
	public String cekTokenEmail(String tkn, String email) {
		return tr.cekTokenEmail(tkn, email);
	}
	
	public Boolean cekTokenExpiry(String tkn, String email) {
		return tr.cekTokenExpiry(tkn, email);
	}
	
	public int cekIntervalToken(String email) {
		return tr.cekIntervalToken(email);
	}
}
