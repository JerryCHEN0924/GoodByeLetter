package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Controller
@SessionAttributes({"existing", "username", "exis", "name", "userPrincipal"})
//@RequestMapping("/topGun")
public class BackendPageController {
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	
	
	// 後台首頁入口
	@GetMapping("/topGun")
	public String enterBackendHome() {
		
		return "/Ryu/backendHome";
		
	}
	
	
	
	
	
	
	
//	@GetMapping("/user/login")
//	public String template() {
		
//		BackendMember m1 = new BackendMember();
//		model.addAttribute("backendMember", m1);
		
//		return "/Ryu/backendHome";
		
//	}
	
	
//	@GetMapping(value="/lastNoteLogin", produces = "application/javascript")
//	public String lastNoteLogin() {
//		
//		return "loginForm";
//		
//	}
	
	
	
//	@GetMapping(value="/lastNoteLogin", produces = "text/css")
//	public String lastNoteLogin() {
//		
//		return "loginForm";
//		
//	}
	
	
	
//	@GetMapping(value="/lastNoteLogin", produces = "text/html")
//	public String lastNoteLogin() {
//		
//		return "loginForm";
//		
//	}
	
	
	
	@GetMapping("/lastNoteLogin")
	public String lastNoteLogin() {
		
		return "/Ryu/loginForm";
		
	}
	
	
	
	@GetMapping("/lastNoteLogout")
	public String lastNoteLogout() {
		
		return "index";
		
	}
	
//	@GetMapping("/successLogin")
////	@PostMapping("/home")
//	public String home(Model model) {
//		
//		return "successMessage";
//		
//	}
	
	
	
	@GetMapping("/successLogin")
//	@PostMapping("/home")
	public String home(Model model, Principal principal) {
		
		String username = principal.getName(); // 從Principal對象中獲取用戶名
		
		
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("username = " + username);
		System.out.println("=======================");
		System.out.println("=======================");
		
		
		
		
		Register register = backendRegisterRepository.findRegisterByAccount(username);
		
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("register = " + register);
		System.out.println("=======================");
		System.out.println("=======================");
		
		
//		model.addAttribute("existing", register);
		
		
		
//		Level fk_Plevel = register.getFK_Plevel();
//		
//		
//		String string = fk_Plevel.toString();
//		
//		
//		System.out.println("====================");
//		System.out.println("====================");
//		System.out.println("string123 = " +string);
//		System.out.println("====================");
//		System.out.println("====================");
		
//		
//		if(string == "1" ) {
//			
//			model.addAttribute("existing", register);
//			
//		}else {
//			
//			model.addAttribute("exis", register);
//			
//		}
		
		List<Level> roles = Arrays.asList(register.getFK_Plevel());
		
		
		List<String> roleIds4 = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
		String rolesString4 = String.join(",", roleIds4);
		
		
		System.out.println("============");
		System.out.println("============");
		System.out.println("roleIds4 = " + roleIds4);
		System.out.println("rolesString4 = " + rolesString4);
		System.out.println("============");
		System.out.println("============");
		
		
		
		if(rolesString4.equals("一般會員") ) {
		
		model.addAttribute("existing", register);
		
		}else if(rolesString4.equals("廣告商") ){
			
			model.addAttribute("exis", register);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "Ryu/successMessage";
		
	}
	
	
	
	// 測試從 Session 中取得 Username
//	@GetMapping("/getTest")
//	@ResponseBody
//	public String getTest(Model model) {
//		
//		String getTest = (String) model.getAttribute("username");
//		
//		return getTest;
////		return "123456";
//		
//	}
	
	@GetMapping("/getTest")
//	@ResponseBody
	public String getTest(Principal principal) {
		
//	    String username = principal.getName(); // 從Principal對象中獲取用戶名
//	    
//	    return username;
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		
//		System.out.println("testtesttest");
//		System.out.println(auth.getName());
		
		return null;
	    
	}
	
//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	
//	System.out.println("testtesttest");
//	System.out.println(auth.getName());
	
	
//	@GetMapping("/getTest")
//	@ResponseBody
//	public String getTest(Authentication authentication) {
//	    String username = authentication.getName(); // 獲取用戶名
//	    // 其他認證訊息
//	    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // 獲取用戶權限
//	    Object credentials = authentication.getCredentials(); // 獲取用戶憑證訊息，如密码
//	    boolean isAuthenticated = authentication.isAuthenticated(); // 判斷用戶是否已認證
//	    // 其他訊息 ...
//	    return username;
//	}
	
	
	
	
	
	
//	@GetMapping("/")
//	public String home() {
//		
//		return "/Ryu/backendHome";
//		
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
