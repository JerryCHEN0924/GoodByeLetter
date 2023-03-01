package com.iSpanProject.GoodByeletter.dao.YiJie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;

public interface YJCustomerDetailDao extends JpaRepository<YJCustomerDetail, Integer>{

//	@Query(value="from YJCustomerDetail where ")
}
