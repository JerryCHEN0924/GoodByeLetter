package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;

public interface BackendLastNoteRepository extends JpaRepository<LastNote, Integer> {
	
	
	
	
	
	@Query(value="select * from LastNote where FK_memberId like concat('%',:fkm,'%')", nativeQuery = true)
	public List<LastNote> findLastNoteByFK_memberIdNativeLikeQuery(@Param("fkm") String fk_memberId);
	
	
	
	
	
	

}
