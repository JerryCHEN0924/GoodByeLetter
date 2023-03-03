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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.iSpanProject.GoodByeletter.dao.Ryu.MemberRepositoryByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.LevelByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;
import com.iSpanProject.GoodByeletter.service.Ryu.LevelServiceByRyu;
import com.iSpanProject.GoodByeletter.service.Ryu.MemberServiceByRyu;

@Controller
@SessionAttributes({"authenticated"})
public class MemberControllerByRyu {
	
	@Autowired
	private MemberRepositoryByRyu memberRepository;
	
	@Autowired
	private MemberServiceByRyu memberServiceByRyu;
	
	@Autowired
	private LevelServiceByRyu levelServiceByRyu;
	
	
	
	@GetMapping("/topGun/backendHome")
	public String backendHome() {
		
		return "/Ryu/backendHome";
		
	}
	
	
	@GetMapping("/topGun")
	public String loginProcess(Model model) {
		
		return "Ryu/ryuzLoginForm";
		
	}
	
	
	
	
	
	
	
	
	@ResponseBody
	@PostMapping("/memberByRyu/addTest")
	public MemberByRyu saveMember() {
		
//		LevelByRyu l1 = new LevelByRyu();
//		l1.setLevelName("會員");
		
		
		MemberByRyu m1 = new MemberByRyu();
		m1.setAccount("liFour");
		m1.setPassword("liFour");
//		m1.setLevel(l1);
		
		MemberByRyu returnM = memberRepository.save(m1);
		return returnM;
		
		
		
	}
	
	
	
	@GetMapping("/topGun/memberByRyu/add")
	public String addNewMemberForm(Model model) {
		
		MemberByRyu m1 = new MemberByRyu();
		model.addAttribute("memberByRyu", m1);
		
		return "/Ryu/ryuzAddMember";
		
	}
	
	
	@PostMapping("/topGun/memberByRyu/post")
	public String addNewMemberPost(@ModelAttribute("memberByRyu") MemberByRyu memberByRyu, Model model) {
		//...
		//...
		
		memberServiceByRyu.insertMember(memberByRyu);
		
		MemberByRyu m2 = new MemberByRyu();
		model.addAttribute("memberByRyu", m2);
		
		
		return "/Ryu/ryuzAddMember";
	}
	
	
	
	@GetMapping("/topGun/memberByRyu/page")
	public String showMemberByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<MemberByRyu> page = memberServiceByRyu.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/ryuzShowMember";
		
	}
	
	
	@GetMapping("/topGun/memberByRyu/edit")
	public String editMemberPage(@RequestParam("memberId") Integer memberId, Model model) {
		
		MemberByRyu m1 = memberServiceByRyu.findById(memberId);
		
		model.addAttribute("memberByRyu", m1);
		
		
		return "/Ryu/ryuzEditMember";
		
	}
	
	
	
	
	@PutMapping("/topGun/memberByRyu/editPost")
	public String editPostMember(@ModelAttribute("memberByRyu") MemberByRyu memberByRyu) {
		
		memberServiceByRyu.updateMember(memberByRyu);
		
		return "redirect:/topGun/memberByRyu/page";
	}
	
	
	
	
	
	
	@DeleteMapping("/topGun/memberByRyu/delete")
	public String deleteMember(@RequestParam("memberId") Integer memberId) {
		
		System.out.println("================================");
		System.out.println("================================");
		System.out.println("================================");
		System.out.println(memberId);
		System.out.println("================================");
		System.out.println("================================");
		System.out.println("================================");
		
		memberServiceByRyu.deleteById(memberId);
		
		return "redirect:/topGun/memberByRyu/page";
	}
	
	
	
	
	@ModelAttribute("pLevelList")
	public Map<Integer, String> getPLevelList(){
		
		
		Map<Integer, String> levelMap = new HashMap<>();
		List<LevelByRyu> list = levelServiceByRyu.getLevelList();
		
		for(LevelByRyu l1: list) {
			
			levelMap.put(l1.getpLevel(), l1.getLevelName());
			
		}
		
		System.out.println("-------------------------");
		System.out.println(levelMap);
		System.out.println("-------------------------");
		
		return levelMap;
		
	}
	
	
//	@GetMapping("/topGun/memberByRyu/login")
//	public String loginProcess(Model model) {
//		
//		
//		return "Ryu/ryuzLoginForm";
//		
//		
//	}
	
	
	
	
	
//	@GetMapping("/topGun/memberByRyu/goLogin")
//	public String loginProcess(@RequestParam("account") String account,@RequestParam("password") String password, Model model) {
//		
//		boolean checkAccountAndPassword = memberServiceByRyu.checkAccountAndPassword(account, password);
//		
//		if(checkAccountAndPassword) {
//			
//			
//			
//		}
//		
//		
//	}
	
	@PostMapping("/topGun/memberByRyu/LoginProcess")
	public String loginProcess(@RequestParam("account") String account,@RequestParam("password") String password,
								HttpServletRequest request, Model model) {
		
		MemberByRyu memberByRyu = memberServiceByRyu.login(account, password);
		
		  if (memberByRyu != null) {
			  
			  model.addAttribute("authenticated", memberByRyu);
	            return "redirect:/topGun/backendHome";
		  }
		  
		  else {
	            // 登入失敗，返回登入表單
	            return "Ryu/ryuzLoginForm";
	        }
		  
		  
	}
	
	@GetMapping("/topGun/memberByRyu/LogoutProcess")
	public String logoutProcess(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:/topGun";
	}
	
	
	
	
//	@PostMapping("/topGun/memberByRyu/goLogin2")
//	public String loginProcess(@ModelAttribute("memberByRyu") MemberByRyu memberByRyu, HttpServletRequest request, Model model) {
//		
//		String account = memberByRyu.getAccount();
//		String password = memberByRyu.getPassword();
//		
//		MemberByRyu m1 = memberServiceByRyu.login(account, password);
//		
//		
//		System.out.println("-------------------------");
//		System.out.println("-------------------------");
//		System.out.println("-------------------------");
//		System.out.println(m1);
//		System.out.println("-------------------------");
//		System.out.println("-------------------------");
//		System.out.println("-------------------------");
//		
//		
//		
//		if (m1 != null) {
//			
//			model.addAttribute("authenticated", m1);
//			return "redirect:/topGun";
//			
//		}
//		
//		else {
//			// 登入失敗，返回登入表單
//			return "Ryu/ryuzLoginForm2";
//		}
//		
//		
//	}
	
	
	
	
	
	
//	@ModelAttribute("authenticated")
//	public MemberByRyu test98(HttpServletRequest request, Model model) {
//		
//		MemberByRyu memberByRyu = new MemberByRyu();
//			
//		return memberByRyu;
//		
//	}
	
	


}
