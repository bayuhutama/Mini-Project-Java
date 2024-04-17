package com.MiniProject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Models.UserModel;
import com.MiniProject.Repository.UserRepository;

@Service
@Transactional
public class UserServices {

	@Autowired
	private UserRepository ur;
	
	public void lockUser(long id) {
		ur.lockUser(id);
	}
	
	public UserModel userById(long bid) {
		return ur.userById(bid);
	}
	
	public String cekPassword(long bid, String pass) {
		return ur.cekPassword(bid, pass);
	}
	
	public void gantiPass(long bid, String pass) {
		ur.gantiPass(bid, pass);
	}
	
	public String cekEmail(String email) {
		return ur.cekEmail(email);
	}
	
	public void gantiEmail(long bid, String pass) {
		ur.gantiEmail(bid, pass);
	}
}
