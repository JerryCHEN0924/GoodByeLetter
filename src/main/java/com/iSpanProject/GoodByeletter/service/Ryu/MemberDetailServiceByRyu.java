package com.iSpanProject.GoodByeletter.service.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.Ryu.MemberDetailRepositoryByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.MemberDetailByRyu;






@Service
public class MemberDetailServiceByRyu {
	
	
	@Autowired
	private MemberDetailRepositoryByRyu memberDetailRepositoryByRyu;
	
	
	

	public void insert(MemberDetailByRyu memberDetailByRyu) {
		
		memberDetailRepositoryByRyu.save(memberDetailByRyu);
		
	}

}
