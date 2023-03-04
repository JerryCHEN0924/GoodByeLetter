package com.iSpanProject.GoodByeletter.dao.Lillian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface RegisterDao extends JpaRepository<Register, Integer>{


		
	@Query("from Register where account = :acc and password = :pwd")
	public Register findRegisterByAccAndPwd(@Param(value="acc")String account,@Param(value="pwd")String password);

	
	

//	@Query("update Register set account = :acc, password = :pwd WHERE memberId = :mId")
//	public Register updateUsernameAndPassword(int mId , String acc, String pwd);
	


}	


