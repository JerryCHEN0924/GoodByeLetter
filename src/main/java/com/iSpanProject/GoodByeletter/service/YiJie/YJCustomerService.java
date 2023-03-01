package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDao;
import com.iSpanProject.GoodByeletter.dao.YiJie.YJLevelDao;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomer;
import com.iSpanProject.GoodByeletter.model.YiJie.YJLevel;

@Service
@Transactional
public class YJCustomerService {

	@Autowired
	private YJCustomerDao CustomerDao;
	
	///////////////////////
	@Autowired
	private YJLevelDao levDao;
	
	
	////////////////////////////
	public void insert(YJCustomer customer) {
		////////////////////
		Optional<YJLevel> optional = levDao.findById(2);
		YJLevel lev1 = optional.get();
		customer.setLevel(lev1);
		////////////////////
		CustomerDao.save(customer);
	}
}
