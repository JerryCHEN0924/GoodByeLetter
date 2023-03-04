package com.iSpanProject.GoodByeletter.dao.Lillian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface MemberDetailDao extends JpaRepository<MemberDetail, Integer> {

	@Query("from MemberDetail where FK_memberId.memberId = :memberId")
	public MemberDetail findMemberDetailByMemberId(@Param(value="memberId")Integer memberId);
}