package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Register findRegisterByAccount(@Param("acc") String username);
	
	// 模糊查詢依Account
	@Query(value="select * from member where account like concat('%',:a,'%')", nativeQuery = true)
	public List<Register> findRegisterByAccountNativeLikeQuery(@Param("a") String account);
	
	
	
	Optional<Register> findByAccount(String account);
	
	
	// 後台首頁查詢會員專用
	@Query(value="select * from member where account like concat('%',:a,'%')", nativeQuery = true)
	public Page<Register> findAllByAccountQueryLikePage(@Param("a") String account, Pageable pageable);
	
	// 後台首頁查詢廣告商會員專用
	@Query(value="select * from member where FK_Plevel = 2 and account like concat('%',:a,'%')", nativeQuery = true)
	public Page<Register> findAllVentorsBackupByAccountQueryLikePage(@Param("a") String account, Pageable pageable);
	

}
