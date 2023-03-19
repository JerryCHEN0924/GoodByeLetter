package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorDetails;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendLevelService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorDetailsService;
import com.iSpanProject.GoodByeletter.validate.BackendPutVendorDetailsValidator;
import com.iSpanProject.GoodByeletter.validate.BackendVendorDetailsValidator;


@Controller
@RequestMapping("/topGun")
public class BackendVendorDetailsController {
	
	@Autowired
	private BackendVendorDetailsService backendVendorDetailsService;
	
	
	@Autowired
	private BackendVendorDetailsValidator backendVendorDetailsValidator;
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
	
	@Autowired
	private BackendLevelService backendLevelService;
	
	
	
	@Autowired
	private ServletContext servletContext;
	
	
	String noImage = "/images/NoImage.png";
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	// 新增會員細項資料跳頁
	@GetMapping(value = "/vendorDetails/add")
	public String addNewVendorDetailsForm(Model model) {
		
		VendorDetails vendorDetails = new VendorDetails();
		
		model.addAttribute("vendorDetails", vendorDetails);
		
		return "/Ryu/backendAddNewVendorDetailsForm";
		
	}
	
	
	// 當使用者填妥資料按下Submit按鈕後，本方法接收將瀏覽器送來的會員資料，先進行資料的檢查，
	// 若資料有誤，轉向寫入錯誤訊息的網頁，若資料無誤，則呼叫Service元件寫入資料庫
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	@PostMapping(value = "/vendorDetails/post")
	public String insertVendorDetailsData(@ModelAttribute("vendorDetails") /* @Valid */ VendorDetails vendorDetails,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
//		new BackendVendorDetailsValidator().validate(vendorDetails, bindingResult);
//		System.out.println("新增客戶: " + vendorDetails);
//		
//		if (bindingResult.hasErrors()) {
//			System.out.println("======================");
//			List<ObjectError> list = bindingResult.getAllErrors();
//			for(ObjectError error : list) {
//				System.out.println("有錯誤：" + error);
//			}
//			
//			System.out.println("======================");
//			return "/Ryu/backendAddNewVendorDetailForm";
//			
//		}
//		
//		System.out.println("bean==>" + vendorDetails);
//		
//		backendVendorDetailsService.insertVendorDetails(vendorDetails);
//		
//		return "redirect:/topGun/backendHome";
		
//		=================================================================================
		
//		BackendVendorDetailsValidator backendVendorDetailsValidator = new BackendVendorDetailsValidator();
		// 呼叫Validate進行資料檢查
		backendVendorDetailsValidator.validate(vendorDetails, bindingResult);
		if (bindingResult.hasErrors()) {
//          下列敘述可以理解Spring MVC如何處理錯誤	
			System.out.println("======================");
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			
			System.out.println("======================");
			return "/Ryu/backendAddNewVendorDetailsForm";
		}
		
		System.out.println("bean==>" + vendorDetails);
		
		MultipartFile image = vendorDetails.getImage();
		
		String originalFilename = image.getOriginalFilename();
		
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
			
			vendorDetails.setFileName(originalFilename);
			
		}
		// 建立Blob物件，交由 JPA 寫入資料庫
		if (image != null && !image.isEmpty()) {
			
			try {
				
				byte[] b = image.getBytes();
				Blob blob = new SerialBlob(b);
				vendorDetails.setVendorDetailsImage(blob);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
				
			}
			
		}
		
//		Timestamp adminTime = new Timestamp(System.currentTimeMillis());
//		member.setAdmissionTime(adminTime);
		
		// 必須要找出對應的Member物件
		// 必須要找出對應的Level物件
		String account = vendorDetails.getAccount();
		
		Register register = backendRegisterRepository.findRegisterByAccount(account);
		
		vendorDetails.setRegister(register);
		
		vendorDetails.setLevel(register.getFK_Plevel());
		
		backendVendorDetailsService.insertVendorDetails(vendorDetails);
		
		redirectAttributes.addFlashAttribute("ModifyMessage", "新增成功");
		
//		// 將上傳的檔案移到指定的資料夾, 目前註解此功能
//			File imageFolder = new File(rootDirectory, "images");
//			if (!imageFolder.exists())
//				imageFolder.mkdirs();
//			File file = new File(imageFolder, "VendorDetailsImage_" + vendorDetails.getVendorDetailsId() + ext);
//			vendorDetails.transferTo(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//		}
		
