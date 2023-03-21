package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.Picture;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorDetailsBackupService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorPhotosBackupService;




@Controller
@RequestMapping("/topGun")
public class BackendVendorDetailsBackupController {
	
	
	@Autowired
	private BackendVendorDetailsBackupService backendVendorDetailsBackupService;
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	
	@Autowired
	private BackendVendorPhotosBackupService backendVendorPhotosBackupService;
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增會員細項資料跳頁
	@GetMapping(value = "/vendorDetailsBackup/add")
	public String addNewVendorDetailsBackupForm(Model model) {
		
		YJCustomerDetail vendorDetails = new YJCustomerDetail();
		
		model.addAttribute("vendorDetails", vendorDetails);
		
		return "/Ryu/backendAddNewVendorDetailsBackupForm";
		
	}
	
	
	// 新增會員細項資料
	@PostMapping(value = "/vendorDetailsBackup/post")
	public String insertVendorDetailsBackupData(@ModelAttribute("vendorDetails") YJCustomerDetail vendorDetails,
			RedirectAttributes redirectAttributes) {
		
		String account = vendorDetails.getAccount();
		
		Register register = backendRegisterRepository.findRegisterByAccount(account);
		
		
//		vendorDetails.setPicPath("Now Useless");
//		vendorDetails.setPicValue("Now Useless");
		
		vendorDetails.setFK_memberId(register);
		vendorDetails.setPlevel(register.getFK_Plevel());
		
		
		
		
//		####################### Ryuz divider #######################
//		======================= So weird =======================
//		======================= So weird =======================
//		======================= So weird =======================
		
		
		
		MultipartFile image = vendorDetails.getImage();
		
		Picture picture = new Picture();
		
		if (image != null && !image.isEmpty()) {
			
			try {
				
				byte[] b = image.getBytes();
				picture.setPhotoFile(b);
				
			}catch (Exception e) {
				
				e.printStackTrace();
				
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
				
			}
			
		}
		
//		backendVendorPhotosBackupService.insertVendorPhotos(picture);
		
		List<Picture> currentPicture = new ArrayList<>();
		
		currentPicture.add(picture);
		
		vendorDetails.setPictures(currentPicture);
		
		
//		======================= So weird =======================
//		======================= So weird =======================
//		======================= So weird =======================
//		####################### i am divider #######################
		
		
		
		
		
		
		backendVendorDetailsBackupService.insertVendorDetailsBackup(vendorDetails);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 詳細資料新增成功");
		
		return "redirect:/topGun";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
