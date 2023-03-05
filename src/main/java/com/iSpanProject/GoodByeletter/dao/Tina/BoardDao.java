package com.iSpanProject.GoodByeletter.dao.Tina;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Tina.Board;

public interface BoardDao extends JpaRepository<Board, Integer> {
	
	//findBoardByTitle
	@Query(value="from Board where title= :title")
	public  List<Board> findBoardByTitle(@Param(value="title") String title);
	
	//模糊搜尋Title
	public List<Board> findByTitleContaining(String title);
	
	//找最新貼文
	public Board findFirstBoardByOrderByCreateTimeDesc();
	
	//更新貼文
	@Modifying
	@Query("update Board b set b.title = :title, b.boardMessage = :boardMessage where b.boardId = :boardId")
	public Board updateBoardById(@Param(value = "title") String title, @Param(value = "boardMessage") String boardMessage, @Param(value = "boardId") Integer boardId);
}
