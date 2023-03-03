package com.iSpanProject.GoodByeletter.controller.Tina;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Tina.BoardDao;
import com.iSpanProject.GoodByeletter.dto.Tina.BoardDto;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.service.Tina.boardService;


@Controller
public class BoardController {
	
	@Autowired
	private BoardDao boardDao; 
	
	@Autowired
	private boardService boardService; 
	
	
	//增加留言板
	@GetMapping("/board/add")
	public String addBoardPage(Model model) {
//		Register01 register01 = new Register01();
//		register01.getMemberId();
//		
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
		Board newboard = boardService.findById(boardId);
		model.addAttribute("newboard",newboard);
		return "Tina/editBoard";
		
	}
	
	@PutMapping("board/editpost")
	public String editBoard(@ModelAttribute("newboard") Board board) {
		boardService.addBoard(board);
		return "redirect:/board/page";
	}
	

	@DeleteMapping("/board/delete")
	public String deleteBoard(@RequestParam Integer boardId) {
		boardService.deleteBoardById(boardId);
		return "redirect:/board/page";
	}
	

	//模糊查詢Title
//	@ResponseBody
//	@GetMapping("board/like")
//	public String findCustomerByNameContaining(@RequestParam("title") String title, Integer pageNum, Model model){
//		Page<Board> page = boardService.findByTitleContaining(title);
//		Pageable pgb = PageRequest.of(pageNum-1, 5, Sort.Direction.DESC,"boardId");
//		
//		
//
//		return "redirect:/board/page";
//	}
	
//	public List<Board> findByPage(@RequestParam Integer pageNumber){
//		Pageable pgb = PageRequest.of(pageNumber-1, 2, Sort.Direction.ASC,"boardId");
//		Page<Board> page = boardDao.findAll(pgb);
//		List<Board> list= page.getContent();
//		return list;
//	
//	}
	
	@GetMapping("/board/ajax")
	public String ajax(@ModelAttribute Board board) {
		return "Tina/ajaxBoard";
		
	}
	
	//用boardDto遮罩的controller
//	@ResponseBody
//	@PostMapping("/board/ajaxPost")
//	public Page<Board> ajaxPost(@RequestBody BoardDto dto, Board board1) {
//		String inputTitle = dto.getInputTitle();
//		String inputMessString = dto.getInputMessage();
//		
//		Board board = new Board();
//		board.setTitle(inputTitle);
//		board.setBoardMessage(inputMessString);
//		
//		boardService.addBoard(board);
//		Page<Board> page = boardService.findByPage(1);
//	
//		return page;
//		
//	}
//	
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
	
	
//	查詢所有留言板:json
//	@ResponseBody
//	@PostMapping("boards")
//	public List<Board> findAll(){
//		return boardService.findAll();
//	}
//	
	
//	測試?
//		@ResponseBody
//		@GetMapping("/str")
//		public List<String> Str(){
//			List<String> list = new ArrayList<String>();
//			list.add("1");
//			list.add("1");
//			list.add("1");
//			list.add("1");
//			return list;
//		}
	
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
