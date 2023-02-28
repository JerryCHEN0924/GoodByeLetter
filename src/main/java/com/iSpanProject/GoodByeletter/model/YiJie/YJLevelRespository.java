package com.iSpanProject.GoodByeletter.model.YiJie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface YJLevelRespository extends JpaRepository<YJLevel, Integer> {

	@Query(value="from Level where Plevel = ?1")
	public YJLevel findlevelNameByLevel(Integer Plevel);
}
