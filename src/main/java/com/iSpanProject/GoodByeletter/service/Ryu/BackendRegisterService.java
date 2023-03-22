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

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendLevelRepository;
import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Service
public class BackendRegisterService {
	
	
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	@Autowired
	private BackendLevelRepository backendLevelRepository;
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增註冊會員
	public void insertRegister(Register register) {
		
		Integer pId = register.getpId();
		
		System.out.println("================");
		System.out.println(pId);
		System.out.println("================");
		
		Optional<Level> level = backendLevelRepository.findById(pId);
		
		if(level.isEmpty()) {
			
			return;
			
		}
		
		Level selectLevel = level.get();
		
		register.setFK_Plevel(selectLevel);
		
		backendRegisterRepository.save(register);
		
	}
	
	
	
	// 查詢ID找註冊會員
	public Register findRegisterById(Integer id) {
		
		Optional<Register> optional = backendRegisterRepository.findById(id);
		
		if(optional.isEmpty()) {
			
			return null;
			
		}
		
		return optional.get();
		
	}
	
	
	
	// 查詢ID找註冊會員2
	public Register getRegisterById(Integer id) {
		
		Register register = null;
		
		Optional<Register> optional = backendRegisterRepository.findById(id);
		
		if(optional.isPresent()) {
			
			register = optional.get();
			
		}
		
		return register;
		
	}
	
	
	
	// 查詢ID刪除註冊會員
	@Transactional
	public void deleteRegisterById(Integer id) {
		
		Optional<Register> optional = backendRegisterRepository.findById(id);
		
			if(optional.isPresent()) {
			
				backendRegisterRepository.deleteById(id);
			
		}
		
		
	}
	
	
	
	// 分頁功能
	public Page<Register> findRegisterByPage(Integer pageNumber){
		
//		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "memberId");
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "memberId");
		
		Page<Register> page = backendRegisterRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	// 暫時沒用到
	// 驗證登入者輸入之帳號密碼
//	public boolean checkAccountAndPassword(String account, String password) {
//		
//		boolean caap = false;
//		
//		List<Register> list = backendRegisterRepository.findRegisterByAccountAndPassword(account, password);
//		
//		if(!list.isEmpty()) {
//			
//			caap = true;
//			
//		}
//		
//		return caap;
//		
//	}
	
	
	
	// 驗證登入者輸入之帳號密碼
	public Register login(String account, String password) {
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println(account);
		System.out.println(password);
		System.out.println("-------------------");
		System.out.println("-------------------");
		
		Register register = backendRegisterRepository.findRegisterByAccount(account);
		
		System.out.println("-------------------");
		System.out.println("-------------------");
		System.out.println(register);
		System.out.println("-------------------");
		System.out.println("-------------------");
		
		if(register.getPassword().equals(password)) {
			
			return register;
			
		}
		
		return null;
		
	}
	
	
	
	// 修改註冊會員資料
	public void updateRegister(Register register) {
		
		Integer plevel = register.getFK_Plevel().getPlevel();
		
		Optional<Level> level = backendLevelRepository.findById(plevel);
		
		Level registerLevel = level.get();
		
		System.out.println("===============");
		System.out.println(registerLevel);
		System.out.println("===============");
		
		register.setFK_Plevel(registerLevel);
		
		backendRegisterRepository.save(register);
		
	}
	
	
	
	
	
	// 模糊查詢依Account
	public List<Register> findRegisterByAccountNativeLikeQuery(String account){
		
		return backendRegisterRepository.findRegisterByAccountNativeLikeQuery(account);
		
	}
	
	
	
	
	// 分頁功能，Account模糊查詢
	public Page<Register> findAllByAccountQueryLikePage(String account, Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "memberId");
		
		Page<Register> page = backendRegisterRepository.findAllByAccountQueryLikePage(account, pgb);
		
		return page;
		
	}
	
	
	
	// 分頁功能，Account模糊查詢廣告商
	public Page<Register> findAllVentorBackupsByAccountQueryLikePage(String account, Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "memberId");
		
		Page<Register> page = backendRegisterRepository.findAllVentorsBackupByAccountQueryLikePage(account, pgb);
		
		return page;
		
	}
	
	
	
	

}
