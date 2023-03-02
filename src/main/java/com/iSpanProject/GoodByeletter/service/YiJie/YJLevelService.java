package com.iSpanProject.GoodByeletter.service.YiJie;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.YiJie.YJLevelDao;
import com.iSpanProject.GoodByeletter.model.YiJie.YJLevel;

@Service
@Transactional
public class YJLevelService {
	
	@Autowired
	private YJLevelDao lDao;
	
	public void insert(YJLevel lev) {
		lDao.save(lev);
	}
//	
//	public Register updateById(Integer id,String account,String password) {
//		Optional<Register> optional = rDao.findById(id);
//		
//		if(optional.isPresent()) {
//			Register register = optional.get();
//			register.setAccount(account);
//			register.setAccount(password);
//			return register;
//		}
//		System.out.println("no update");
//		return null;
//	}
}
