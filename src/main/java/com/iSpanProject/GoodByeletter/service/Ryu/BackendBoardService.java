package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendBoardRepository;
import com.iSpanProject.GoodByeletter.model.Tina.Board;

@Service
public class BackendBoardService {
	
	
	@Autowired
	private BackendBoardRepository backendBoardRepository;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增留言
//	@Transactional
	public void insertBoard(Board board) {
		
		backendBoardRepository.save(board);
		
	}
	
	
	
	// 查詢ID找留言
	public Board findBoardById(Integer id) {
		
		Optional<Board> optional = backendBoardRepository.findById(id);
		
		if(optional.isEmpty()) {
			
			return null;
			
		}
		
		return optional.get();
		
	}
	
	
	
	// 查詢ID找留言2
	public Board getBoardById(Integer id) {
		
		Board board = null;
		
		Optional<Board> optional = backendBoardRepository.findById(id);
		
		if(optional.isPresent()) {
			
			board = optional.get();
			
		}
		
		return board;
		
	}
	
	
	// 查詢ID刪除留言
	@Transactional
	public void deleteBoardById(Integer id) {
		
		Optional<Board> optional = backendBoardRepository.findById(id);
		
		if(optional.isPresent()) {
			
			backendBoardRepository.deleteById(id);
			
		}
		
	}
	
	
	
	// 分頁功能
	public Page<Board> findBoardByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "boardId");
		
		Page<Board> page = backendBoardRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	// 修改留言
	public void updateBoard(Board board) {
		
		backendBoardRepository.save(board);
		
	}
	
	
	
	// 查詢最新留言
	public Board findLatestBoard() {
		
		return backendBoardRepository.findFirstByOrderByCreateTimeDesc();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
