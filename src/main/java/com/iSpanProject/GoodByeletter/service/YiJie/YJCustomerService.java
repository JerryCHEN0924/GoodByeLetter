package com.iSpanProject.GoodByeletter.service.YiJie;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDao;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomer;

@Service
@Transactional
public class YJCustomerService {

	@Autowired
	private YJCustomerDao CustomerDao;
	
	public void insert(YJCustomer customer) {
		CustomerDao.save(customer);
	}
}
