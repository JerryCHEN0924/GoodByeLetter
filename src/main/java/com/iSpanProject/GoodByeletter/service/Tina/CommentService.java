package com.iSpanProject.GoodByeletter.service.Tina;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.dao.Tina.BoardDao;
import com.iSpanProject.GoodByeletter.dao.Tina.CommentDao;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;

@Service
public class CommentService {
	@Autowired
	private RegisterDao registerDao;
	
	@Autowired
	private BoardDao boardDao;
	
	@Autowired
	private CommentDao commentDao;
	
	
	
	//addComment
	@Transactional
	public Comment addComment(Comment comment) {
		return commentDao.save(comment);
	}
	
	
	//deleteComment
	@Transactional
	public void deleteCommentById(Integer commentId) {
		 commentDao.deleteById(commentId);
	}
	
	public List<Comment> findAll(){
		return commentDao.findAll();
	}
	
//	public List<Comment> findAllByBoardId(Integer boardId) {
//		List<Comment> list= commentDao.findAll();
//		return commentDao.findAllById(list);
//	}
//	

}
