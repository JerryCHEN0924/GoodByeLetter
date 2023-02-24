package com.iSpanProject.GoodByeletter.controller.Lillian;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Controller
public class registerController {

	@Autowired
	private RegisterDao registerDao;
	
	@ResponseBody //@ResponseBody物件序列化成JSON丟出來反序列化變成JAVA物件
	@PostMapping("/register/add")
	public String saveRegister(@RequestBody Register register,@RequestBody MemberDetail memberDetail) {
		String acc = register.getAccount();
		String pwd = register.getPassword();
		
		Register existingRegister = registerDao.findRegisterByAcc(acc);
		if( existingRegister != null ) {
			return "已有此帳號!";
		}
			
		registerDao.save(register);
		
		return "成功!";
	}
	

}
