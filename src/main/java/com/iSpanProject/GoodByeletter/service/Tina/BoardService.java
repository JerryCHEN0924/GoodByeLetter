package com.iSpanProject.GoodByeletter.service.Tina;

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

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.dao.Tina.BoardDao;
import com.iSpanProject.GoodByeletter.model.Tina.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao; 
	@Autowired
	private RegisterDao registerDao; 
	
	
	
	
	//addBoard
	@Transient
	public Board addBoard(Board board) {
//		Optional<Register01> optional = register01Dao.findById(2);
//		Register01 r01 = optional.get();
//		board.setFK_memberId(r01);
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
	
//	要做可查詢單一用戶的所有留言板
	//findAllById
	public List<Board> findAllById(Integer memberId){
		return findAllById(memberId);
	}
	
	
	//findByPage
	public Page<Board> findByPage (Integer PageNum){
		Pageable pgb = PageRequest.of(PageNum-1, 5, Sort.Direction.DESC,"boardId");
		Page<Board> boardPage = boardDao.findAll(pgb);
		return boardPage;
	}
	
	//findBoardByTitleContaining
	public List<Board> findByTitleContaining(@RequestParam("title")String title){
		return boardDao.findByTitleContaining(title);		
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
//	@Transient
//	public Board updateBoardById(Board board) {
//		Optional<Register01> register01 = Register01Dao.findById(null); 
//		
//		
//	}
	
	
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
