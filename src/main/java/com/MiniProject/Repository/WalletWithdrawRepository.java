package com.MiniProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.WalletWithdrawModel;

public interface WalletWithdrawRepository extends JpaRepository<WalletWithdrawModel, Long>{

	@Modifying
	@Query(value = "insert into t_Customer_Wallet_Withdraw (customer_id,wallet_Default_Nominal_Id,ammount,bank_Name,account_Number,account_Name,otp,created_by,created_on,is_deleted,modified_by,deleted_by) values (?1,?2,?3,?4,?5,?6,?7,?1,now(),false,0,0)", nativeQuery = true)
	int addWithdraw(long cid, long nomId, int ammount, String bnk, String accNum, String accNam, int otp);

}
