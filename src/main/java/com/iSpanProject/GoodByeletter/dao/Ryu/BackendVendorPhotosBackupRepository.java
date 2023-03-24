package com.iSpanProject.GoodByeletter.dao.Ryu;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.YiJie.Picture;

public interface BackendVendorPhotosBackupRepository extends JpaRepository<Picture, Integer> {
	
	
	
//	// 廣告文案啟用專用
//	@Query(value="from VendorPhotos where enabled = true")
//	public List<VendorPhotos> findVendorPhotosByEnabledTrue();
	
	
	
	// 後台首頁查詢廣告文案專用
//	@Query(value="select * from picture where fk_companydetail_id :pid", nativeQuery = true)
//	public Page<Picture> findByFkCompanydetailIdPage(@Param("pid") String pid, Pageable pageable);
	
	@Query(value="select * from picture where fk_companydetail_id = :pid", nativeQuery = true)
	public List<Picture> findAllByCDId(@Param("pid") Integer pid);

}
