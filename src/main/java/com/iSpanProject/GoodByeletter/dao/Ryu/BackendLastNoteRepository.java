package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Jerry.LastNote;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public interface BackendLastNoteRepository extends JpaRepository<LastNote, Integer> {
	
	
	
	
	
	@Query(value="select * from LastNote where FK_memberId like concat('%',:fkm,'%')", nativeQuery = true)
	public List<LastNote> findLastNoteByFK_memberIdNativeLikeQuery(@Param("fkm") String fk_memberId);
	
	
//	public Page<LastNote> findByFK_memberId(String fkm, Pageable pageable); // 他不能辨別 _ 後的字 No property 'FK' found for type 'LastNote'
	
	
//	@Query(value="from LastNote ln where ln.FK_memberId = :fkm")
//	public Page<LastNote> findByFKmemberId(@Param("fkm") String fkm, Pageable pageable);
	
//	@Query(value="from LastNote ln where ln.FK_memberId = :fkm")
//	public Page<LastNote> findByfKMemberId(Pageable pageable);
	
	
	@Query(value="from LastNote where FK_memberId = :fkm")
	public List<LastNote> findLastNoteByFKMQuery(@Param("fkm") Register fkm);
	
//	@Query(value="from LastNote where verifyTime = :v")
//	public List<LastNote> findLastNoteVerQuery(@Param("v") Date date);
	

}
