package com.iSpanProject.GoodByeletter.model.YiJie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iSpanProject.GoodByeletter.model.Lillian.Level;

public interface YJLevelRespository extends JpaRepository<Level, Integer> {

	@Query(value="from Level where plevel = ?1")
	public Level findlevelNameByLevel(Integer plevel);
}
