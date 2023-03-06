package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendCommentRepository;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;

@Service
public class BackendCommentService {
	
	
	
	@Autowired
	private BackendCommentRepository backendCommentRepository;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增回復留言
	public void insertComment(Comment comment) {
		
		backendCommentRepository.save(comment);
		
	}
	
	
	// 查詢ID找留言
	public Comment findCommentById(Integer id) {
		
		Optional<Comment> optional = backendCommentRepository.findById(id);
		
		if(optional.isEmpty()) {
			
			return null;
			
		}
		
		return optional.get();
		
	}
	
	
	
	// 查詢ID找留言2
	public Comment getCommentById(Integer id) {
		
		Comment comment = null;
		
		Optional<Comment> optional = backendCommentRepository.findById(id);
		
		if(optional.isPresent()) {
			
			comment = optional.get();
			
		}
		
		return comment;
		
	}
	
	
	
	// 查詢ID刪除留言
	public void deleteCommentById(Integer id) {
		
		Optional<Comment> optional = backendCommentRepository.findById(id);
		
		if(optional.isPresent()) {
			
			backendCommentRepository.deleteById(id);
			
		}
		
	}
	
	
	// 分頁功能
	public Page<Comment> findCommentByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "boardId");
		
		Page<Comment> page = backendCommentRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	// 修改留言
	public void updateComment(Comment comment) {
		
		backendCommentRepository.save(comment);
		
	}
	
	
	
	
	
	
	// 查詢最新回覆留言
	public Comment findLatest() {
		
		return backendCommentRepository.findFirstByOrderByCreateTimeDesc();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
