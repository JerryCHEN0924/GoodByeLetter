package com.iSpanProject.GoodByeletter.controller.Tina;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.dao.Tina.BoardDao;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Register01;
import com.iSpanProject.GoodByeletter.service.Tina.boardService;

@Controller
public class BoardController {
	
//	@Autowired
//	private BoardDao boardDao; 
	
	@Autowired
	private boardService boardService; 
	
	
	//增加留言板
	@GetMapping("/board/add")
	public String addBoardPage(Model model) {
		Register01 register01 = new Register01();
		register01.getMemberId();
		
		Board newboard= new Board();
		model.addAttribute("newboard",newboard);
		
		Board lastestBoard = boardService.findLastest();
		model.addAttribute("lastestBoard",lastestBoard);
		
		return "Tina/addBoard";	
	}
	
	@PostMapping("board/post")
	public String addBoardPost(@ModelAttribute Board board, Model model) {
		boardService.addBoard(board);	
		
		Board newboard = new Board();
		model.addAttribute("newboard",newboard);
		
		Board lastestBoard = boardService.findLastest();
		model.addAttribute("lastestBoard",lastestBoard);
		
		return "Tina/addBoard";
	}
	
	@GetMapping("board/page")
	public String showBoardByPage(@RequestParam(name="p",defaultValue = "1")Integer pageNum, Model model) {
		Page<Board> page = boardService.findByPage(pageNum);
		model.addAttribute("page",page);
		return "Tina/showPageBoard";
		
	}
	
	@GetMapping("board/edit")
	public String editById(@RequestParam("boardId") Integer boardId, Model model) {
		Board board = boardService.findById(boardId);
		model.addAttribute("board",board);
		return "Tina/editBoard";
		
	}
//	@PostMapping("board/editpost")
//	public String postEdit(@ModelAttribute Board board) {
//		boardService.updateBoardById(board);
//		return "redirect:/board/page";
//	}++
	

	
	
//	public Board addBoard(@RequestBody Board board) {
//		return boardDao.save(board);
//	}
	
	
	//透過id查詢留言板
//	@ResponseBody
//	@GetMapping("board/id")
//	public Board findById(@RequestParam("id") Integer boardId) {
//		Optional<Board> optional= boardDao.findById(boardId);
//		if(optional.isPresent()) {
//			Board findBoard = optional.get();
//			return findBoard;
//		}
//		return null;
//	}
	//透過title查詢留言板
//	@ResponseBody
//	@GetMapping("board/title")
//	public List<Board> findBoardByTitle(@RequestParam("title") String title) {		
//		return boardDao.findBoardByTitle(title);
//	}
	
	//模糊查詢Title
//	@ResponseBody
//	@GetMapping("board/like")
//	public List<Board> findBoardByTitleContaining(@RequestParam("str")String str){
//		return boardDao.findBoardByTitleContaining(str);
//		
//	}
	
	
	//查詢所有留言板
//	@ResponseBody
//	@GetMapping("boards")
//	public List<Board> findAll(){
//		return boardDao.findAll();
//	}
	
	
	//刪除留言板
//	@ResponseBody
//	@DeleteMapping("board/delete")
//	public String deleteBoardById(@RequestParam("id") Integer boardId) {
//		try {
//			boardDao.deleteById(boardId);
//			return "刪除留言板成功";
//		}catch(EmptyResultDataAccessException e) {
//			return "沒有這個留言板";
//		}
//	}
	
	
	//留言板Page
//	public List<Board> findByPage(@RequestParam Integer pageNumber){
//		Pageable pgb = PageRequest.of(pageNumber-1, 2, Sort.Direction.ASC,"boardId");
//		Page<Board> page = boardDao.findAll(pgb);
//		List<Board> list= page.getContent();
//		return list;
//	
//	}
}
