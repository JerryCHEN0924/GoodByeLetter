package com.iSpanProject.GoodByeletter.dao.Tina;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Tina.Board;

public interface BoardDao extends JpaRepository<Board, Integer> {
	
	//findBoardByTitle
	@Query(value="from Board where title= :title")
	public  List<Board> findBoardByTitle(@Param(value="title") String title);
	
	//模糊搜尋Title
	public List<Board> findBoardByTitleContaining(String str);
	
	//找最新貼文
	public Board findFirstBoardByOrderByCreateTimeDesc();
}
