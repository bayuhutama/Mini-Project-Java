package com.MiniProject.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Models.TokenModel;
import com.MiniProject.Services.SendEmailOTPServices;

@RestController
@RequestMapping(value = "api/mail/")
public class SendEmailOTPControllerRest {

	@Autowired
	private SendEmailOTPServices ses;
	
	@PostMapping(value = "sendEmailOTP")
	public void sendEmailOTP(@RequestBody TokenModel tm) {
		ses.sendEmailOTP(tm.getEmail(), "OTP", tm.getToken());
		
	}
}
