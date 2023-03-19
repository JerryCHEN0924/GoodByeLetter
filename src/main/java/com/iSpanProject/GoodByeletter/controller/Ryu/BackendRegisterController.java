package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendLevelService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;



@Controller
@SessionAttributes({"authenticated", "existing"})
@RequestMapping("/topGun")
public class BackendRegisterController {
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
	@Autowired
	private BackendLevelService backendLevelService;
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 後台首頁跳轉
	@GetMapping("/backendHome")
	public String backendHome() {
		
		return "/Ryu/backendHome";
		
	}
	
//	@GetMapping("/topGun")
//	public String loginProcess(Model model) {
//		
//		return "Ryu/backendLoginForm";
//		
//	}
	
	
	
//	####################### test divider start #######################
	
	public Register saveRegister() {
		
		Register register = new Register();
		
		register.setAccount("liFour");
		register.setPassword("liFour");
		
		Register newRegister = backendRegisterRepository.save(register);
		
		return newRegister;
		
	}
	
	
	
	
	
	
//	####################### test divider end #######################
	
	
	
	// 新增註冊會員跳頁
	@GetMapping("/register/add")
	public String addNewRegisterForm(Model model) {
		
		Register register = new Register();
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendAddNewRegisterForm";
		
	}
	
	
	
	// 新增註冊會員
	@PostMapping("/register/post")
	public String addNewRegisterPost(@ModelAttribute("register") Register register, Model model,
			 RedirectAttributes redirectAttributes) {
		
		String account = register.getAccount();
		
		backendRegisterService.insertRegister(register);
		
//		Register newRegister = new Register();
//		
//		model.addAttribute("register", newRegister);
//		
//		return "/Ryu/backendAddNewRegisterForm";
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員帳號 [ " + account + " ] 新增成功");
		
		return "redirect:/topGun/register/add";
		
	}
	
	
	
	// 分頁查詢註冊會員資料
	@GetMapping("/register/page")
	public String showRegisterByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		
		Page<Register> page = backendRegisterService.findRegisterByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowRegister";
		
	}
	
	
	
	// 修改註冊會員資料跳頁
	@GetMapping("/register/edit")
	public String editRegisterPage(@RequestParam("memberId") Integer memberId, Model model) {
		
		Register register = backendRegisterService.findRegisterById(memberId);
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendEditRegisterForm";
		
	}
	
	
	
	// 修改註冊會員資料
	@PutMapping("/register/editPost")
	public String editPostRegister(@ModelAttribute("register") Register register,
			 RedirectAttributes redirectAttributes) {
		
		String account = register.getAccount();
		
		backendRegisterService.updateRegister(register);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員帳號 [ " + account + " ] 修改成功");
		
		return "redirect:/topGun/register/page";
		
	}
	
	
	
	// 刪除註冊會員資料
	@DeleteMapping("/register/delete")
	public String deleteRegister(@RequestParam("memberId") Integer memberId,
			 RedirectAttributes redirectAttributes) {
		
		System.out.println("================================");
		System.out.println("================================");
		System.out.println(memberId);
		System.out.println("================================");
		System.out.println("================================");
		
		Register presentRegister = backendRegisterService.findRegisterById(memberId);
		
		String account = presentRegister.getAccount();
		
		backendRegisterService.deleteRegisterById(memberId);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員帳號 [ " + account + " ] 刪除成功");
		
		return "redirect:/topGun/register/page";
		
	}
	
	
	
	// 註冊會員表單預先注入權限等級欄位
	@ModelAttribute("plevelList")
	public Map<Integer, String> getPLevelList(){
		
		Map<Integer, String> levelMap = new HashMap<>();
		
		List<Level> list = backendLevelService.getLevelList();
		
		for(Level level : list) {
			
			levelMap.put(level.getPlevel(), level.getLevelName());
			
		}
		
		System.out.println("-------------------------");
		System.out.println(levelMap);
		System.out.println("-------------------------");
		
		return levelMap;
		
	}
	
