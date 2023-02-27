package com.iSpanProject.GoodByeletter.dao.Lillian;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface RegisterDao extends JpaRepository<Register, Integer>{
	
	//查詢一筆
	@Query(value="from Register where id = ?1")
	public Register findRegisterById(String id);


		
//	@Query("from Register where account = :acc and passwod :pwd")
//	public List<Register> findRegisterByAccAndPwd(@Param(value="acc")String account,@Param(value="pwd")Integer password);
//	
}
