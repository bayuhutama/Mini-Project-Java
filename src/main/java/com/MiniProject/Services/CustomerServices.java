package com.MiniProject.Services;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MiniProject.Repository.CustomerRepository;

@Service
@Transactional
public class CustomerServices {

	@Autowired
	private CustomerRepository cr;
	
	public Date dobById(long bid) {
		return cr.dobById(bid);
	}
	
	public int ubahDOB(long bid,Date dob) {
		return cr.ubahDOB(bid, dob);
	}
}