//	######################################################
//	######################################################
	
	
	
	// 模擬會員登入跳頁，新增留言
	@GetMapping("/register/addLoginFormWithBoard")
	public String loginProcessForm(Model model) {
		
		return "Ryu/backendLoginFormWithBoard";
		
	}
	
	
	
	
	
	
	// 模擬會員登入，新增留言
	@PostMapping("/register/LoginProcessWithBoard")
	public String loginProcessWithBoard(@RequestParam("account") String account,@RequestParam("password") String password,
								HttpServletRequest request, Model model) {
		
		Register register = backendRegisterService.login(account, password);
		
		if (register != null) {
			  
			  model.addAttribute("existing", register);
			  
	            return "redirect:/topGun/board/add";
	            
		  }
		  
		  else {
	            // 登入失敗，返回登入表單
	            return "Ryu/backendLoginFormWithBoard";
	        }
		
	}
	
	
	
	
	
	// 模擬會員登出，新增留言
	@GetMapping("/register/LogoutProcessWithBoard")
	public String logoutProcessWithBoard(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:/topGun/board/add";
	}
	
	
	
//	======================= Block =======================
	
	
	
	// 模擬會員登入跳頁，新增留言
		@GetMapping("/register/addLoginFormWithLastNote")
		public String loginProcessFormWithLastNote(Model model) {
			
			return "Ryu/backendLoginFormWithLastNote";
			
		}
	
	
	
	// 模擬會員登入，新增LastNote
		@PostMapping("/register/LoginProcessWithLastNote")
		public String loginProcessWithLastNote(@RequestParam("account") String account,@RequestParam("password") String password,
				HttpServletRequest request, Model model) {
			
			Register register = backendRegisterService.login(account, password);
			
			if (register != null) {
				
				model.addAttribute("existing", register);
				
				return "redirect:/topGun/lastNote/add";
				
			}
			
			else {
				// 登入失敗，返回登入表單
				return "Ryu/backendLoginFormWithLastNote";
			}
			
		}
		
		
		// 模擬會員登出，新增留言
		@GetMapping("/register/LogoutProcessWithLastNote")
		public String logoutProcessWithLastNote(SessionStatus status) {
			
			status.setComplete();
			
			return "redirect:/topGun/lastNote/add";
		}
		
//		======================= Block =======================
		
		
		
		// 模擬會員登入跳頁，後台首頁選單
		@GetMapping("/register/addLoginFormImitation")
		public String loginProcessFormImitation(Model model) {
			
			return "Ryu/backendLoginFormImitation";
			
		}
		
		
		
		// 模擬會員登入，後台首頁選單
		@PostMapping("/register/LoginProcessImitation")
		public String loginProcessImitation(@RequestParam("account") String account,@RequestParam("password") String password,
				HttpServletRequest request, Model model) {
			
			Register register = backendRegisterService.login(account, password);
			
			if (register != null) {
				
				model.addAttribute("existing", register);
				
				return "redirect:/topGun";
				
			}
			
			else {
				// 登入失敗，返回登入表單
				return "Ryu/backendLoginFormImitation";
			}
			
		}
		
		
		
		// 模擬會員登出，後台首頁選單
		@GetMapping("/register/LogoutProcessImitation")
		public String logoutProcessImitation(SessionStatus status) {
			
			status.setComplete();
			
			return "redirect:/topGun";
		}
		
	
	
//	######################################################
//	######################################################
	
	
	
	// 依帳號模糊查詢跳頁
	@GetMapping("/register/queryLikeAccount")
	public String getRegisterByAccountForm(Model model) {
		
		return "/Ryu/backendShowRegisterByAccount";
		
	}
	
	
	
	
	
	
	
	// 依帳號模糊查詢
	@GetMapping("/register/queryLikeAccountPost")
	public String getRegisterByAccount(@RequestParam("account") String account, Model model) {
		
		List<Register> register = backendRegisterService.findRegisterByAccountNativeLikeQuery(account);
		
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(register);
		System.out.println("=====================");
		System.out.println("=====================");
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendShowRegisterByAccount";
		
	}
	
	
	
	
	// 修改註冊會員Enabled跳頁
	@GetMapping("/registerEnabled/edit")
	public String editRegisterEnablePage(@RequestParam("memberId") Integer memberId, Model model) {
			
	Register register = backendRegisterService.findRegisterById(memberId);
			
	model.addAttribute("register", register);
			
	return "/Ryu/backendEditRegisterEnabledForm";
			
	}
	
	
	
	
	// 修改註冊會員Enabled資料
	@PutMapping("/registerEnabled/editPost")
	public String editPostRegisterEnabled(@ModelAttribute("register") Register register) {
			
		backendRegisterService.updateRegister(register);
			
		return "redirect:/topGun/register/queryLikeAccount";
			
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	

}
