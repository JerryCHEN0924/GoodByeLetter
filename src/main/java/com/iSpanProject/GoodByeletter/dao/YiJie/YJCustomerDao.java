package com.iSpanProject.GoodByeletter.dao.YiJie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomer;

public interface YJCustomerDao extends JpaRepository<YJCustomer, Integer>{

	@Query(value="from YJCustomer where account = ?1")
	public YJCustomer findCustomerByAcc(String acc);
}
