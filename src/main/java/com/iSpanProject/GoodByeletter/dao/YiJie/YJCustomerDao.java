package com.iSpanProject.GoodByeletter.dao.YiJie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomer;

public interface YJCustomerDao extends JpaRepository<YJCustomer, Integer>{

	@Query(value="from YJCustomer where account = :acc and password = :pass")
	public YJCustomer findCustomerByAccAndPwd(@Param(value="acc")String acc, @Param(value="pass")String pass);
}
