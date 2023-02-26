package com.iSpanProject.GoodByeletter.controller.Ryu;

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

import com.iSpanProject.GoodByeletter.dao.Ryu.MemberRepository;
import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;
import com.iSpanProject.GoodByeletter.service.Ryu.MemberServiceByRyu;

@Controller
public class MemberControllerByRyu {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberServiceByRyu memberServiceByRyu;
	
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
		
		memberServiceByRyu.insert(memberByRyu);
		
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
		
		memberServiceByRyu.insert(memberByRyu);
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	


}
