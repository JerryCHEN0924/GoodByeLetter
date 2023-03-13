package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iSpanProject.GoodByeletter.dao.YiJie.PictureDao;
import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDetailDao;
import com.iSpanProject.GoodByeletter.model.YiJie.Picture;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;

@Service
@Transactional
public class PictureService {

	@Autowired
	private YJCustomerDetailDao dDao;
	@Autowired
	private PictureDao pDao;
	
	//0311-建立新的picture
	public void insertPicture(Picture picture) {
		picture.setEnable(false);//將Enable初始值設定為false
		pDao.save(picture);
	}
	//0311-用memberId找Picture
//	public Picture findPictureByMemberId(Integer memberId) {
//		Picture picture = pDao.findPictureBymemberId(memberId);
//		return picture;
//	}
	//
	
}
