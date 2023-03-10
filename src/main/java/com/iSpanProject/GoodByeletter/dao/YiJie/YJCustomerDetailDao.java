package com.iSpanProject.GoodByeletter.dao.YiJie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;

public interface YJCustomerDetailDao extends JpaRepository<YJCustomerDetail, Integer>{

//非原生語法，需要用YJCustomerDetail來做映射查詢
	@Query("from YJCustomerDetail where FK_memberId.memberId = :memberId")
	public YJCustomerDetail findDetailByMemberId(@Param(value="memberId")Integer memberId);
}
