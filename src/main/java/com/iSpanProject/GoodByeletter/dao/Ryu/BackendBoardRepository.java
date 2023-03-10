package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Board;

public interface BackendBoardRepository extends JpaRepository<Board, Integer> {
	
	
	public Board findFirstByOrderByCreateTimeDesc();
	
	
	
	@Query(value="from Board where register = :r")
	public List<Board> findBoardByRQuery(@Param("r") Register r);
	
	
	
	
	
	

}
