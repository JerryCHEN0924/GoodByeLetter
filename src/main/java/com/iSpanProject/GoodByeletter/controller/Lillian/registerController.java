package com.iSpanProject.GoodByeletter.controller.Lillian;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.RegisterService;

@Controller
public class registerController {
	
	@Autowired
	private RegisterService registerService;
	
	 
	@PostMapping("/register/add")
	public String saveRegister(@RequestParam(value="account") String account,@RequestParam(value="password") String password,Model model) {
	
//			Map<String,String> errors=new HashMap<String,String>();
//			model.addAttribute("errors",errors);
//			
//			if(account == null || account.length() == 0) {
//				errors.put("account","必填!");
//			}
//				
//			if(password == null || password.length() == 0) {
//					errors.put("password","必填!");
//			}
		
		Register newRegister = new Register();
		newRegister.setAccount(account);
		newRegister.setPassword(password);
		
		registerService.insert(newRegister);
		   Map<String, String> msg = new HashMap<String, String>();
		   model.addAttribute("msg", msg);
		   msg.put("success", "會員註冊成功!");
		
//		Register existingRegister = registerDao.findRegisterByAcc(acc);
//		if( existingRegister != null ) {
//			return "已有此帳號!";
//		}
		
	
			return "example/myregister";
			
	}
	
	@GetMapping("/register1")
	public String register1() {
		return "example/myregister";
	}

}
