package com.MiniProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.UserModel;
import com.MiniProject.Services.UserServices;

@RestController
@RequestMapping(value="api/user")
public class UserControllerRest {

	@Autowired
	private UserServices us;
	
	@GetMapping("userById/{id}")
	public UserModel userById(@PathVariable long id) {
		return us.userById(id);
	}
	
	@PostMapping("cekPassword")
	public String cekPassword(@RequestBody UserModel um) {
		String cek=us.cekPassword(um.getBiodataId(), um.getPassword());
		String result="";
		if(cek==null){
			result="1";
		}else {
			result="2";
		}
		
		return result;
	}
	
	@PutMapping("gantiPass")
	public void gantiPass(@RequestBody UserModel um) {
		us.gantiPass(um.getBiodataId(), um.getPassword());
	}
	
	@PostMapping("cekEmail")
	public String cekEmail(@RequestBody UserModel um) {
		String cek=us.cekEmail(um.getEmail().toLowerCase());
		String result="";
		if(cek==null){
			result="1";
		}else {
			result="2";
		}
		return result;
	}
	
	@PutMapping("gantiEmail")
	public void gantiEmail(@RequestBody UserModel um) {
		us.gantiEmail(um.getBiodataId(), um.getEmail().toLowerCase());
	}
}
