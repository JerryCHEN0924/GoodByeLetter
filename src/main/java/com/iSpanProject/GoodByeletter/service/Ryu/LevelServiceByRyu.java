package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Ryu.LevelRepositoryByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.LevelByRyu;

@Service
public class LevelServiceByRyu {
	
	
	@Autowired
	private LevelRepositoryByRyu levelRepositoryByRyu;
	
	
	
	public void insert(LevelByRyu levelByRyu) {
		
		levelRepositoryByRyu.save(levelByRyu); // 沒 ID 會新增，有 ID 就 Update 資料
		
	}
	
	
	
	public LevelByRyu findById(Integer id) {
		
		
		Optional<LevelByRyu> optional = levelRepositoryByRyu.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		return optional.get();
		
		
	}
	
	
	
	
	@Transactional
	public void deleteById(Integer memberId) {
		
		Optional<LevelByRyu> optional = levelRepositoryByRyu.findById(memberId);
		
		if(optional.isPresent()) {
			
			levelRepositoryByRyu.deleteById(memberId);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public List<LevelByRyu> getLevelByRyuList(){
		
		List<LevelByRyu> list = levelRepositoryByRyu.findAll();
		
		return list;
		
	}
	
	
	public Page<LevelByRyu> findByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "pLevel");
		
		Page<LevelByRyu> page = levelRepositoryByRyu.findAll(pgb);
		
		return page;
		
	}
	
	
	
	
	
	public LevelByRyu getLevelByRyuById(Integer pLevel) {
		
		LevelByRyu l1 = null;
		
		Optional<LevelByRyu> optional = levelRepositoryByRyu.findById(pLevel);
		
		if(optional.isPresent()) {
			
			l1 = optional.get();
			
		}
		
		return l1;
	}
	
	
	

}
