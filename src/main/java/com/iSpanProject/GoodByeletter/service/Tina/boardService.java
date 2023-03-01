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
import com.iSpanProject.GoodByeletter.dao.Tina.Register01Dao;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Register01;

@Service
public class boardService {
	
	@Autowired
	private BoardDao boardDao; 
	@Autowired
	private Register01Dao register01Dao; 
	
	
	
	
	//addBoard
	@Transient
	public Board addBoard(Board board) {
		Optional<Register01> optional = register01Dao.findById(1);
		Register01 r01 = optional.get();
		board.setFK_memberId(r01);
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
		Pageable pgb = PageRequest.of(PageNum-1, 5, Sort.Direction.DESC,"boardId");
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
	public Board updateBoardById(Board board) {
		
		board.setTitle(null);
		board.setBoardMessage(null);
		board.setBoardId(null);
		return boardDao.updateBoardById(null, null, null);
		
	}
	
	
	//updateBoardById
//	@Transient
//	public Board updateBoardById(Integer boardId, String msg) {
//		Optional<Board> optional= boardDao.findById(boardId);
//		if(optional.isPresent()) {
//			Board board = optional.get();
//			board.setBoardMessage(msg);
//			//board.setUpdateTime(new Date());//增加更新時間	
//			return board;
//		}
//		System.out.println("沒有這筆資料");
//		return null;
//	}
}