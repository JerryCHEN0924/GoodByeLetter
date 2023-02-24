package com.iSpanProject.GoodByeletter.controller.Lillian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Lillian.MemberDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;

@Controller
public class MemberDetailController {

	@Autowired
	private MemberDetailDao memberDetailDao;
	
	@ResponseBody
	@PostMapping("/MemberDetail/add2")
	public MemberDetail saveMemberDetail(@RequestBody MemberDetail memberDetail) {
				
		return memberDetailDao.save(memberDetail);		
	}
}
