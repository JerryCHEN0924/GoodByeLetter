package com.iSpanProject.GoodByeletter.service.YiJie;

import java.util.List;
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
	//找出所有圖片
	public List<Picture> getAllPicture(){
		return pDao.findAll();
	}
	//依照id找圖片
	public Optional<Picture> getPictureById(Integer id) {
		return pDao.findById(id);
	}
	//由id山圖片
	public void deletePictureById(Integer id) {
		pDao.deleteById(id);
	}
}
