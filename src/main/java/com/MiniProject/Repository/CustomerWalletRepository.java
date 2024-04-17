package com.MiniProject.Repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.CustomerWalletModel;

public interface CustomerWalletRepository extends JpaRepository<CustomerWalletModel, Integer>{
	
	@Query(value = "select id,customer_id,pin,balance,barcode,points,created_by,created_on,modified_by,deleted_by,is_deleted,deleted_on,modified_on from t_customer_wallet where customer_id=?1", nativeQuery = true)
	CustomerWalletModel walletById(int id);
	
	@Query(value = "select customer_id from t_customer_wallet where id=?1", nativeQuery = true)
	int custWalletById(int id);
	
	@Query(value = "select coalesce(max(coalesce(id,0)),0) from t_customer_wallet where customer_id=?1 and pin=?2", nativeQuery = true)
	Integer cekPin(long id, String pin);
	
	@Modifying
	@Query(value = "update t_customer_wallet set balance=?1, modified_by=?2, modified_on=now() where customer_id=?2", nativeQuery = true)
	int editWallet(BigDecimal bal, long l);
}
