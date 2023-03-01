package com.iSpanProject.GoodByeletter.controller.Tina;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.dao.Tina.Register01Dao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Tina.Register01;

@Controller
public class register01Controller {

	@Autowired
	private Register01Dao register01Dao;
	
	
	//@ResponseBody物件序列化成JSON丟出來反序列化變成JAVA物件
	@ResponseBody
	@PostMapping("/register01/add")
	public Register01 saveRegister(@RequestBody Register01 register01) {
		return register01Dao.save(register01);
		
	}
		
	

}
