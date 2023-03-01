package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDetailDao;
import com.iSpanProject.GoodByeletter.dao.YiJie.YJLevelDao;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
import com.iSpanProject.GoodByeletter.model.YiJie.YJLevel;

@Service
@Transactional
public class YJCustomerDetailService {

	@Autowired
	private YJCustomerDetailDao cdDao;
	@Autowired
	private YJLevelDao levDao;
	
	public void insert(YJCustomerDetail detail) {
		Optional<YJLevel> optional = levDao.findById(2);
		YJLevel lev1 = optional.get();
		detail.setPlevel(lev1);
		
		cdDao.save(detail);
		
	}
}
