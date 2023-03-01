package com.iSpanProject.GoodByeletter.controller.Lillian;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
=======
>>>>>>> cfe05aa490c9edba01a31550bb2e785b03eb97a0
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

<<<<<<< HEAD
=======
import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
>>>>>>> cfe05aa490c9edba01a31550bb2e785b03eb97a0
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
		//newRegister.getMemberId();
		return "example/myregister";

	}
	
	
	
	public registerController() {
		

	}
	
	@PostMapping("/register/login")
    public String login(@ModelAttribute Register register, HttpSession session) {
		Register existingRegister = registerService.findByAccAndPwd(register.getAccount(), register.getPassword());
        if (existingRegister != null && existingRegister.getPassword().equals(existingRegister.getPassword())) {
        	String acc=existingRegister.getAccount();
        	String pwd=existingRegister.getPassword();

        	session.setAttribute("acc",acc);
        	session.setAttribute("pwd",pwd);
        	
        	
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
	
	@GetMapping("/login1")
	public String login1() {
		//newRegister.getMemberId();
		return "Lillian/login";
	}
	
	@GetMapping("/myregister/logout")
    public String logoutRegister(HttpSession session) {
        session.removeAttribute("acc");
        session.removeAttribute("pwd");
        return "redirect:/";
    }

}
