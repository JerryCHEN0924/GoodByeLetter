package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.iSpanProject.GoodByeletter.dao.YiJie.PictureDao;
import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDetailDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.Picture;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
import com.iSpanProject.GoodByeletter.service.YiJie.PictureService;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;

@Controller
@SessionAttributes("exis")
public class PictureController {

	@Autowired
	private YJCustomerDetailDao cdDao;
	@Autowired
	private PictureDao pDao;
	
	//圖片頁面1
	@GetMapping("/customer/picture/page1")
	public String picturePage1() {
		return "YiJie/updatePic";
	}
	//圖片頁面2
	@GetMapping("/customer/picture/page2")
	public String picturePage2() {
		return "YiJie/upPicture2";
	}
	
	//圖片上傳
	@ResponseBody
	@PostMapping("/customer/picture/updata1")
	public String upPicture(@ModelAttribute("exis") Register exis,
							//@RequestParam("files") byte[] files,//
							@RequestParam("files") MultipartFile[] files,
							Model model) throws IOException {
		
		Integer mId = exis.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		Integer dId = detail.getId();
		
		List<Picture> photos = detail.getPictures();
		
		
		for(MultipartFile file:files) {
			Picture picture = new Picture();
			byte[] pictureByte = file.getBytes();//有throws IOException才能用
			
			//picture.setId(mId);
			picture.setPhotoFile(pictureByte);
			picture.setEnable(false);
			
			photos.add(picture);
		}
		//detail.getPictures().clear();會導致整筆資料被覆蓋(包含picture的id
		
		detail.setPictures(photos);
		cdDao.save(detail);
			
		return "okok";
	}
	//////////////////////////////////
	//圖片列表葉面
	@GetMapping("/customer/picture/list")//把該使用者存取的圖片一一列出(沒有值)
	public String listPicture(@ModelAttribute("exis") Register exis,
			Model model) {
		Integer mId = exis.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		
		List<Picture> listPicture = detail.getPictures();
		model.addAttribute("listPicture",listPicture);
		
		return "YiJie/listPicture";
	}
	//<img src='...?id=1' />拿到id=1
	@ResponseBody
	@GetMapping("/customer/picture/pictureIds")//拿出每張圖片的id(與上方圖片列對應)
	public List<Integer> getPictureID(@RequestParam Integer detailId,
			@ModelAttribute("exis") Register exis){
		//Integer mId = exis.getMemberId();
		//YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
//		YJCustomerDetail detail = cdDao.getReferenceById(detailId);
//		
//		List<Picture> listPicture = detail.getPictures();
//		List<Integer> PictureIds = new ArrayList<>();
//		
//		for(Picture picture: listPicture) {
//			Integer picId = picture.getId();
//			PictureIds.add(picId);
//		}return PictureIds;
//		
		Integer mId = exis.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		
		List<Picture> photos = detail.getPictures();
		List<Integer> PictureIds = new ArrayList<>();
		for(Picture pic: photos) {
			PictureIds.add(pic.getId());
			
		}
		
		return PictureIds;
	}
	//取出圖片位置的值
	@GetMapping("/customer/picture/image")
	public ResponseEntity<byte[]> getPictureImage(//@ModelAttribute("exis") Register exis,
													@RequestParam Integer photoId){
//		Integer mId = exis.getMemberId();
//		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		
		Optional<Picture> op = pDao.findById(photoId);
		
		if(op.isPresent()) {
			Picture picture = op.get();
			byte[] pictureFile = picture.getPhotoFile();
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureFile);
		}return null;
		
	}
	////////////////////////////////////////實驗場////////////////////////////////////////
	
	
	
	
	@ResponseBody
	@PostMapping("/customer/picture/updata2")
	public List<String> upPicture2(@ModelAttribute("exis") Register exis,
							@RequestParam("files") MultipartFile[] files,
							Model model) throws IOException {
		Integer mId = exis.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		//Integer dId = detail.getId();
		
		List<Picture> photos = detail.getPictures();
		
		
		for(MultipartFile file:files) {
			Picture picture = new Picture();
			byte[] pictureByte = file.getBytes();//有throws IOException才能用
			
			picture.setPhotoFile(pictureByte);
			picture.setEnable(false);
			
			photos.add(picture);
		}
	
		detail.setPictures(photos);
		cdDao.save(detail);
		
		// 將圖片資料轉換成可供前端使用的格式
	    List<String> photoUrls = new ArrayList<>();
	    for (Picture photo : photos) {
	        // 使用 Base64 編碼將 byte[] 轉換成字串
	        String photoData = Base64.getEncoder().encodeToString(photo.getPhotoFile());
	        String photoUrl = "data:image/jpeg;base64," + photoData; // 假設這裡是 JPEG 格式
	        photoUrls.add(photoUrl);
	    }
	    return photoUrls;
	}
	//去資料庫撈圖片
	@GetMapping("/customer/picture/listPicture")
	public List<Integer> getPictures(@ModelAttribute("exis") Register exis) {
		Integer mId = exis.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		
		List<Picture> photos = detail.getPictures();
		List<Integer> PictureIds = new ArrayList<>();
		for(Picture pic: photos) {
			PictureIds.add(pic.getId());
			
		}
		
		return PictureIds;
	}
	public void getPicturefile(@RequestParam Integer pictureId) {
		
		//Optional<Picture> op = pDao.findById(pictureId);
		//if(op.isPresent()) {
			
		//}
//		byte [] pic = pDao.	
	}
	
	
	////////////////////////////////////////////////////////////////////
	//保存到資料夾/images/-(未啟用)
	
	////////////////////////////////////
//	public void abcd (Model model) {
//		//抓session物件  mvc6-3前半小時
//		Register res = (Register) model.getAttribute("exis");
//	}	
		
	
	
	
}
