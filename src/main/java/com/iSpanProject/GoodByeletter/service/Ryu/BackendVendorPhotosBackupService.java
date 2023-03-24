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

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendVendorPhotosBackupRepository;
import com.iSpanProject.GoodByeletter.model.YiJie.Picture;




@Service
@Transactional
public class BackendVendorPhotosBackupService {
	
	
	@Autowired
	private BackendVendorPhotosBackupRepository backendVendorPhotosBackupRepository;
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	// 新增廠商文案資料
	public void insertVendorPhotos(Picture picture) {
		
		backendVendorPhotosBackupRepository.save(picture);
		
	}
	
	
	
	// 分頁功能
	public Page<Picture> findByPage(Integer pageNumber){
		
		Pageable pgb = PageRequest.of(pageNumber-1, 6, Sort.Direction.DESC, "id");
		
		Page<Picture> page = backendVendorPhotosBackupRepository.findAll(pgb);
		
		return page;
		
	}
	
	
	
	// 更新廠商文案資料
	public void updateVendorPhotos(Picture picture) {
		
		backendVendorPhotosBackupRepository.save(picture);
		
	}
	
	
	
	// 查ID找廠商文案資料
	public Picture findById(Integer id) {
		
		Optional<Picture> optional = backendVendorPhotosBackupRepository.findById(id);
		
		if(optional.isEmpty()) {
			return null;
		}
		
		return optional.get();
		
		
	}
	
	
	
	// 查ID刪除廠商文案資料
	public void deleteById(Integer id) {
		
		Optional<Picture> optional = backendVendorPhotosBackupRepository.findById(id);
		
		if(optional.isPresent()) {
			
			backendVendorPhotosBackupRepository.deleteById(id);
			
		}
		
	}
	
	
	
	// 查詢所有廠商文案資料
	public List<Picture> getAllVendorPhotos(){
		
		List<Picture> allVendorPhotos = backendVendorPhotosBackupRepository.findAll();
		
		return allVendorPhotos;
		
	}
	
	
	// 查詢所有廠商文案資料 By fk_companydetail_id
	public List<Picture> getAllVendorPhotosByFkCompanydetailId(Integer pid){
		
		
		List<Picture> currentPhotos = backendVendorPhotosBackupRepository.findAllByCDId(pid);
		
		return currentPhotos;
		
		
	}
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	
	

}
