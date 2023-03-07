package com.iSpanProject.GoodByeletter.dao.Ryu;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iSpanProject.GoodByeletter.model.Tina.Board;

public interface BackendBoardRepository extends JpaRepository<Board, Integer> {
	
	
	public Board findFirstByOrderByCreateTimeDesc();

}
