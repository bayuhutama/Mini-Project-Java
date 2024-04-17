package com.MiniProject.Services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Models.CustomerWalletModel;
import com.MiniProject.Repository.CustomerWalletRepository;

@Service
@Transactional
public class CustomerWalletServices {

	@Autowired
	private CustomerWalletRepository wr;

	public CustomerWalletModel walletById(int id) {
		return wr.walletById(id);
	}

	public int custWalletById(int id) {
		return wr.custWalletById(id);
	}
	
	public Integer cekPin(long id, String pin) {
		return wr.cekPin(id, pin);
	}
	
	public void editWallet(BigDecimal bal, long l) {
		wr.editWallet(bal, l);
	}
}
