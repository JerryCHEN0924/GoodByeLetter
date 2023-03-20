package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.Ryu.VendorPhotos;

public interface BackendVendorPhotosRepository extends JpaRepository<VendorPhotos, Integer> {
	
	
	
	// 廣告文案啟用專用
	@Query(value="from VendorPhotos where enabled = true")
	public List<VendorPhotos> findVendorPhotosByEnabledTrue();
	
	
	
	// 後台首頁查詢廣告文案專用
	@Query(value="select * from VendorPhotos where title like concat('%',:t,'%')", nativeQuery = true)
	public Page<VendorPhotos> findAllByTitleQueryLikePage(@Param("t") String title, Pageable pageable);
	
	
	

}
