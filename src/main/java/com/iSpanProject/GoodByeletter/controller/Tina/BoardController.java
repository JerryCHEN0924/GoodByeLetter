package com.iSpanProject.GoodByeletter.controller.Tina;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Tina.BoardDao;
import com.iSpanProject.GoodByeletter.model.Tina.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardDao boardDao; 
	//增加留言板
	@ResponseBody
	@PostMapping("board/add")
	public Board addBoard(@RequestBody Board board) {
		return boardDao.save(board);
	}
	//透過id查詢留言板
	@ResponseBody
	@GetMapping("board/id")
	public Board findById(@RequestParam("id") Integer boardId) {
		Optional<Board> optional= boardDao.findById(boardId);
		if(optional.isPresent()) {
			Board findBoard = optional.get();
			return findBoard;
		}
		return null;
	}
	//查詢留言板
	@ResponseBody
	@GetMapping("boards")
	public List<Board> findAll(){
		return boardDao.findAll();
	}
	//刪除留言板
	@ResponseBody
	@DeleteMapping("board/delete")
	public String deleteBoardById(@RequestParam("id") Integer boardId) {
		try {
			boardDao.deleteById(boardId);
			return "刪除留言板成功";
		}catch(EmptyResultDataAccessException e) {
			return "沒有這個留言板";
		}
	}
	//留言板Page
	public List<Board> findByPage(@RequestParam Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 2, Sort.Direction.ASC,"boardId");
		Page<Board> page = boardDao.findAll(pgb);
		List<Board> list= page.getContent();
		return list;
	
	}
}
