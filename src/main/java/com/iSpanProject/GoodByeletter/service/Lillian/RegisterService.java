package com.iSpanProject.GoodByeletter.service.Lillian;

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
public class RegisterService {

	@Autowired
	private RegisterDao rDao;

	@Autowired
	private LevelDao lDao;



	public void insert(Register register) {
		
		// 查詢權限等級為 1 的 Level 對象
		Optional<Level> optional = lDao.findById(1);
		Level l1 = optional.get();
		 // 設置 Register 對象的權限等級為 1
		register.setFK_Plevel(l1);

		rDao.save(register);

	}


	public Register findRegisterById(Integer id) {
		Optional<Register> optional = rDao.findById(id);

		if (optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public Register findByAccAndPwd(String account,String password) {
		Register findByAccAndPwd =rDao.findRegisterByAccAndPwd(account,password);
		return findByAccAndPwd;
	}
	
	public Register findById(Integer memberId) {
		Optional<Register> optional = rDao.findById(memberId);
		
		if(optional.isEmpty()) { 
			return null;
		}
		return optional.get();		
	}

	public Register updateRegister(Register reg) {
		return rDao.save(reg);
	}	

	public String updateById(Integer memberId, String account, String password) {
		Optional<Register> optional = rDao.findById(memberId);

		if (optional.isPresent()) {
			Register register = optional.get();
			register.setAccount(account);
			register.setAccount(password);
			//return register;
		}
		System.out.println("no update");
		return null;
	}

	public List<Register> findAll() {
		return rDao.findAll();	
	}


	
}
