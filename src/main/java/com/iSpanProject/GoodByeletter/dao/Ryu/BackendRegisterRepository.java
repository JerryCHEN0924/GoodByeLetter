package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface BackendRegisterRepository extends JpaRepository<Register, Integer> {
	
	// 驗證帳號使用
	@Query(value="from Register where account = :account and password = :password")
	public List<Register> findRegisterByAccountAndPassword(@Param("account") String account, @Param("password") String password);
	
	
	// 會員資料細項使用
	@Query(value="from Register where account = :acc")
	public Register findRegisterByAccount(@Param("acc") String account);
	
	// 模糊查詢依Account
	@Query(value="select * from member where account like concat('%',:a,'%')", nativeQuery = true)
	public List<Register> findRegisterByAccountNativeLikeQuery(@Param("a") String account);
	

}
