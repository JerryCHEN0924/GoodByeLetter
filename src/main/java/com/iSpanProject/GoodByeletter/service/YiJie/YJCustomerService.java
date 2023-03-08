package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Lillian.LevelDao;
import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
@Transactional
public class YJCustomerService {

	@Autowired
	private RegisterDao customerDao;
	
	///////////////////////
	@Autowired
	private LevelDao levDao;
	
	
	////////////////////////////
	public void insert(Register customer) {
		
		////////////////////
		Optional<Level> optional = levDao.findById(2);
		Level lev1 = optional.get();
		customer.setFK_Plevel(lev1);
		////////////////////
		
		customerDao.save(customer);
	}
	//////////////////////
	
	//findById => 找相同id名的YJCustomer物件
	public Register findById(Integer id) {
		Optional<Register> optional = customerDao.findById(id);
		
		if(optional.isPresent()) {
			Register cus = optional.get();
			return cus;
		}return null;	
	}
	
//	用來做登入	
	public Register findByAccAndPass(String acc, String pass) {
		Register accAndpass = customerDao.findRegisterByAccAndPwd(acc, pass);
		return accAndpass;
	}
	
//
	public Register updateBymemberId(Integer id, String acc, String pass) {
		Optional<Register> optional = customerDao.findById(id);
		
		if (optional.isPresent()) {
			Register cus1 = optional.get();
			cus1.setAccount(acc);
			cus1.setPassword(pass);
			return cus1;
		}
		System.out.println("no update");
		return null;
	}
	
	public List<Register> findAll() {
		return customerDao.findAll();	
	}
	/////////////////////
	public Register getRegById(Integer id) {
        Optional<Register> register = customerDao.findById(id);
        if (register.isPresent()) {
        	return null;
        }
		return register.get();
		
    }
	/////////////////////
}
