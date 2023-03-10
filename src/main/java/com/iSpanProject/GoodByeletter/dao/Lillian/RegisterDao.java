package com.iSpanProject.GoodByeletter.dao.Lillian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface RegisterDao extends JpaRepository<Register, Integer>{


		
	@Query("from Register where account = :acc and password = :pwd")
	public Register findRegisterByAccAndPwd(@Param(value="acc")String account,@Param(value="pwd")String password);

	@Query("from Register where account = :acc")
	public Register findRegisterByAcc(@Param(value="acc")String account);
	
	


}	


