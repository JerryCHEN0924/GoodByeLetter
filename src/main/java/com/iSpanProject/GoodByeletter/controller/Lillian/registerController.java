package com.iSpanProject.GoodByeletter.controller.Lillian;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.RegisterService;

@Controller
public class registerController {

	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private RegisterService registerService;

	@PostMapping("/register/add")
	public String saveRegister(@RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password, Model model) {

//		Map<String,String> errors = new HashMap <String,String>();
//		model.addAttribute("errors",errors);
//		
//		if(account == null || account.length() == 0) {
//			errors.put("account", "必填");			
//		}
//		
//		if(password == null || password.length() == 0) {
//			errors.put("password", "必填");			
//		}
//		
//		Register existingRegister = registerDao.findRegisterByAcc(acc);
//		if(existingRegister != null) {
//			return "已有此帳號!";
//		}

//		Register existingRegister = registerDao.findRegisterByAcc(acc);
//		if( existingRegister != null ) {
//			return "已有此帳號!";
//		}

		Register newRegister = new Register();
		newRegister.setAccount(account);
		newRegister.setPassword(password);

		registerService.insert(newRegister);
		Map<String, String> msg = new HashMap<String, String>();
		model.addAttribute("msg", msg);
		msg.put("success", "會員註冊成功!");

		return "Lillian/addMemberDetail";
	}

	@GetMapping("/register1")
	public String register1() {
		// newRegister.getMemberId();
		return "Lillian/myregister";

	}

	@PostMapping("/register/login")
	public String login(@RequestParam(value="account") String account, @RequestParam(value="password") String password, HttpSession session) {
	
		Register existing = registerService.findByAccAndPwd(account, password);

		String acc = existing.getAccount();
		String pwd = existing.getPassword();
		
		if (account.equals(acc) && password.equals(pwd)) {
			session.setAttribute("acc", acc);
			session.setAttribute("pwd", pwd);
			
			return "redirect:/";
		} else {
			return "redirect:/login1";
			
		}
		
		
//		Register existingRegister = registerService.findByAccAndPwd(registerDao.getAccount(), Register.getPassword());
		// if (existingRegister != null &&
		// existingRegister.getPassword().equals(existingRegister.getPassword())) {




		
//	else{
//		return "redirect:/login";
//	}
}

	@GetMapping("/login1")
	public String login1() {
		// newRegister.getMemberId();
		return "Lillian/login";
	}

	@GetMapping("/myregister/logout")
	public String logoutRegister(HttpSession session) {
		session.removeAttribute("acc");
		session.removeAttribute("pwd");
		return "redirect:/";
	}

}
