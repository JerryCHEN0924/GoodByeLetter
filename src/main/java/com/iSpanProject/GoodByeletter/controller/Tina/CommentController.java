package com.iSpanProject.GoodByeletter.controller.Tina;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import com.iSpanProject.GoodByeletter.dao.Tina.CommentDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;
import com.iSpanProject.GoodByeletter.service.Tina.BoardService;
import com.iSpanProject.GoodByeletter.service.Tina.CommentService;

@Controller
@SessionAttributes({"authenticated","existing"})
public class CommentController {

	@Autowired
	CommentDao commentDao;
	@Autowired
	CommentService commentService;
	
	@Autowired
	BoardService boardService;
	


	@PostMapping("/comment/add")
	public String addComment(@ModelAttribute("comment") Comment comment,
								@RequestParam("boardId") Integer boardId, 
								Model model) {
//		儲存boardId
		Integer bId = comment.getbId();
		Board board = boardService.findById(bId);
		comment.setBoard(board);
//		儲存memberId
//		Register register = (Register) model.getAttribute("authenticated");
//		comment.setRegister(register);
//		
		Register register_au = (Register) model.getAttribute("authenticated");
		Register register_ex = (Register) model.getAttribute("existing");
		
		System.out.println("=================");
		System.out.println("=================");
		System.out.println(register_au);
		System.out.println(register_ex);
		System.out.println("=================");
		System.out.println("=================");
		comment.setRegister(register_au);
		comment.setRegister(register_ex);
//		save
		commentService.addComment(comment);             
//		add new comment
		Comment newComment = new Comment();
		model.addAttribute("comment",newComment);

		///可以去問人
		return "redirect:/board/show?boardId="+boardId;
	}

	// findAll
	@ResponseBody
	@PostMapping("/comment/findall")
	public List<Comment> allComment() {
		return commentService.findAll();
	}
	
	//傳要被修改的回覆到addComment
	@GetMapping("/comment/editPage")
	public String commentEditedPageById(@RequestParam("commentId") Integer commentId, 
										@RequestParam("boardId") Integer boardId,
										Model model) {
		Board newboard = boardService.findById(boardId);
		model.addAttribute("newboard", newboard);
		
		Comment newcomment = commentService.findById(commentId);
		model.addAttribute("newcomment", newcomment);
		return "Tina/editCommentPage";
		
	}
	
	//修改comment方法
	@PutMapping("/comment/editpost")
	public String editComment(@ModelAttribute("newcomment") Comment comment,
								@RequestParam("boardId") Integer boardId,
								Model model) {
		
//		儲存boardId
		Integer bId = comment.getbId();
		Board board = boardService.findById(bId);
		comment.setBoard(board);
//		儲存memberId
		Register register_au = (Register) model.getAttribute("authenticated");
		Register register_ex = (Register) model.getAttribute("existing");
		comment.setRegister(register_au);
		comment.setRegister(register_ex);
		
		commentService.addComment(comment);
		return "redirect:/board/show?boardId="+boardId;
	}
	
	// delete
	@DeleteMapping("/comment/delete")
	public String deleteCommentById(@RequestParam("commentId")Integer commentId,@RequestParam("boardId") Integer boardId) {
		commentService.deleteCommentById(commentId);
		return "redirect:/board/show?boardId="+boardId;
	}

	//儲存創建時間//謝謝右昕!
	@InitBinder
	 public void initBinder(WebDataBinder binder, WebRequest request) {
	  // java.util.Date
	  DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  dateFormat.setLenient(false);
	  CustomDateEditor ce = new CustomDateEditor(dateFormat, true); 
	  binder.registerCustomEditor(Date.class, ce);}
	
	//Json回傳報錯
//	@ResponseBody
//	@PostMapping("/comment/add2")
//	public Comment addComment2(@RequestBody Comment comment, Model model) {
//		
//		return commentService.addComment(comment);
//	}
//	
//	
}
