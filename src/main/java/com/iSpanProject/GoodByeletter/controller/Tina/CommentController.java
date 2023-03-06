package com.iSpanProject.GoodByeletter.controller.Tina;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Tina.CommentDao;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;
import com.iSpanProject.GoodByeletter.service.Tina.BoardService;
import com.iSpanProject.GoodByeletter.service.Tina.CommentService;

@Controller
public class CommentController {

	@Autowired
	CommentDao commentDao;
	@Autowired
	CommentService commentService;
	
	@Autowired
	BoardService boardService;
	
//	@GetMapping("commend/add")
//	public String addCommentPage(Model model) {
//		Comment addComment = new Comment();
//		model.addAttribute("addComment",addComment);
//		return "Tina/showEachBoard";
//	}

	@PostMapping("/comment/add1")
	public String addComment1(@ModelAttribute("comment") Comment comment, Model model) {
		commentService.addComment(comment);             
		
		Comment addComment = new Comment();
		model.addAttribute("addComment",addComment);
		
		return "Tina/showEachBoard";
	}
	
	//Json回傳報錯
//	@ResponseBody
//	@PostMapping("/comment/add2")
//	public Comment addComment2(@RequestBody Comment comment, Model model) {
//		
//		return commentService.addComment(comment);
//	}
//	
//	
	
	
	
	
	
	// addComment????
	//@ResponseBody
	@GetMapping("/comment/add")
	public String addComment(@ModelAttribute Comment comment, 
							@ModelAttribute Board board,
								Model model) {
		commentService.addComment(comment);   
		boardService.addBoard(board);
		
		
		
		Comment addComment = new Comment();
		model.addAttribute("addComment",addComment);
		
		Board newboard = new Board();
		model.addAttribute("newboard", newboard);
		return "Tina/addComment";
	}

	// findAll
	@ResponseBody
	@PostMapping("comment/findall")
	public List<Comment> allComment() {
		return commentService.findAll();
	}

	// delete
	@DeleteMapping("comment/delete")
	public String deleteCommentById(Integer commentId) {
		commentService.deleteCommentById(commentId);
		return "";
	}

}
