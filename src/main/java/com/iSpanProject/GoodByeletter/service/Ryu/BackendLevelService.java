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

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendLevelRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;

@Service
public class BackendLevelService {
	
	@Autowired
	private BackendLevelRepository backendLevelRepository;
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增權限等級
	public void insertLevel(Level level) {
		
		backendLevelRepository.save(level); // 沒 ID 會新增，有 ID 就 Update 資料
		
	}
	
	
	
	// 查詢ID找等級權限
	public Level findLevelById(Integer id) {
		
		Optional<Level> optional = backendLevelRepository.findById(id);
		
		if(optional.isEmpty()) {
			
			return null;
			
		}
		
		return optional.get();
		
	}
	
	
	
	// 查詢ID找等級權限2
	public Level getLevelById(Integer id) {
		
		Level level = null;
		
		Optional<Level> optional = backendLevelRepository.findById(id);
		
		if(optional.isPresent()) {
			
			level = optional.get();
			
		}
		
		return level;
		
	}
	
	
	
	// 查詢ID刪除權限等級
	@Transactional
	public void deleteLevelById(Integer id) {
		
		Optional<Level> optional = backendLevelRepository.findById(id);
		
		if(optional.isPresent()) {
			
			backendLevelRepository.deleteById(id);
			
		}
		
	}
	
	
	
	// 分頁功能
	public Page<Level> findLevelByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "plevel");
		
		Page<Level> page = backendLevelRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
//	####################### i am divider #######################
	
	
	
	// 查詢全部權限清單，準備給預先注入權限等級欄位使用
	public List<Level> getLevelList(){
		
		List<Level> list = backendLevelRepository.findAll();
		
		return list;
		
	}
	
	
	
	
	
	
	
	
	

}
