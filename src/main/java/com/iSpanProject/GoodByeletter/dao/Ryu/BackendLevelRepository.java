package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iSpanProject.GoodByeletter.model.Lillian.Level;

public interface BackendLevelRepository extends JpaRepository<Level, Integer> {
	
	
	
	Optional<Level> findByLevelName(String levelName);

}
