package com.MiniProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.CustomNominalModel;

public interface CustomNominalRepository extends JpaRepository<CustomNominalModel, Long>{

	@Query(value = "select id,customer_id,nominal,created_by,created_on,modified_by,modified_on,deleted_by,deleted_on,is_deleted from t_Customer_Custom_Nominal where customer_id=?1", nativeQuery = true)
	List<CustomNominalModel> customById(long id);
	
	@Modifying
	@Query(value = "insert into t_Customer_Custom_Nominal (customer_id,nominal,created_by,created_on,is_deleted,modified_by,deleted_by) values (?1,?2,?1,now(),false,0,0)", nativeQuery = true)
	int addCustom(long cid, int nom);
	
	@Query(value = "select coalesce(max(coalesce(nominal,0)),0) from  t_Customer_Custom_Nominal where nominal=?1 and customer_id=?2 and is_deleted=false", nativeQuery = true)
	int custNominalByNominal(Integer nom, long cid);
	
	@Query(value = "select coalesce(max(coalesce(wdn.nominal,0)),0) from t_customer_custom_nominal ccn\r\n"
			+ "full join m_wallet_default_nominal wdn on ccn.nominal=wdn.nominal where (ccn.nominal=?1 or wdn.nominal=?1) and (ccn.is_deleted=false or wdn.is_deleted=false)", nativeQuery = true)
	int custNominalBydefaultNominal(Integer nom);
	
}
