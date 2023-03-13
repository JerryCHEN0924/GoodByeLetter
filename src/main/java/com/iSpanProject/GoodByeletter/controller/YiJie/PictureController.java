package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;

@Controller
@SessionAttributes("exis")
public class PictureController {

	@Autowired
	private YJCustomerDetailService detailService;
	@Autowired
	private YJCustomerDetailDao cdDao;
	@Autowired
	private PictureDao pDao;
	
	//圖片頁面1
	@GetMapping("/picture/page1")
	public String picturePage1() {
		return "YiJie/updatePic";
	}
	//圖片頁面2
		@GetMapping("/picture/page2")
		public String picturePage2() {
			return "YiJie/upPicture2";
		}
		//
	//回廠商主頁面-目前未啟用
	@GetMapping("/companylogig/page")
	public String backPage() {
		return "YiJie/companylogin";
	}
	//圖片上傳
	@ResponseBody
	@PostMapping("/picture/updata1")
	public String upPicture(HttpSession session,
							@RequestParam("files") MultipartFile[] files,
							Model model) throws IOException {
		//0311
		//透過"exis"抓到Register物件，存進reg
		Register reg = (Register)session.getAttribute("exis");
		Integer mId = reg.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		
		List<Picture> photos = new LinkedList<>();
		
		for(MultipartFile file:files) {
			Picture pic = new Picture();
			byte[] pictureByte = file.getBytes();//有才能用throws IOException
			
			pic.setPhotoFile(pictureByte);
			photos.add(pic);
		}
		detail.setPictures(photos);
		cdDao.save(detail);
		
		return "okok";
	}
	//保存到資料夾/images/
	@PostMapping("/picture/upload")
	public String upPicture2(HttpSession session,
							@RequestParam("file") MultipartFile file,
							Model modl) {
		Register reg = (Register)session.getAttribute("exis");
		Integer mId = reg.getMemberId();
		YJCustomerDetail detail = cdDao.findDetailByMemberId(mId);
		
		if (!file.isEmpty()) {
			  try {
			    // 生成保存文件的路徑
			    Path path = Paths.get("/images/" + file.getOriginalFilename());
			    // 保存文件到本地文件系統中
			    Files.write(path, file.getBytes());
			    
			    String pathStr = path.toString();
			    detail.setPicPath(pathStr);
			    //怕圖片太大爆掉，先不傳fileValue
			    //cdDao.save(detail);
			    
			  } catch (IOException e) {
			    e.printStackTrace();
			  }
			}
		//return ResponseEntity.ok("File uploaded successfully!");
		return "上傳成功";
	}
	
	////////////////////////////////////
//	public void abcd (Model model) {
//		//抓session物件  mvc6-3前半小時
//		Register res = (Register) model.getAttribute("exis");
//	}	
		
	
	
	
}
