package com.iSpanProject.GoodByeletter.dao.Ryu;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iSpanProject.GoodByeletter.model.YiJie.Picture;

public interface BackendVendorPhotosBackupRepository extends JpaRepository<Picture, Integer> {
	
	
	
//	// 廣告文案啟用專用
//	@Query(value="from VendorPhotos where enabled = true")
//	public List<VendorPhotos> findVendorPhotosByEnabledTrue();
//	
//	
//	
//	// 後台首頁查詢廣告文案專用
//	@Query(value="select * from VendorPhotos where title like concat('%',:t,'%')", nativeQuery = true)
//	public Page<VendorPhotos> findAllByTitleQueryLikePage(@Param("t") String title, Pageable pageable);
	
	
	

}
