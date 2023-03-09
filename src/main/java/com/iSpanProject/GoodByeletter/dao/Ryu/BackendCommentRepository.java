package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Tina.Board;
import com.iSpanProject.GoodByeletter.model.Tina.Comment;

public interface BackendCommentRepository extends JpaRepository<Comment, Integer> {
	
	
	public Comment findFirstByOrderByCreateTimeDesc();
	
	
	@Query(value="from Comment where board = :b")
	public List<Comment> findCommentByBQuery(@Param("b") Board b);
	
	
	

}
