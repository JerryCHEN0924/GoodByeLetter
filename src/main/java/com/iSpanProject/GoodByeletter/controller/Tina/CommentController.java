package com.iSpanProject.GoodByeletter.controller.Tina;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Tina.CommentDao;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;
import com.iSpanProject.GoodByeletter.service.Tina.BoardService;
import com.iSpanProject.GoodByeletter.service.Tina.CommentService;



@Controller
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	@Autowired
	CommentDao commentDao;
	
	@Autowired
	BoardService boardService;
	

	//findAll
	@ResponseBody
	@GetMapping("/comment/findAll")
	public List<Comment> findall() {
		return commentService.findAll();
	}
	
	@ResponseBody
	@DeleteMapping("/comment/delete")
	public String deleteComment(@RequestParam("id") Integer commentId) {
		commentService.deleteCommentById(commentId);
		return "刪除 CommentId:"+ commentId + "成功";
	}

	@ResponseBody
	@PostMapping("/customer/add1")
	public Comment addComment1() {
		Comment cus1 = new Comment();
		cus1.setReply("123");
		//cus1.setCommentId(1);
		Comment returnCus = commentDao.save(cus1);		
		return returnCus;
	}
	

}
