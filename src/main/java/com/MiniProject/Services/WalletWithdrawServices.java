package com.MiniProject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Repository.WalletWithdrawRepository;

@Service
@Transactional
public class WalletWithdrawServices {
	
	@Autowired
	private WalletWithdrawRepository wr;
	
	public void addWithdraw(long cid, long nomId, int ammount, String bnk, String accNum, String accNam, int otp) {
		wr.addWithdraw(cid, nomId, ammount, bnk, accNum, accNam, otp);
	}

}
