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
	private YJCustomerDetailService detailService;
	@Autowired
	private PictureService pService;
	@Autowired
	private YJCustomerDetailDao cdDao;
	
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
		
//		try {}catch(IOException e) {}
//		
//		Picture picture = new Picture();
//		
//		picture.setPhotoFile(files.getBytes());
//		picture.setEnable(false);
		
		
		List<Picture> photos = new LinkedList<>();
		
		for(MultipartFile file:files) {
			Picture pic = new Picture();
			byte[] pictureByte = file.getBytes();//有throws IOException才能用
			
			pic.setPhotoFile(pictureByte);
			pic.setEnable(false);
			photos.add(pic);
		}
		
		detail.setPictures(photos);
		
		cdDao.save(detail);
		
		return "okok";
	}
	//保存到資料夾/images/
	@PostMapping("/customer/picture/upload")
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
