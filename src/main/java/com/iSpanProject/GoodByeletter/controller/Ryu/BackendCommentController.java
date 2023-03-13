package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.util.List;

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
import com.iSpanProject.GoodByeletter.service.Ryu.BackendBoardService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendCommentService;

@Controller
@SessionAttributes({"authenticated", "existing"})
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
		
		Comment latestComment = backendCommentService.findLatestComment();
		
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
		
		
		Register register = (Register) model.getAttribute("existing");
		
		comment.setRegister(register);
		
		comment.setBoard(board);
		
		backendCommentService.insertComment(comment);
		
		Comment latestComment = backendCommentService.findLatestComment();
		
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
	
	
	
	// 分頁查詢回復留言
	@GetMapping("/topGun/comment/page")
	public String showCommentByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<Comment> page = backendCommentService.findCommentByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowComment";
		
	}
	
	
	
	// 修改回復留言跳頁
	@GetMapping("/topGun/comment/edit")
	public String editCommentPage(@RequestParam("commentId") Integer commentId, Model model) {
		
		Comment comment = backendCommentService.findCommentById(commentId);
		
		model.addAttribute("comment", comment);
		
		return "/Ryu/backendEditCommentForm";
		
		
		
	}
	
	
	
	// 修改回復留言
	@PutMapping("/topGun/comment/editPost")
	public String editPostComment(@ModelAttribute("comment") Comment comment) {
		
		backendCommentService.updateComment(comment);
		
		return "redirect:/topGun/comment/page";
		
		
	}
	
	
	
	// 刪除回復留言
	@DeleteMapping("/topGun/comment/delete")
	public String deleteComment(@RequestParam("commentId") Integer commentId) {
		
		backendCommentService.deleteCommentById(commentId);
		
		return "redirect:/topGun/comment/page";
		
	}
	
	// 依帳號查詢Comment的Detail
	@GetMapping("/topGun/comment/queryLikeAccountDetail")
	public String getBoardByAccountDetail(@RequestParam("b") Board board, Model model) {
		
		List<Comment> commentDetail = backendCommentService.findCommentByAccountGroupByB(board);
		
		model.addAttribute("commentDetail", commentDetail);
		
		return "/Ryu/backendShowCommentDetailByAccount";
		
	}
	
	
	
	
	
	
	
	
	


}
