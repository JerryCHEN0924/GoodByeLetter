package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;

public interface MemberRepositoryByRyu extends JpaRepository<MemberByRyu, Integer>{
	
	
	
	
	
	@Query(value="from MemberByRyu where account = :account and password = :password")
	public List<MemberByRyu> findMemberByRyuByAccountAndPassword(@Param("account") String account, @Param("password") String password);
	
	
	@Query(value="from MemberByRyu where account = :acc")
	public MemberByRyu findMemberByAccount(@Param("acc") String account);
	
	

}
