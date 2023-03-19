package com.iSpanProject.GoodByeletter.service.Ryu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendMemberDetailRepository;
import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
@Transactional
public class BackendMemberDetailService {
	
	
	@Autowired
	private BackendMemberDetailRepository backendMemberDetailRepository;
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增會員細項資料
	public void insertMemberDetail(MemberDetail memberDetail) {
		
		String account = memberDetail.getAccount();
		
		Register register = backendRegisterRepository.findRegisterByAccount(account);
		
		memberDetail.setFK_memberId(register);
		
		memberDetail.setFK_Plevel(register.getFK_Plevel());
		
		backendMemberDetailRepository.save(memberDetail);
		
	}
	
	
	// 分頁功能
	public Page<MemberDetail> findByPage(Integer pageNumber){
				
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "id");
				
		Page<MemberDetail> page = backendMemberDetailRepository.findAll(pgb);
				
		return page;
				
	}
	
	
	
	// 查詢ID找會員細項資料
	public MemberDetail findMemberDetailById(Integer id) {
		
		Optional<MemberDetail> optional = backendMemberDetailRepository.findById(id);
		
		if(optional.isEmpty()) {
			
			return null;
			
		}
		
		return optional.get();
		
	}
	
	// 查詢ID找會員細項資料2
	public MemberDetail getMemberDetailById(Integer id) {
		
		MemberDetail memberDetail = null;
			
		Optional<MemberDetail> optional = backendMemberDetailRepository.findById(id);
			
		if(optional.isPresent()) {
					
			memberDetail = optional.get();
					
		}
		
		return memberDetail;
			
	}
	
	
	// 查詢ID刪除註冊會員細項資料
//	@Transactional
	public void deleteMemberDetailById(Integer id) {
		
		Optional<MemberDetail> optional = backendMemberDetailRepository.findById(id);
		
		if(optional.isPresent()) {
			
			
			System.out.println("=======================");
			System.out.println("======確認 MemberDetail 為 "+ id + " ========");
			System.out.println("=======================");
			System.out.println("=======================");
			System.out.println("======執行 Repo 刪除 MemberDetail========");
			System.out.println("=======================");
			
//			backendMemberDetailRepository.deleteById(id);
			
			backendMemberDetailRepository.deleteById(id);
			
//			backendMemberDetailRepository.deleteAll();
			
		} else {
			
			System.out.println("=======================");
			System.out.println("======執行 Repo 失敗========");
			System.out.println("=======================");
			
		}
		
	}
	
	
	
	
	
	// 修改會員細項資料
	public void updateMemberDetail(MemberDetail memberDetail) {
		
		backendMemberDetailRepository.save(memberDetail);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
