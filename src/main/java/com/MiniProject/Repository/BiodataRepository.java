package com.MiniProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.MiniProject.Models.BiodataModel;

public interface BiodataRepository extends JpaRepository<BiodataModel, Long>{

	@Modifying
	@Query(value = "update m_biodata set fullname=?2,mobile_phone=?3 where id=?1", nativeQuery = true)
	int ubahNamaNomor(long id,String nama, String noHP);
	
	@Query(value = "select id,fullname,mobile_phone,image_path,created_by,created_on,modified_by,modified_on,deleted_by,deleted_on,is_deleted from m_biodata where id=?1", nativeQuery = true)
	BiodataModel biodataById(int id);
	
	@Modifying
	@Query(value = "update m_biodata set image_path=?2 where id=?1", nativeQuery = true)
	int ubahGambar(long id,String img);

}
