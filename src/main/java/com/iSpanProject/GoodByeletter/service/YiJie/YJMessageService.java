package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.model.YiJie.YJMessages;
import com.iSpanProject.GoodByeletter.model.YiJie.YJMessagesDao;



@Service
@Transactional //此位置沒有(readOnly=true)
public class YJMessageService {

	@Autowired //做一個控制容器，會去找有註解
	private YJMessagesDao mDao;
	
	//@Transactional //@Transactional(readOnly=true) 唯讀模式=>使用該模式如果又修改資料，則修改不會永久保留置資料庫
	public void insert(YJMessages msg) {
		mDao.save(msg);
	}
	public YJMessages findById(Integer id) {
		Optional<YJMessages> optional = mDao.findById(id);
		
		if(optional.isEmpty() ) {
			return null;
		}return optional.get();			
	}
	
	public void deleteById(Integer id) {
		mDao.deleteById(id);
	}
	
	public void deleteByEntity(YJMessages msg) {
		mDao.delete(msg);
	}
	
	public Page<YJMessages> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of( pageNumber-1, 3, Sort.Direction.DESC, "added"); //PageRequest.of(從第幾頁開始(-1), 一頁有幾筆資料, 排序方式, "使用得屬性");
		
		Page<YJMessages> page = mDao.findAll(pgb);
		return page;
	}
	
	public YJMessages updateById(Integer id, String newMsg) {
		Optional<YJMessages> optional = mDao.findById(id);
	
		if(optional.isPresent()) { //當他是永續物件時
			YJMessages msg = optional.get();
			msg.setText(newMsg); //直接改值
			return msg;
			
		}System.out.println("沒有更新這筆資料");
		return null;
	}
}
