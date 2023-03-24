package com.iSpanProject.GoodByeletter.controller.Ryu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorDetails;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;
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
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
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
		
		
		
//		MultipartFile image = vendorDetails.getImage();
//		
//		List<Picture> photos = vendorDetails.getPictures();
//		
//		
//		if (image != null && !image.isEmpty()) {
//			
//			try {
//				
//				Picture picture = new Picture();
//				byte[] b = image.getBytes();
//				picture.setPhotoFile(b);
//				
//			}catch (Exception e) {
//				
//				e.printStackTrace();
//				
//				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//				
//			}
//			
//		}
		
		
		
		
//		backendVendorPhotosBackupService.insertVendorPhotos(picture);
		
//		List<Picture> currentPicture = new ArrayList<>();
//		
//		currentPicture.add(picture);
		
//		vendorDetails.setPictures(currentPicture);
		
		
//		======================= So weird =======================
//		======================= So weird =======================
//		======================= So weird =======================
//		####################### i am divider #######################
		
		
		
		
		
		
//		vendorDetails.setPictures(photos);
		
		
		
		
		
		backendVendorDetailsBackupService.insertVendorDetailsBackup(vendorDetails);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 詳細資料新增成功");
		
//		return "redirect:/topGun";
		
		return "redirect:/topGun/vendorDetailsBackup/page";
		
		
	}
	
	
	
	
	// 分頁查詢跳頁，查詢所有廣告商for enabled
	@GetMapping("/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute")
	public String showVendorDetailsBackupByPage(@RequestParam(name = "page", defaultValue = "1") Integer pageNumber, @RequestParam(name = "account", required = false) String account, Model model) {
		
		Page<Register> page = backendRegisterService.findAllVentorBackupsByAccountQueryLikePage(account, pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowVentorsEnableBackup";
		
	}
	
	
	
	// 分頁查詢跳頁，查詢所有廣告商for enabled，審核啟用狀態
	@GetMapping("/vendorDetailsBackup/enableEdit")
	public String editvendorDetailsBackupPage(@RequestParam("memberId") Integer memberId, Model model) {
//		public String editvendorDetailsBackupPage(Model model) {
			
		System.out.println("======================");
		System.out.println("======================");
		System.out.println("======================");
		System.out.println(memberId);
		System.out.println("======================");
		System.out.println("======================");
		System.out.println("======================");
		
		Register register = backendRegisterService.findRegisterById(memberId);
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendEditVendorBackupEnabledForm";
		
	}

	
	// 修改註冊會員Enabled資料
	@PutMapping("/vendorDetailsBackup/enableEditPost")
	public String editPostRegisterEnabled(@ModelAttribute("register") Register register,
			RedirectAttributes redirectAttributes) {
		
		String account = register.getAccount();
			
		backendRegisterService.updateRegister(register);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 啟用狀態修改成功");
			
		return "redirect:/topGun/vendorDetailsBackup/getVendorEnableByAccountQueryLikePageExecute";
			
	}
	
	
	
	
	
	// 分頁查詢跳頁
	@GetMapping("/vendorDetailsBackup/page")
	public String showVendorDetailsBackupByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<YJCustomerDetail> page = backendVendorDetailsBackupService.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowVendorDetailsBackup";
		
	}
	
	
	
	
	// 修改廣告商細項資料跳頁
	@GetMapping(value = "/vendorDetailsBackup/put/{id}")
	public String editVendorDetailsForm(@PathVariable("id") Integer id, Model model) {
		
		YJCustomerDetail vendorDetails = backendVendorDetailsBackupService.findById(id);
		
		model.addAttribute("vendorDetails", vendorDetails);
		
		return "Ryu/backendEditVendorDetailsBackupForm";
		
	}
	
	
	@PostMapping(value = "/vendorDetailsBackup/put/{id}")
	public String modify(@ModelAttribute("vendorDetails") YJCustomerDetail vendorDetails,
			Model model,
			@PathVariable Integer id, 
			RedirectAttributes redirectAttributes) {
		
		YJCustomerDetail currentvendorDetails = backendVendorDetailsBackupService.findById(id);
		
		Register fk_memberId = currentvendorDetails.getFK_memberId();
		
		String account = fk_memberId.getAccount();
		
		
		backendVendorDetailsBackupService.insertVendorDetailsBackup(vendorDetails);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 詳細資料修改成功");
		
		return "redirect:/topGun/vendorDetailsBackup/page";
		
	}
	
	
	@DeleteMapping("/vendorDetailsBackup/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			 RedirectAttributes redirectAttributes) {
		
		
		YJCustomerDetail currentvendorDetails = backendVendorDetailsBackupService.findById(id);
		
		System.out.println("=============");
		System.out.println("=============");
		System.out.println(currentvendorDetails);
		System.out.println("=============");
		System.out.println("=============");
		
		Register fk_memberId = currentvendorDetails.getFK_memberId();
		
		System.out.println("=============");
		System.out.println("=============");
		System.out.println(fk_memberId);
		System.out.println("=============");
		System.out.println("=============");
		
		String account = fk_memberId.getAccount();
		
		
		System.out.println("=============");
		System.out.println("=============");
		System.out.println(account);
		System.out.println("=============");
		System.out.println("=============");
		
		backendVendorDetailsBackupService.deleteById(id);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 詳細資料刪除成功");
		
//		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 詳細資料刪除成功");
		
		return "redirect:/topGun/vendorDetailsBackup/page";
		
	}
	
	
	
	
	

}
