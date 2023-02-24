package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Ryu.MemberRepository;
import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;

@Controller
public class MemberControllerByRyu {
	
	@Autowired
	private MemberRepository memberDao;
	
	
	@ResponseBody
	@PostMapping("/memberByRyu/addTest")
	public MemberByRyu saveMember() {
		
//		LevelByRyu l1 = new LevelByRyu();
//		l1.setLevelName("會員");
		
		
		MemberByRyu m1 = new MemberByRyu();
		m1.setAccount("liFour");
		m1.setPassword("liFour");
//		m1.setLevel(l1);
		
		MemberByRyu returnM = memberDao.save(m1);
		return returnM;
		
		
		
	}
	


}
