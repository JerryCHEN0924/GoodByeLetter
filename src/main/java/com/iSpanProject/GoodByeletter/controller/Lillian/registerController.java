package com.iSpanProject.GoodByeletter.controller.Lillian;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
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
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
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
	public String saveRegister(@ModelAttribute("newRegister") Register register, Model model) {

		try {
			// 創建一個空的HashMap對象"errors"，將"errors"對象存儲到Model對象中
			Map<String, String> errors = new HashMap<String, String>();
			model.addAttribute("errors", errors);

			if (register.getAccount() == "") {
				errors.put("account", "請輸入您的帳號!");
			}

			if (register.getPassword() == "") {
				errors.put("password", "請輸入您的密碼!");
			}
			if (registerService.findByAcc(register.getAccount()) != null) {
				errors.put("account1", "該帳號已被註冊!");
			}

//			model.addAttribute("errors", errors);
			if (!errors.isEmpty()) {
				return "Lillian/myregister";
			}

			registerService.insert(register);
			///////////
			Register registerNew = registerService.findByAccAndPwd(register.getAccount(), register.getPassword());
			Integer memberId = registerNew.getMemberId();
			model.addAttribute("memberId", memberId);
			////////////
			MemberDetail md = new MemberDetail();
//			Register reg = registerService.findById(memberId);
//			md.setFK_memberId(reg);
//			memberDetailService.insert(md);

			model.addAttribute("memberDetails", md);

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
	public String register1(Model model) {
		Register newRegister = new Register();
		model.addAttribute("newRegister", newRegister);
		return "Lillian/myregister";
	}

//登入
	@PostMapping("/register/login")
	public String login(@RequestParam(value = "account") String account,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "rememberMe", required = false) String rememberMe, HttpSession session, Model model,
			HttpServletResponse response) {

		Register existing = registerService.findByAccAndPwd(account, password);
		model.addAttribute("register", existing);
		String acc = existing.getAccount();
		String pwd = existing.getPassword();

		if (account.equals(acc) && password.equals(pwd)) {
			session.setAttribute("existing", existing);
///////////////////////////////////////////////////
		// 自動登入
			System.out.println(rememberMe);
		if (rememberMe != null && rememberMe.equals("1")) {
			// 如果用戶驗證成功，則創建一個包含用戶身份信息的Cookie，然後將其添加到HTTP響應中
			Cookie cookie = new Cookie("memberId", existing.getMemberId().toString());
			System.out.println(existing.getMemberId().toString());
			cookie.setMaxAge(60 * 60 * 24 * 7); // 設置Cookie的過期時間為一周
			response.addCookie(cookie);
			}
///////////////////////////////////////////////////			
			return "index";
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
