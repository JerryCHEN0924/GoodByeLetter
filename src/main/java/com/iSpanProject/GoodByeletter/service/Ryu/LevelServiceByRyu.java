package com.iSpanProject.GoodByeletter.service.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Ryu.LevelRepositoryByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.LevelByRyu;

@Service
public class LevelServiceByRyu {
	
	
	@Autowired
	private LevelRepositoryByRyu levelRepositoryByRyu;
	
	
	@Transactional
	public void insert(LevelByRyu levelByRyu) {
		
		levelRepositoryByRyu.save(levelByRyu);
		
	}
	
	
	
	

}
