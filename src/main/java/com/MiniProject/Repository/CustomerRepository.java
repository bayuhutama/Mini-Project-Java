package com.MiniProject.Repository;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.CustomerModel;

public interface CustomerRepository extends JpaRepository<CustomerModel, Long>{

	@Query(value="select dob from m_customer where biodata_id=?1", nativeQuery = true)
	Date dobById(long bid);
	
	@Modifying
	@Query(value="update m_customer set dob=?2 where biodata_id=?1", nativeQuery = true)
	int ubahDOB(long bid,Date dob);
	
}
