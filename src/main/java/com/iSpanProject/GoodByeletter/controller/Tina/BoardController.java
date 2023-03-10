package com.iSpanProject.GoodByeletter.controller.Tina;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;
import com.iSpanProject.GoodByeletter.service.Tina.BoardService;
import com.iSpanProject.GoodByeletter.service.Tina.CommentService;


@Controller
@SessionAttributes({"authenticated","existing"})
public class BoardController {

	
	@Autowired
	private BoardService boardService; 
	
	@Autowired
	private CommentService commentService;
	
	
	//傳一個新留言板
	@GetMapping("/board/add")
	public String addBoardPage(Model model) {

		//傳一個新留言板
		Board newboard= new Board();
		model.addAttribute("newboard",newboard);
		//傳最後留言過的留言板
		Board lastestBoard = boardService.findLastest();
		model.addAttribute("lastestBoard",lastestBoard);
		
		return "Tina/addBoard";	
	}	
	
	
	//送出留言 //看到最新留言
	@PostMapping("/board/post")
	public String addBoardPost(@ModelAttribute Board board, Model model) {
//		儲存memberId
		Register register_au = (Register) model.getAttribute("authenticated");
		Register register_ex = (Register) model.getAttribute("existing");
		System.out.println(register_au);
		System.out.println(register_ex);
		board.setRegister(register_au);
		board.setRegister(register_ex);
		//save
		boardService.addBoard(board);	
		//回傳一個空board
		Board newboard = new Board();
		model.addAttribute("newboard",newboard);
		
		Board lastestBoard = boardService.findLastest();
		model.addAttribute("lastestBoard",lastestBoard);
		
		return "redirect:/board/add";
	}
	
	
	
	
	//跳頁
	@GetMapping("/board/page")
	public String showBoardByPage(@RequestParam(name="p",defaultValue = "1")Integer pageNum, Model model) {
		Page<Board> page = boardService.findByPage(pageNum);
		model.addAttribute("page",page);
		return "Tina/showPageBoard";
		
	}
	
	//個別展示BoardPage
	@GetMapping("/board/show")
	public String showEachBoardById(@RequestParam("boardId") Integer boardId, Model model) {
		//傳一個指定id的board給jsp -->${newboard}
		Board newboard = boardService.findById(boardId);
		model.addAttribute("newboard",newboard);
		
		//必須先傳一個空的comment("comment")給下一頁(showEachBoard), 
		//form:form的modelAttribute="comment"會接
		Comment comment = new Comment();
		model.addAttribute("comment", comment);
		
		//取得同boardId的comment
		List<Comment> samebIdComment = commentService.findByCommentBoardId(boardId);
		model.addAttribute("samebIdComment",samebIdComment);
		
		return "Tina/showEachBoard";
		
	}
	
	//透過boardId取得board的資料 送到編輯頁面
	@GetMapping("/board/editPage")
	public String boardEditedPageById(@RequestParam("boardId") Integer boardId, Model model) {
		//傳一個指定id的board給jsp -->${newboard}
		Board newboard = boardService.findById(boardId);
		model.addAttribute("newboard",newboard);	
		return "Tina/editBoardPage";	
	}
	
	//修改board方法
	@PutMapping("/board/editpost")
	public String editBoard(@ModelAttribute("newboard") Board board,
							@RequestParam("boardId") Integer boardId,
							Model model) {
//		儲存memberId
		Register register_au = (Register) model.getAttribute("authenticated");
		Register register_ex = (Register) model.getAttribute("existing");
		board.setRegister(register_au);
		board.setRegister(register_ex);
		
		boardService.addBoard(board);
		return "redirect:/board/show?boardId="+boardId;
	}
	

	@DeleteMapping("/board/delete")
	public String deleteBoard(@RequestParam Integer boardId) {
		boardService.deleteBoardById(boardId);
		return "redirect:/board/page";
	}
	

	//模糊查詢Title
//	@ResponseBody
	@GetMapping("/board/like")
	public String findCustomerByNameContaining(@RequestParam("title") String title, Integer pageNum, Model model){	
		List<Board> like = boardService.findByTitleContaining(title);	
		model.addAttribute("like",like);
//		跳轉好像有問題
//		return "redirect:/board/page";	
		return "Tina/showPageBoard";
	}
	
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
