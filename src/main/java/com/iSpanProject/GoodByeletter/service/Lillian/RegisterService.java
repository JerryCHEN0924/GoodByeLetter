package com.iSpanProject.GoodByeletter.service.Lillian;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
@Transactional
public class RegisterService {

	@Autowired
	private RegisterDao rDao;

//	@Autowired
//	private LevelDao lDao;

	public void insert(Register register) {
		
//	        // 查詢權限等級為 2 的 Level 對象
//	        Level level = lDao.findByLevel(2);
//	        
//	        // 設置 Register 對象的權限等級為 2
//	        register.setFK_Plevel(level);
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
