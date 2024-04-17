package com.MiniProject.Controllers;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MiniProject.Services.CustomerServices;

@RestController
@RequestMapping(value="api/customer")
public class CustomerControllerRest {

	@Autowired
	private CustomerServices cs;
	
	@GetMapping("dobById/{bid}")
	public Date dobById(@PathVariable long bid) {
		return cs.dobById(bid);
	}
}
