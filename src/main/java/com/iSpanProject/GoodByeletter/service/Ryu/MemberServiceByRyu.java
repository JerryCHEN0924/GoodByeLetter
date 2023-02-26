package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Ryu.LevelRepositoryByRyu;
import com.iSpanProject.GoodByeletter.dao.Ryu.MemberRepository;
import com.iSpanProject.GoodByeletter.model.Ryu.LevelByRyu;
import com.iSpanProject.GoodByeletter.model.Ryu.MemberByRyu;

@Service
public class MemberServiceByRyu {
	
	
	
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private LevelRepositoryByRyu levelRepositoryByRyu;
	

	public MemberServiceByRyu() {
		
	}
	
	
	
	public void insert(MemberByRyu memberByRyu) {
		
		Optional<LevelByRyu> levelByRyu = levelRepositoryByRyu.findById(4);
			
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
	public void deleteById(Integer id) {
		
		memberRepository.deleteById(id);
		
	}
	
	
	
	public void deleteByEntity(MemberByRyu memberByRyu) {
		
		memberRepository.delete(memberByRyu);
		
	}
	
	
	public Page<MemberByRyu> findByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "memberId");
		
		Page<MemberByRyu> page = memberRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
