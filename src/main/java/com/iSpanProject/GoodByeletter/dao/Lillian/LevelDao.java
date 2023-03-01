package com.iSpanProject.GoodByeletter.dao.Lillian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iSpanProject.GoodByeletter.model.Lillian.Level;

public interface LevelDao extends JpaRepository<Level, Integer> {
	
//	@Query("SELECT l FROM Level l WHERE l.level = :level")
//    Level findByLevel(int level);

}
