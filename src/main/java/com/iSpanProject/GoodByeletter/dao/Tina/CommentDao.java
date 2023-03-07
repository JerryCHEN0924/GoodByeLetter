package com.iSpanProject.GoodByeletter.dao.Tina;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Tina.Comment;

public interface CommentDao extends JpaRepository<Comment, Integer> {

	@Query(value="SELECT * FROM childComment where FK_parentId = :FK_parentId", nativeQuery = true)
	public List<Comment> findByCommentBoardId(@Param("FK_parentId") Integer boardId);
}
