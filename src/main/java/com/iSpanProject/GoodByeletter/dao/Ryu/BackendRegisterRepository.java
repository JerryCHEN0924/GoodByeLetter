package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface BackendRegisterRepository extends JpaRepository<Register, Integer> {
	
	
	@Query(value="from Register where account = :account and password = :password")
	public List<Register> findRegisterByAccountAndPassword(@Param("account") String account, @Param("password") String password);
	
	
	
	@Query(value="from Register where account = :acc")
	public Register findRegisterByAccount(@Param("acc") String account);
	

}
