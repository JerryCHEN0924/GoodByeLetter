package com.iSpanProject.GoodByeletter.service.Tina;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.dao.Tina.CommentDao;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;

@Service
public class CommentService {
	
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
	
	//findAll
	public List<Comment> findAll(){
		return commentDao.findAll();
	}
	
	//findById
	public Comment findById(@RequestParam Integer commentId) {
		Optional<Comment> optional=commentDao.findById(commentId);
		if(optional.isPresent()) {
			Comment findComment = optional.get();
			return findComment;
		}
		return null;
	}
	
	public List<Comment> findByCommentBoardId(Integer boardId){		
		return commentDao.findByCommentBoardId(boardId);
	}
	
	//找同個留言板回覆的留言
//	public List<Comment> findByFK_parentId(Board fK_parentId){
//		return commentDao.findByFK_parentId(fK_parentId);
//	}
	
//	public List<Comment> findAllByBoardId(Integer boardId) {
//		List<Comment> list= commentDao.findAll();
//		return commentDao.findAllById(list);
//	}
//	

}
