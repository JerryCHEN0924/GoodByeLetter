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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendBoardService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendCommentService;

@Controller
@SessionAttributes({"authenticated", "existing"})
@RequestMapping("/topGun")
public class BackendCommentController {
	
	
	
	@Autowired
	private BackendBoardService backendBoardService;
	
	
	@Autowired
	private BackendCommentService backendCommentService;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	// 新增回復留言跳頁
	@GetMapping("/comment/add")
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
	@PostMapping("/comment/post")
	public String addNewCommentPost(@ModelAttribute("comment") Comment comment, Model model, 
			RedirectAttributes redirectAttributes) {
		
//		Board board = (Board) model.getAttribute("board");
		
		Integer bid = comment.getbId();
		
		Board board = backendBoardService.findBoardById(bid);
		
//		String title = board.getTitle();
		
		
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
		
		
//		redirectAttributes.addFlashAttribute("backendHomeMessages", "留言 [ " + title + " ] 新增回覆留言成功");
		
		return "/Ryu/backendAddNewCommentForm";
		
//		return "redirect:/topGun/comment/add";
		
		
	}
	
	
	
	// 分頁查詢回復留言
	@GetMapping("/comment/page")
	public String showCommentByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<Comment> page = backendCommentService.findCommentByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowComment";
		
	}
	
	
	
	// 修改回復留言跳頁
	@GetMapping("/comment/edit")
	public String editCommentPage(@RequestParam("commentId") Integer commentId, Model model) {
		
		Comment comment = backendCommentService.findCommentById(commentId);
		
		model.addAttribute("comment", comment);
		
		return "/Ryu/backendEditCommentForm";
		
		
		
	}
	
	
	
	// 修改回復留言
	@PutMapping("/comment/editPost")
	public String editPostComment(@ModelAttribute("comment") Comment comment, 
			RedirectAttributes redirectAttributes) {
		
		Integer commentId = comment.getCommentId();
		
		backendCommentService.updateComment(comment);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "回覆留言編號  [ " + commentId + " ] 修改成功");
		
		return "redirect:/topGun/comment/page";
		
		
	}
	
	
	
	// 刪除回復留言
	@DeleteMapping("/comment/delete")
	public String deleteComment(@RequestParam("commentId") Integer commentId, 
			RedirectAttributes redirectAttributes) {
		
		Comment presentComment = backendCommentService.findCommentById(commentId);
		
		Integer presentCommentId = presentComment.getCommentId();
		
		backendCommentService.deleteCommentById(commentId);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "回覆留言編號  [ " + presentCommentId + " ] 刪除成功");
		
		return "redirect:/topGun/comment/page";
		
	}
	
	// 依帳號查詢Comment的Detail
	@GetMapping("/comment/queryLikeAccountDetail")
	public String getBoardByAccountDetail(@RequestParam("b") Board board, Model model) {
		
		List<Comment> commentDetail = backendCommentService.findCommentByAccountGroupByB(board);
		
		model.addAttribute("commentDetail", commentDetail);
		
		return "/Ryu/backendShowCommentDetailByAccount";
		
	}
	
	
	
	// 條件搜尋之修改回復留言跳頁
	@GetMapping("/comment/editByAccount")
	public String editCommentPageByAccount(@RequestParam("commentId") Integer commentId, Model model) {
		
		Comment comment = backendCommentService.findCommentById(commentId);
		
		model.addAttribute("comment", comment);
		
		return "/Ryu/backendHomeEditCommentForm";
		
		
		
	}
	
	
	
	
	// 條件搜尋之修改回復留言
	@PutMapping("/comment/editPostByAccount")
	public String editPostCommentByAccount(@ModelAttribute("comment") Comment comment, 
			RedirectAttributes redirectAttributes) {
		
		Integer commentId = comment.getCommentId();
		
		Comment presentComment = backendCommentService.findCommentById(commentId);
		
		Register register = presentComment.getRegister();
		
		String account = register.getAccount();
		
		backendCommentService.updateComment(comment);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", " 會員 [ " + account + "]，回覆留言編號  [ " + commentId + " ] 修改成功");
		
//		return "redirect:/topGun/comment/page";
		
		return "redirect:/topGun/board/queryLikeAccount";
		
	}
	
	
	
	// 條件搜尋之刪除回復留言
	@DeleteMapping("/comment/deleteByAccount")
	public String deleteCommentByAccount(@RequestParam("commentId") Integer commentId, 
			RedirectAttributes redirectAttributes) {
		
		Comment presentComment = backendCommentService.findCommentById(commentId);
		
		Register register = presentComment.getRegister();
		
		String account = register.getAccount();
		
		Integer presentCommentId = presentComment.getCommentId();
		
		backendCommentService.deleteCommentById(commentId);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", " 會員 [ " + account + "]，回覆留言編號  [ " + presentCommentId + " ] 修改成功");
		
		return "redirect:/topGun/board/queryLikeAccount";
		
	}
	
	
	
	
	


}
