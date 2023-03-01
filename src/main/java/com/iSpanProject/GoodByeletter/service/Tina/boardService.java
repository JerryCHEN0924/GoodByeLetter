package com.iSpanProject.GoodByeletter.service.Tina;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.dao.Tina.BoardDao;
import com.iSpanProject.GoodByeletter.model.Tina.Board;

@Service
public class boardService {
	
	@Autowired
	private BoardDao boardDao; 
	
	
	
	
	//addBoard
	@Transient
	public Board addBoard(Board board) {			
		return boardDao.save(board);
	}
	
	//findById
	public Board findById(Integer boardId) {
		Optional<Board> optional= boardDao.findById(boardId);
		if(optional.isPresent()) {
			Board findBoard = optional.get();
			return findBoard;
		}
		return null;
	}
	
	//findByPage
	public Page<Board> findByPage (Integer PageNum){
		Pageable pgb = PageRequest.of(PageNum-1, 2, Sort.Direction.ASC,"boardId");
		Page<Board> boardPage = boardDao.findAll(pgb);
		return boardPage;
	}
	
	//findBoardByTitleContaining
	public List<Board> findBoardByTitleContaining(@RequestParam("str")String str){
		return boardDao.findBoardByTitleContaining(str);		
	}
	
	//findAll
	public List<Board> findAll(){
		return boardDao.findAll();		
	}
	
	//findLastest
	public Board findLastest() {
		return boardDao.findFirstBoardByOrderByCreateTimeDesc();
	}
	
	//deleteBoardById
	@Transient
	public String deleteBoardById( Integer boardId) {
		try {
			boardDao.deleteById(boardId);
			return "刪除留言板成功";
		}catch(EmptyResultDataAccessException e) {
			return "沒有這個留言板";
		}
	}
	
	//updateBoardById
	@Transient
	public Board updateBoardById(Integer boardId, String newMsg) {
		Optional<Board> optional= boardDao.findById(boardId);
		if(optional.isPresent()) {
			Board board = optional.get();
			board.setBoardMessage(newMsg);
			//board.setUpdateTime(new Date());//增加更新時間	
			return board;
		}
		System.out.println("沒有這筆資料");
		return null;
	}
}
