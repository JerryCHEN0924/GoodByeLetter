package com.iSpanProject.GoodByeletter.dao.Ryu;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iSpanProject.GoodByeletter.model.Tina.Comment;

public interface BackendCommentRepository extends JpaRepository<Comment, Integer> {

}
