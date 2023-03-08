package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Lillian.LevelDao;
import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;

@Service
@Transactional
public class YJCustomerDetailService {

	@Autowired
	private YJCustomerDetailDao cdDao;
	@Autowired
	private LevelDao levDao;
	
	public void insert(YJCustomerDetail detail) {
		Optional<Level> optional = levDao.findById(2);
		Level lev1 = optional.get();
		detail.setPlevel(lev1);
		
		cdDao.save(detail);	
	}
	
	public YJCustomerDetail updateDetail(YJCustomerDetail detail) {	
		return cdDao.save(detail);
	}
}
