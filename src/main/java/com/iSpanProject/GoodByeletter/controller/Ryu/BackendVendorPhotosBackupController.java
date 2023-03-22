package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.dao.Ryu.BackendVendorPhotosBackupRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.Picture;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorPhotosBackupService;




@Controller
@RequestMapping("/topGun")
public class BackendVendorPhotosBackupController {
	
	
	
	@Autowired
	private BackendVendorPhotosBackupService backendVendorPhotosBackupService;
	
	@Autowired
	BackendVendorPhotosBackupRepository backendVendorPhotosBackupRepository;
	
//	@Autowired
//	private ServletContext servletContext;
	
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	// 新增會員文案資料跳頁
	@GetMapping(value = "/vendorPhotosBackup/add")
	public String addNewVendorPhotosForm(Model model) {
		
		Picture picture = new Picture();
		
		model.addAttribute("vendorPhotos", picture);
		
		return "/Ryu/backendAddNewVendorPhotosBackupForm";
		
	}
	
	
	
	// 新增會員文案資料
	@PostMapping(value = "/vendorPhotosBackup/post")
	public String insertVendorPhotosData(@ModelAttribute("vendorPhotos") Picture vendorPhotos, Model model,
			 RedirectAttributes redirectAttributes) {
		
		
		
		String account = vendorPhotos.getAccount();
		
		Register register = backendRegisterRepository.findRegisterByAccount(account);
		
		YJCustomerDetail customerDetail = register.getCustomerDetail();
		
		vendorPhotos.setCustomerDetail(customerDetail);
		
		MultipartFile image = vendorPhotos.getImage();
		
		if (image != null && !image.isEmpty()) {
			
			try {
				
				byte[] b = image.getBytes();
				vendorPhotos.setPhotoFile(b);
				
			}catch (Exception e) {
				
				e.printStackTrace();
				
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
				
			}
			
		}
		
		
		backendVendorPhotosBackupService.insertVendorPhotos(vendorPhotos);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告文案新增成功");
		
		return "redirect:/topGun";
		
	}
	
	
	
//	@GetMapping("/vendorPhotosBackup/picture/{id}")
//	public ResponseEntity<byte[]> getPicture(@PathVariable("id") Integer id) {
//		
//		byte[] body = null;
//		ResponseEntity<byte[]> re = null;
//		
//		MediaType mediaType = null;
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
//		
//		Picture vendorPhotos = backendVendorPhotosBackupService.findById(id);
//		
//		if (vendorPhotos == null) {
//			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
//		}
//		
//		mediaType = MediaType.valueOf(servletContext.getMimeType("picture" + id));
//		headers.setContentType(mediaType);
//		
//		body = vendorPhotos.getPhotoFile();
//		
//		re = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);
//
//		return re;
//		
//		
//	}
	
	
	
	
	// 分頁查詢跳頁
	@GetMapping("/vendorPhotosBackup/page")
	public String showVendorDetailsByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<Picture> page = backendVendorPhotosBackupService.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowVendorPhotosBackup";
		
	}
	
	
	
	
	@GetMapping("/vendorPhotosBackup/image")
	public ResponseEntity<byte[]> getHouseImage(@RequestParam Integer id){
		
		Optional<Picture> optional = backendVendorPhotosBackupRepository.findById(id);
		
		if(optional.isPresent()) {
			
			Picture photo = optional.get();
			byte[] photoFile = photo.getPhotoFile();
			
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(photoFile);
		}
		
		System.out.println("============== Nothing else here ==============");
		System.out.println("============== Nothing else here ==============");
		System.out.println("============== Nothing else here ==============");
		
		return null;
	}
	
	
	@DeleteMapping("/vendorPhotosBackup/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			 RedirectAttributes redirectAttributes) {
		
		
		backendVendorPhotosBackupService.deleteById(id);
		
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告文案刪除成功");
		
		
		return "redirect:/topGun";
		
	}
	
	
	
	
	@GetMapping(value = "/vendorPhotosBackup/put/{id}")
	public String editVendorPhotosForm(@PathVariable("id") Integer id, Model model) {
		
		Picture vendorPhotos = backendVendorPhotosBackupService.findById(id);
		
		model.addAttribute("vendorPhotos", vendorPhotos);
		
		return "Ryu/backendEditVendorPhotosBackupForm";
		
	}
	
	
	
	
	
	
	@PostMapping(value = "/vendorPhotosBackup/put/{id}")
	public String modify(@ModelAttribute("vendorPhotos") Picture vendorPhotos, Model model,
			 RedirectAttributes redirectAttributes) {
		
		
		backendVendorPhotosBackupService.insertVendorPhotos(vendorPhotos);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告文案修改成功");
		
		return "redirect:/topGun";
		
	}
	
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	

}
