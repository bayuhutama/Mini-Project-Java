package com.MiniProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.NominalWalletModel;
import com.sun.istack.Nullable;

public interface NominalWalletRepository extends JpaRepository<NominalWalletModel, Long> {
		
		@Query(value = "select id,nominal,is_deleted,created_on,deleted_on,modified_on,created_by,modified_by,deleted_by from m_Wallet_Default_Nominal where is_deleted=false order by id", nativeQuery = true)
		List<NominalWalletModel>ListNominal();
		
		@Modifying
		@Query(value = "INSERT into m_Wallet_Default_Nominal (nominal,is_deleted,created_on,created_by,deleted_by,modified_by) values (?1,false,now(),?2,0,0)", nativeQuery = true)
		int addNominal(Integer nom,long cb);
		
		@Modifying
		@Query(value = "update m_Wallet_Default_Nominal set nominal=?2,modified_on=now(),modified_by=?1 where id=?1 and is_deleted=false", nativeQuery = true)
		int editNominal(long id, Integer nom,long mb);
		
		@Modifying
		@Query(value="update m_Wallet_Default_Nominal set is_deleted=true,deleted_on=now(),deleted_by=?1 where id=?1", nativeQuery = true)
		int deleteNominal(long id,long db);
		
		@Query(value = "select coalesce(max(coalesce(nominal,0)),0) from  m_Wallet_Default_Nominal where nominal=?1 and is_deleted=false", nativeQuery = true)
		int nominalByNominal(Integer nom);
		
		@Query(value = "select id,nominal,is_deleted,created_on,deleted_on,modified_on,created_by,modified_by,deleted_by from m_Wallet_Default_Nominal where cast(nominal as text) like %?1% and is_deleted=false order by id", nativeQuery = true)
		List<NominalWalletModel>searchNominal(String nom);
		
		@Query(value = "select id,nominal,is_deleted,created_on,deleted_on,modified_on,created_by,modified_by,deleted_by from  m_Wallet_Default_Nominal where id=?1", nativeQuery = true)
		NominalWalletModel nominalById(int id);
		
		
		
}
