package com.iSpanProject.GoodByeletter.dao.Jerry;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;

public interface LastNoteDao extends JpaRepository<LastNote, Integer> {
//	原生查詢語法
	@Query(value = "select * from LastNote WHERE verifyTime = :a",nativeQuery = true)
	public List<LastNote> findLastNoteVerifyTimeQuery(@Param("a") LocalDate date);

//	@Query(value="from LastNote where verifyTime = :v")
//    public List<LastNote> findLastNoteVerifyTimeQuery(@Param("v") Date date);
	
}
