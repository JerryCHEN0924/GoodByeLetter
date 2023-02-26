package com.iSpanProject.GoodByeletter.dao.Lillian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface RegisterDao extends JpaRepository<Register, Integer>{
	
	//查詢一筆帳號
	@Query(value="from Register where account = ?1")
	public Register findRegisterByAcc(String account);
	
//	@Query("from Register where account = :acc and FK_Plevel :lev")
//	public List<Register> findRegisterByAccAndLevel(@Param(value="acc")String account,@Param(value="lev")Integer FK_Plevel);
	
}
