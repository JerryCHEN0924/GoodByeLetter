package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.Optional;

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
	private YJCustomerDao customerDao;
	
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
		
		customerDao.save(customer);
	}
	//////////////////////
	
//	findById => 找相同id名的YJCustomer物件
	public YJCustomer findById(Integer id) {
		Optional<YJCustomer> optional = customerDao.findById(id);
		
		if(optional.isPresent()) {
			YJCustomer cus = optional.get();
			return cus;
		}return null;	
	}
//	用來做登入	
	public YJCustomer findByAccAndPass(String acc, String pass) {
		YJCustomer accAndpass = customerDao.findCustomerByAccAndPwd(acc, pass);
		return accAndpass;
	}
	
//
	public YJCustomer updateById(Integer id, String acc, String pass) {
		Optional<YJCustomer> optional = customerDao.findById(id);
		
		if (optional.isPresent()) {
			YJCustomer cus1 = optional.get();
			cus1.setAcc(acc);
			cus1.setPass(pass);
			return cus1;
		}
		System.out.println("no update");
		return null;
	}
	
	/////////////////////
}
