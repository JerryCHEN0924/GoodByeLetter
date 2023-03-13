package com.iSpanProject.GoodByeletter.dao.YiJie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iSpanProject.GoodByeletter.model.YiJie.Picture;

public interface PictureDao extends JpaRepository<Picture, Integer> {

	//0311新增查詢方式:1.用FK_memberId找Picture 2.用memberId找Picture
//	@Query("from Picture where FK_ComDetailId.FK_memberId = :FK_memberId")
//	public Picture findPictureByFK_memberId(@Param(value="FK_memberId")Integer FK_memberId);
	
//	@Query("from Picture where FK_ComDetailId.FK_memberId.memberId = :memberId")
//	public Picture findPictureBymemberId(@Param(value="memberId")Integer memberId);
	//////////
}
