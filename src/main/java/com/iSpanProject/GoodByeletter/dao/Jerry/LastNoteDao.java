package com.iSpanProject.GoodByeletter.dao.Jerry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface LastNoteDao extends JpaRepository<LastNote, Integer> {
//	原生查詢語法，找到遺書資料表內所有驗證日為當日的資料
	@Query(value = "select * from LastNote WHERE verifyTime LIKE %:a%",nativeQuery = true)
	public List<LastNote> findLastNoteVerifyTimeQuery(@Param("a") LocalDate date);

	public LastNote findByverificationCode(String token);	
	
	public boolean existsByverificationCode(String token);
	
	@Query(value = "select * from LastNote WHERE FK_memberId = :f",nativeQuery = true)
	public List<LastNote> findLastNoteBymemberId(@Param("f") Register r);
	
	
	
}
