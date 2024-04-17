package com.MiniProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.TokenModel;

public interface TokenRepository extends JpaRepository<TokenModel, Long>{

	@Modifying
	@Query(value = "insert into t_token (email,user_id,token,expired_on,is_expired,used_for,created_by,created_on,is_deleted) values (?1,?2,?3,timestamp 'now' + interval '1 hour',false,'Tarik Saldo',0,now(),false)", nativeQuery = true)
	int addTokenWithdraw(String email, long uid,String tkn);

	@Modifying
	@Query(value = "insert into t_token (email,user_id,token,expired_on,is_expired,used_for,created_by,created_on,is_deleted) values (?1,?2,?3,timestamp 'now' + interval '10 minutes',false,'Ganti Email',0,now(),false)", nativeQuery = true)
	int addTokenEmail(String email, long uid,String tkn);

	@Modifying
	@Query(value = "update t_token set is_expired=true where email=?1 and used_for='Ganti Email'", nativeQuery = true)
	int invalidateTokenEmail(String email);
	
	@Modifying
	@Query(value = "update t_token set is_expired=true where timestamp 'now'>expired_on", nativeQuery = true)
	int expireToken();
	
	@Query(value = "select token from t_token where token=?1 and email=?2 and used_for='Ganti Email' and is_expired=false", nativeQuery = true)
	String cekTokenEmail(String tkn, String email);
	
	@Query(value = "select is_expired from t_token where token=?1 and email=?2 and used_for='Ganti Email'", nativeQuery = true)
	Boolean cekTokenExpiry(String tkn, String email);

	@Query(value = "select coalesce(max(id),0) from t_token where timestamp 'now'>created_on + interval '3 minutes' and used_for='Ganti Email' and email=?1", nativeQuery = true)
	int cekIntervalToken(String email);
}
