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

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendVendorDetailsBackupRepository;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;




@Service
@Transactional
public class BackendVendorDetailsBackupService {
	
	
	
	@Autowired
	private BackendVendorDetailsBackupRepository backendVendorDetailsBackupRepository;
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	
	// 新增廠商細項資料
	public void insertVendorDetailsBackup(YJCustomerDetail vendorDetails) {
		
		backendVendorDetailsBackupRepository.save(vendorDetails);
		
	}
	
	
	// 分頁功能
	public Page<YJCustomerDetail> findByPage(Integer pageNumber){
		
//		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.DESC, "id");
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "id");
		
		Page<YJCustomerDetail> page = backendVendorDetailsBackupRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	// 更新廠商細項資料
	public void updateVendorDetails(YJCustomerDetail vendorDetails) {
		
		backendVendorDetailsBackupRepository.save(vendorDetails);
		
	}
	
	
	// 查ID找廠商細項資料
	public YJCustomerDetail findById(Integer id) {
		
		Optional<YJCustomerDetail> optional = backendVendorDetailsBackupRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		return optional.get();
		
	}
	
	
	
	// 查ID刪除廠商細項資料
	public void deleteById(Integer id) {
		
		Optional<YJCustomerDetail> optional = backendVendorDetailsBackupRepository.findById(id);
		
		if(optional.isPresent()) {
			
			backendVendorDetailsBackupRepository.deleteById(id);
			
		}
		
	}
	
	
	
	
	// 查詢所有廠商細項資料
	public List<YJCustomerDetail> getAllVendorDetails(){
		
		List<YJCustomerDetail> allVendorDetails = backendVendorDetailsBackupRepository.findAll();
		
		return allVendorDetails;
		
	}
	
	
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	

}
