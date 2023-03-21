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

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendVendorDetailsRepository;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorDetails;







@Service
@Transactional
public class BackendVendorDetailsService {
	
	
	@Autowired
	private BackendVendorDetailsRepository backendVendorDetailsRepository;
	
//	@Autowired
//	private BackendMemberRepository backendMemberRepository;
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	
	// 新增廠商細項資料
	public void insertVendorDetails(VendorDetails vendorDetails) {
		
		backendVendorDetailsRepository.save(vendorDetails);
		
	}
	
	
	// 分頁功能
	public Page<VendorDetails> findByPage(Integer pageNumber){
		
//		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "vendorDetailsId");
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "vendorDetailsId");
		
		Page<VendorDetails> page = backendVendorDetailsRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	// 更新廠商細項資料
	public void updateVendorDetails(VendorDetails vendorDetails) {
		
		backendVendorDetailsRepository.save(vendorDetails);
		
	}
	
	
	
	// 查ID找廠商細項資料
	public VendorDetails findById(Integer vendorDetailsId) {
		
		Optional<VendorDetails> optional = backendVendorDetailsRepository.findById(vendorDetailsId);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		return optional.get();
		
	}
	
	
	
	// 查ID刪除廠商細項資料
	public void deleteById(Integer vendorDetailsId) {
		
		Optional<VendorDetails> optional = backendVendorDetailsRepository.findById(vendorDetailsId);
		
		if(optional.isPresent()) {
			
			backendVendorDetailsRepository.deleteById(vendorDetailsId);
			
		}
		
	}
	
	
	// 查詢所有廠商細項資料
	public List<VendorDetails> getAllVendorDetails(){
		
		List<VendorDetails> allVendorDetails = backendVendorDetailsRepository.findAll();
		
		return allVendorDetails;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
