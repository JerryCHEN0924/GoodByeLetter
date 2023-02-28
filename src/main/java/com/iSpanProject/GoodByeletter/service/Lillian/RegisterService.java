package com.iSpanProject.GoodByeletter.service.Lillian;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
@Transactional
public class RegisterService {

	@Autowired
	private RegisterDao rDao;

	public void insert(Register register) {
		rDao.save(register);
	}

	public Register updateById(Integer id, String account, String password) {
		Optional<Register> optional = rDao.findById(id);

		if (optional.isPresent()) {
			Register register = optional.get();
			register.setAccount(account);
			register.setAccount(password);
			return register;
		}
		System.out.println("no update");
		return null;
	}
}
