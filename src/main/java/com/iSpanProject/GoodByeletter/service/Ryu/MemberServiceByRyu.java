package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Ryu.LevelRepositoryByRyu;
import com.iSpanProject.GoodByeletter.dao.Ryu.MemberRepositoryByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.LevelByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;

@Service
public class MemberServiceByRyu {
	
	
	
	
	@Autowired
	private MemberRepositoryByRyu memberRepository;
	
	@Autowired
	private LevelRepositoryByRyu levelRepositoryByRyu;
	
//	@Autowired
//	private MemberValidator memberValidator;
	

	public MemberServiceByRyu() {
		
	}
	
	
	
	public void insertMember(MemberByRyu memberByRyu) {
		
		Integer pId = memberByRyu.getpId();
		
		Optional<LevelByRyu> levelByRyu = levelRepositoryByRyu.findById(pId);
			
		LevelByRyu l2 = levelByRyu.get();
			
		memberByRyu.setLevelByRyu(l2);
		
		memberRepository.save(memberByRyu);
		
	}
	
	public void updateMember(MemberByRyu memberByRyu) {
		
		Integer pId = memberByRyu.getLevelByRyu().getpLevel();
		
		Optional<LevelByRyu> levelByRyu = levelRepositoryByRyu.findById(pId);
		
		LevelByRyu l2 = levelByRyu.get();
		
		memberByRyu.setLevelByRyu(l2);
		
		memberRepository.save(memberByRyu);
		
	}
	
	
	public MemberByRyu findById(Integer id) {
		
		Optional<MemberByRyu> optional = memberRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		return optional.get();
		
	}
	
	@Transactional
	public void deleteById(Integer memberId) {
		
		Optional<MemberByRyu> optional = memberRepository.findById(memberId);
		
		if(optional.isPresent()) {
			
			memberRepository.deleteById(memberId);
			
		}
		
		
	}
	
	
	
	public void deleteByEntity(MemberByRyu memberByRyu) {
		
		memberRepository.delete(memberByRyu);
		
	}
	
	
	public Page<MemberByRyu> findByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "memberId");
		
		Page<MemberByRyu> page = memberRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	
	public boolean checkAccountAndPassword(String account, String password) {
		
		boolean caap = false;
		
		List<MemberByRyu> list = memberRepository.findMemberByRyuByAccountAndPassword(account, password);
		
		if(!list.isEmpty()) {
			caap = true;
		}
		
		return caap;
	}
	
	
	
	public MemberByRyu login(String account, String password) {
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println(account);
		System.out.println(password);
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println("-------------------");
		
		MemberByRyu m1 = memberRepository.findMemberByAccount(account);
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println(m1);
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println("-------------------");
		
		if(m1.getPassword().equals(password)) {
			
			return m1;
			
		}
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
//	 public void checkValidWithMember(MemberByRyu memberByRyu) {
//		 
//		 memberValidator.accountValid(memberByRyu, null, null);
//		 
//	 }
	
	
	
	
	
	
	

}
