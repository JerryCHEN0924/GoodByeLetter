package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.Ryu.MemberRepository;
import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;

@Service
public class MemberService {
	
	
	
	
	@Autowired
	private MemberRepository memberDao;

	public MemberService() {
		
	
	}
	
	public MemberByRyu findById(Integer id) {
		
		Optional<MemberByRyu> optional = memberDao.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		
		return optional.get();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
