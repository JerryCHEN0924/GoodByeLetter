package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	//綠
		//show.jsp的跳頁
		@GetMapping("/customer/add")
		public String pictureAdd(Model model) {	
			List<YJCustomerDetail> lawyers = cdDao.findByType("律師");
		    Set<Picture> allPictures = new HashSet<>();//用Set來避免重複取值
		    for (YJCustomerDetail lawyer : lawyers) {
		        List<Picture> pictures = lawyer.getPictures();
		        allPictures.addAll(pictures);
		    }
		    model.addAttribute("listPicture", allPictures);
			return "YiJie/show";
		}
		@ResponseBody
		@GetMapping("/customer/picture/lawyerimage")
		public ResponseEntity<byte[]> getlawyerImage(@RequestParam Integer pictureId) throws IOException {
			Optional<Picture> op = pDao.findById(pictureId);
			
			if(op.isPresent()) {
				Picture picture = op.get();
				byte[] pictureFile = picture.getPhotoFile();
				return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureFile);
			}return null;
		}////////////////////////////////////////////////////////
	//禮
	//show2.jsp的跳頁
		@GetMapping("/customer/add2")
		public String pictureAdd2(Model model) {	
			List<YJCustomerDetail> morts = cdDao.findByType("禮儀社");	
		    Set<Picture> allPictures = new HashSet<>();//用Set來避免重複取值
		    for (YJCustomerDetail mort : morts) {
		        List<Picture> pictures = mort.getPictures();
		        allPictures.addAll(pictures);
		    }
		    
		    model.addAttribute("listPicture", allPictures);
			return "YiJie/show2";
		}
	@ResponseBody
	@GetMapping("/customer/picture/mortimage")
	public ResponseEntity<byte[]> getmortImage(@RequestParam Integer pictureId) throws IOException {
		Optional<Picture> op = pDao.findById(pictureId);
		
		if(op.isPresent()) {
			Picture picture = op.get();
			byte[] pictureFile = picture.getPhotoFile();
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureFile);
		}return null;
	}
	////////////////////////////////////////////////////////////
	//諮
	//show3.jsp的跳頁
		@GetMapping("/customer/add3")
		public String pictureAdd3(Model model) {	
			List<YJCustomerDetail> counsels = cdDao.findByType("諮商師");
			
		    Set<Picture> allPictures = new HashSet<>();//用Set來避免重複取值
		    for (YJCustomerDetail counsel : counsels) {
		        List<Picture> pictures = counsel.getPictures();
		        allPictures.addAll(pictures);
		    }
		    
		    model.addAttribute("listPicture", allPictures);
			return "YiJie/show3";
		}
	@ResponseBody
	@GetMapping("/customer/picture/counselimage")
	public ResponseEntity<byte[]> getcounselImage(@RequestParam Integer pictureId) throws IOException {
		Optional<Picture> op = pDao.findById(pictureId);
		
		if(op.isPresent()) {
			Picture picture = op.get();
			byte[] pictureFile = picture.getPhotoFile();
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureFile);
		}return null;
	}//////////////////////////////////
	//其
	//show4.jsp的跳頁
		@GetMapping("/customer/add4")
		public String pictureAdd4(Model model) {	
			List<YJCustomerDetail> others = cdDao.findByType("其他");
			
		    Set<Picture> allPictures = new HashSet<>();//用Set來避免重複取值
		    for (YJCustomerDetail other : others) {
		        List<Picture> pictures = other.getPictures();
		        allPictures.addAll(pictures);
		    }
		    
		    model.addAttribute("listPicture", allPictures);
			return "YiJie/show4";
		}
	@ResponseBody
	@GetMapping("/customer/picture/otherimage")
	public ResponseEntity<byte[]> getotherImage(@RequestParam Integer pictureId) throws IOException {
		Optional<Picture> op = pDao.findById(pictureId);
		
		if(op.isPresent()) {
			Picture picture = op.get();
			byte[] pictureFile = picture.getPhotoFile();
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureFile);
		}return null;
	}
	//#####################################################################//
	//圖片上傳
	@ResponseBody
	@PostMapping("/customer/picture/updata1")
	public String upPicture(@ModelAttribute("exis") Register exis,
							//@RequestParam("files") byte[] files,//
							@RequestParam("files") MultipartFile[] files,
							Model model) throws IOException {
		
		Integer mId = exis.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		
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
		if(photos==null) {
			return "YiJie/updatePic";
		}
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
	public ResponseEntity<byte[]> getPictureImage(@RequestParam Integer photoId){
		Optional<Picture> op = pDao.findById(photoId);
		
		if(op.isPresent()) {
			Picture picture = op.get();
			byte[] pictureFile = picture.getPhotoFile();
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(pictureFile);
		}return null;
		
	}
	////////////////////////////////////////實驗場////////////////////////////////////////
	@DeleteMapping("/customer/pictures/delete")
	public ResponseEntity<String> deletePicture(@RequestParam Integer pictureId){
	    Optional<Picture> op = pDao.findById(pictureId);
	    if(op.isPresent()) {
	        Picture picture = op.get();
	        pDao.delete(picture);
	        return ResponseEntity.ok("Picture deleted successfully");
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Picture not found");
	}
	//當前端呼叫該 API 時，將會刪除對應的照片。你也可以在刪除前進行權限檢查、刪除檔案等其他相關處理。

	
	
	/////////////////////////////////////////////////////////////////////////////////////
//	//<img src='...?id=1' />拿到id=1
//	@ResponseBody
//	@GetMapping("/customer/picture/pictureIds")//拿出每張圖片的id(與上方圖片列對應)
//	public List<Integer> getPictureID(@RequestParam Integer detailId,
//			@ModelAttribute("exis") Register exis){
//		//Integer mId = exis.getMemberId();
//		//YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
////		YJCustomerDetail detail = cdDao.getReferenceById(detailId);
////		
////		List<Picture> listPicture = detail.getPictures();
////		List<Integer> PictureIds = new ArrayList<>();
////		
////		for(Picture picture: listPicture) {
////			Integer picId = picture.getId();
////			PictureIds.add(picId);
////		}return PictureIds;
////		
//		Integer mId = exis.getMemberId();
//		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
//		
//		List<Picture> photos = detail.getPictures();
//		List<Integer> PictureIds = new ArrayList<>();
//		for(Picture pic: photos) {
//			PictureIds.add(pic.getId());
//			
//		}
//		
//		return PictureIds;
//	}
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
	
	
	////////////////////////////////////////////////////////////////////
	//保存到資料夾/images/-(未啟用)
	
	////////////////////////////////////
//	public void abcd (Model model) {
//		//抓session物件  mvc6-3前半小時
//		Register res = (Register) model.getAttribute("exis");
//	}	
		
	
	
	
}