		return "redirect:/topGun/vendorDetails/page";
		
	}
	
	
	
	@GetMapping("/vendorDetails/picture/{id}")
	public ResponseEntity<byte[]> getPicture(@PathVariable("id") Integer id) {
		
		byte[] body = null;
		ResponseEntity<byte[]> re = null;
		MediaType mediaType = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());

		VendorDetails vendorDetails = backendVendorDetailsService.findById(id);
		
		if (vendorDetails == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		
		String filename = vendorDetails.getFileName();
		
		if (filename != null) {
			if (filename.toLowerCase().endsWith("jfif")) {
				mediaType = MediaType.valueOf(servletContext.getMimeType("dummy.jpeg"));
			} else {
				mediaType = MediaType.valueOf(servletContext.getMimeType(filename));
				headers.setContentType(mediaType);
			}
		}
		
		
		Blob blob = vendorDetails.getVendorDetailsImage();
		
		if (blob != null) {
			
			body = blobToByteArray(blob);
			
		} else {
			
			String path = null;
			
			body = fileToByteArray(path);
		}
		re = new ResponseEntity<byte[]>(body, headers, HttpStatus.OK);

		return re;
		
	}
	
	
	
	
	
	private byte[] fileToByteArray(String path) {
		byte[] result = null;
		try (InputStream is = servletContext.getResourceAsStream(path);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public byte[] blobToByteArray(Blob blob) {
		byte[] result = null;
		try (InputStream is = blob.getBinaryStream(); ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] b = new byte[819200];
			int len = 0;
			while ((len = is.read(b)) != -1) {
				baos.write(b, 0, len);
			}
			result = baos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
	
	
	// 修改會員細項資料跳頁
	// 當使用者需要修改時，本方法送回含有會員資料的表單，讓使用者進行修改
	// 由這個方法送回修改記錄的表單...
	@GetMapping(value = "/vendorDetails/put/{id}")
	public String editVendorDetailsForm(@PathVariable("id") Integer id, Model model) {
		
		VendorDetails vendorDetails = backendVendorDetailsService.findById(id);
		
		model.addAttribute("vendorDetails", vendorDetails);
		
		return "Ryu/backendEditVendorDetailsForm";
		
	}
	
	
	
	
	// 當將瀏覽器送來修改過的會員資料時，由本方法負責檢核，若無誤則寫入資料庫
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	@PostMapping(value = "/vendorDetails/put/{id}")
	public String modify(@ModelAttribute("vendorDetails") VendorDetails vendorDetails,
						BindingResult bindingResult, 
						Model model,
						@PathVariable Integer id, 
						RedirectAttributes redirectAttributes) {
		
		BackendPutVendorDetailsValidator backendPutVendorDetailsValidator = new BackendPutVendorDetailsValidator();
		
		backendPutVendorDetailsValidator.validate(vendorDetails, bindingResult);
		
		
		if (bindingResult.hasErrors()) {
			
			System.out.println("bindingResult hasErrors(), vendorDetails = " + vendorDetails);
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list) {
				
				System.out.println("有錯誤：" + error);
				
			}
			
			return "Ryu/backendEditVendorDetailsForm";
			
		}
		Integer vendorDetailsId = vendorDetails.getVendorDetailsId();
		
		VendorDetails presentVendorDetails = backendVendorDetailsService.findById(vendorDetailsId);
		
		
		System.out.println("======================================================");
		System.out.println("vendorDetails1 = " + presentVendorDetails);
		System.out.println("vendorDetails1 = " + presentVendorDetails.getRegister());
		System.out.println("vendorDetails1 = " + presentVendorDetails.getRegister().getMemberId());
		System.out.println("vendorDetails1 = " + presentVendorDetails.getLevel());
		System.out.println("vendorDetails1 = " + presentVendorDetails.getLevel().getPlevel());
		System.out.println("ididid = " + id);
		System.out.println("ididid = " + id);
		System.out.println("ididid = " + id);
		System.out.println("ididid = " + id);
		System.out.println("ididid = " + id);
//		System.out.println("vendorDetails3 = " + vendorDetails.getMember().getMemberId());
		System.out.println("======================================================");
		
		
		// 找到對應的BackendMember物件
//		BackendMember member = backendMemberService.findById(vendorDetails.getMember().getMemberId());
		Register register = backendRegisterService.findRegisterById(presentVendorDetails.getRegister().getMemberId());
		
		String account = register.getAccount();
		
		vendorDetails.setRegister(register);
		
		// 找到對應的Category物件
//		BackendLevel level = backendLevelService.findById(vendorDetails.getLevel().getpLevel());
		Level level = backendLevelService.findLevelById(presentVendorDetails.getLevel().getPlevel());
		
		vendorDetails.setLevel(level);
		
		MultipartFile image = vendorDetails.getImage();
		
		if (image.getSize() == 0) {
			
			// 表示使用者並未挑選圖片
			VendorDetails original = backendVendorDetailsService.findById(id);
			vendorDetails.setFileName(original.getFileName());
			vendorDetails.setVendorDetailsImage(original.getVendorDetailsImage());
			
		} else {
			
			String originalFilename = image.getOriginalFilename();
			
			if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
				
				vendorDetails.setFileName(originalFilename);
				
			}
		
			// 建立Blob物件
			if (image != null && !image.isEmpty()) {
				
				try {
					
					byte[] b = image.getBytes();
					Blob blob = new SerialBlob(b);
					vendorDetails.setVendorDetailsImage(blob);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
					
				}
				
			}
			
		}
		
		try {
			
			backendVendorDetailsService.insertVendorDetails(vendorDetails);
//			redirectAttributes.addFlashAttribute("ModifyMessage", "修改成功: 編號=" + id);
			redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 詳細資料修改成功");
			
		} catch(Exception e) {
			
//			redirectAttributes.addFlashAttribute("ModifyMessage", "查無此筆紀錄: 編號=" + id);
			redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 詳細資料不存在");
			
		}
		
		return "redirect:/topGun/vendorDetails/page";
		
	}
	
	
	
	// 刪除一筆紀錄
	// 由這個方法刪除記錄...
	@DeleteMapping("/vendorDetails/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
						 RedirectAttributes redirectAttributes) {
		
		VendorDetails vendorDetails = backendVendorDetailsService.findById(id);
		Register register = vendorDetails.getRegister();
		String account = register.getAccount();
		
		backendVendorDetailsService.deleteById(id);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告商 [ " + account + " ] 詳細資料刪除成功");
		
		return "redirect:/topGun/vendorDetails/page";
		
	}
	
	
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	// 分頁查詢跳頁
	@GetMapping("/vendorDetails/page")
	public String showVendorDetailsByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<VendorDetails> page = backendVendorDetailsService.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowVendorDetails";
		
	}
	
	
	// 所有廠商細項資料
	@GetMapping(value = "/vendorDetails")
	public String vendorDetailsList(Model model) {
		
		List<VendorDetails> allVendorDetails = backendVendorDetailsService.getAllVendorDetails();
		
		model.addAttribute("allVendorDetails", allVendorDetails);
		
		return "/Ryu/allVendorDetails";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
