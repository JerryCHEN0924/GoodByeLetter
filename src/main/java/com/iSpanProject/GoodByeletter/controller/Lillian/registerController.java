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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;
import com.iSpanProject.GoodByeletter.service.Lillian.RegisterService;

@Controller
public class registerController {

	@Autowired
	private RegisterService registerService;
	@Autowired
	private RegisterDao registerDao;
	@Autowired
	private MemberDetailService memberDetailService;

//註冊帳號
	@PostMapping("/register/add")
	public String saveRegister(@RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password, Model model) {
		
		try {
			// 創建一個空的HashMap對象"errors"，將"errors"對象存儲到Model對象中
			Map<String, String> errors = new HashMap<String, String>();

			if (account == null || account.length() == 0) {
				errors.put("account", "請輸入您的帳號!");
			}

			if (password == null || password.length() == 0) {
				errors.put("password", "請輸入您的密碼!");
			}
			if (registerService.findByAcc(account) != null) {
				errors.put("account", "該帳號已被註冊!");
			}
			model.addAttribute("errors", errors);
			if (errors != null && !errors.isEmpty()) {
				return "redirect:/";
			}

			Register newRegister = new Register();
			newRegister.setAccount(account);
			newRegister.setPassword(password);

			registerService.insert(newRegister);
			///////////
			Register registerNew = registerService.findByAccAndPwd(account, password);
			Integer memberId = registerNew.getMemberId();
			model.addAttribute("memberId", memberId);
			////////////
			Map<String, String> msg = new HashMap<String, String>();
			model.addAttribute("msg", msg);
			msg.put("success", "會員註冊成功!");

			return "Lillian/addMemberDetail";

		} catch (Exception e) {
			e.printStackTrace();
			return "Lillian/myregister";
		}
	}
	
	@GetMapping("/register1")
	public String register1() {
		return "Lillian/myregister";
	}

//登入
	@PostMapping("/register/login")
	public String login(@RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password,
			// @RequestParam(value="memberId") Integer memberId,
			HttpSession session, Model model) {

		Register existing = registerService.findByAccAndPwd(account, password);
		model.addAttribute("register", existing);
		String acc = existing.getAccount();
		String pwd = existing.getPassword();

		if (account.equals(acc) && password.equals(pwd)) {
			session.setAttribute("existing", existing);

			return "redirect:/";
		} else {
			return "redirect:/login1";
		}
	}

	@GetMapping("/login1")
	public String login1() {
		return "Lillian/login";
	}

//登出
	@GetMapping("/register/logout")
	public String logoutRegister(HttpSession session) {
//		session.removeAttribute("acc");
//		session.removeAttribute("pwd");
		session.invalidate();
		return "redirect:/";
	}

//編輯帳號
	@GetMapping("/register/edit")
	public String editRegisterPage(@RequestParam Integer memberId, Model model) {// model儲存送過去
		Register register = registerService.findById(memberId);
		model.addAttribute("registers", register);
		return "Lillian/registerEdit";
	}

	@PutMapping("/register/putRegister")
	public String updateEdit(@ModelAttribute("register") Register register) {

		registerService.updateRegister(register);

		return "redirect:/";
	}

}
