package com.MiniProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{

	@Query(value = "select * from m_user where biodata_id=?1", nativeQuery = true)
	UserModel userById(long id);
	
	@Modifying
	@Query(value = "update m_user set is_locked=true,modified_by=0,modified_on=now() where biodata_id=?1", nativeQuery = true)
	int lockUser(long bid);
	
	@Query(value = "select password from m_user where biodata_id=?1 and password=?2", nativeQuery = true)
	String cekPassword(long bid, String pass);
	
	@Modifying
	@Query(value = "update m_user set password=?2,modified_by=?1,modified_on=now() where biodata_id=?1", nativeQuery = true)
	int gantiPass(long bid,String pass);
	
	@Query(value = "select email from m_user where email=?1", nativeQuery = true)
	String cekEmail(String email);
	
	@Modifying
	@Query(value = "update m_user set email=?2,modified_by=?1,modified_on=now() where biodata_id=?1", nativeQuery = true)
	int gantiEmail(long bid,String email);
	
}
