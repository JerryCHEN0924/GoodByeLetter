package com.iSpanProject.GoodByeletter.dao.Lillian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;

public interface MemberDetailDao extends JpaRepository<MemberDetail, Integer> {

	@Query("from MemberDetail where FK_memberId.memberId = :memberId")
	public MemberDetail findMemberDetailByMemberId(@Param(value="memberId")Integer memberId);

	@Query("from MemberDetail where Email = :Email")
	public MemberDetail findByEmail(@Param(value="Email")String Email);

	@Query("from MemberDetail where token = :token")
	public MemberDetail findByToken(@Param(value="token")String token);
	
	@Transactional
	@Modifying
	@Query(value="UPDATE MemberDetail SET password = ?1 WHERE id = ?2", nativeQuery = true)
	public void updatePasswordById(String newPassword, Integer id);
}