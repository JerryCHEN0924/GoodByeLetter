package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendBoardService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendCommentService;

@Controller
@SessionAttributes({"authenticated"})
public class BackendCommentController {
	
	
	
	@Autowired
	private BackendBoardService backendBoardService;
	
	
	@Autowired
	private BackendCommentService backendCommentService;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	// 新增回復留言跳頁
	@GetMapping("/topGun/comment/add")
	public String addNewCommentForm(@RequestParam("boardId") Integer boardId, Model model) {
		
		
		Board board = backendBoardService.findBoardById(boardId);
		
		model.addAttribute("board", board);
		
		Comment latestComment = backendCommentService.findLatest();
		
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(latestComment);
		System.out.println("=====================");
		System.out.println("=====================");
		
		model.addAttribute("latestComment", latestComment);
		
		Comment comment = new Comment();
		
		model.addAttribute("comment", comment);
		
		return "/Ryu/backendAddNewCommentForm";
		
		
	}
	
	
	// 新增回復留言
	@PostMapping("/topGun/comment/post")
	public String addNewCommentPost(@ModelAttribute("comment") Comment comment, Model model) {
		
//		Board board = (Board) model.getAttribute("board");
		
		Integer bid = comment.getbId();
		
		Board board = backendBoardService.findBoardById(bid);
		
		
		Register register = (Register) model.getAttribute("authenticated");
		
		comment.setFK_memberId(register);
		
		comment.setFK_parentId(board);
		
		backendCommentService.insertComment(comment);
		
		Comment latestComment = backendCommentService.findLatest();
		
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(latestComment);
		System.out.println("=====================");
		System.out.println("=====================");
		
		model.addAttribute("latestComment", latestComment);
		
		model.addAttribute("board", board);
		
		Comment newComment = new Comment();
		
		model.addAttribute("comment", newComment);
		
		return "/Ryu/backendAddNewCommentForm";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
