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

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendVendorPhotosRepository;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorPhotos;





@Service
@Transactional
public class BackendVendorPhotosService {
	
	
	@Autowired
	private BackendVendorPhotosRepository backendVendorPhotosRepository;
	
	
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增廠商文案資料
	public void insertVendorPhotos(VendorPhotos VendorPhotos) {
		
		backendVendorPhotosRepository.save(VendorPhotos);
		
	}
	
	// 分頁功能
	public Page<VendorPhotos> findByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "vendorPhotosId");
		
		Page<VendorPhotos> page = backendVendorPhotosRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	// 更新廠商文案資料
	public void updateVendorPhotos(VendorPhotos VendorPhotos) {
		
		backendVendorPhotosRepository.save(VendorPhotos);
		
	}
	
	
	// 查ID找廠商文案資料
	public VendorPhotos findById(Integer vendorPhotosId) {
		
		Optional<VendorPhotos> optional = backendVendorPhotosRepository.findById(vendorPhotosId);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		return optional.get();
		
	}
	
	
	
	
	// 查ID刪除廠商文案資料
	public void deleteById(Integer vendorPhotosId) {
		
		Optional<VendorPhotos> optional = backendVendorPhotosRepository.findById(vendorPhotosId);
		
		if(optional.isPresent()) {
			
			backendVendorPhotosRepository.deleteById(vendorPhotosId);
			
		}
		
	}
	
	
	
	
	
	
	
	
	// 查詢所有廠商文案資料
	public List<VendorPhotos> getAllVendorPhotos(){
		
		List<VendorPhotos> allVendorPhotos = backendVendorPhotosRepository.findAll();
		
		return allVendorPhotos;
		
	}
	
	
	
	// 查詢所有廠商文案資料ByEnabledTrue
	public List<VendorPhotos> getAllVendorPhotosByEnabledTrue(){
		
		List<VendorPhotos> allVendorPhotosByEnabledTrue = backendVendorPhotosRepository.findVendorPhotosByEnabledTrue();
		
		return allVendorPhotosByEnabledTrue;
		
	}
	
	
	
	
	// 分頁功能，Title模糊查詢
	public Page<VendorPhotos> findAllByTitleQueryLikePage(String title, Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 10, Sort.Direction.ASC, "vendorPhotosId");
		
		Page<VendorPhotos> page = backendVendorPhotosRepository.findAllByTitleQueryLikePage(title, pgb);
		
		return page;
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
