package com.iSpanProject.GoodByeletter.controller.Lillian;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Controller
public class registerController {

	@Autowired
	private RegisterDao registerDao;
	
	
	//@ResponseBody物件序列化成JSON丟出來反序列化變成JAVA物件
	@ResponseBody
	@PostMapping("/register/add")
	public Register saveRegister(@RequestBody Register register) {
		return registerDao.save(register);
		
	}
	
	
	
	public registerController() {
		
	}

}
