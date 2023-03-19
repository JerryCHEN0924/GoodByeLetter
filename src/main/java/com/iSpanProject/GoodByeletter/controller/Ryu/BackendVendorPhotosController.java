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
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorDetails;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorPhotos;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorDetailsService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorPhotosService;
import com.iSpanProject.GoodByeletter.validate.BackendPutVendorPhotosValidator;
import com.iSpanProject.GoodByeletter.validate.BackendVendorPhotosValidator;

@Controller
@RequestMapping("/topGun")
public class BackendVendorPhotosController {
	
	
	
	@Autowired
	private BackendVendorPhotosService backendVendorPhotosService;
	
	@Autowired
	private BackendVendorDetailsService backendVendorDetailsService;
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	@Autowired
	private ServletContext servletContext;
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	// 新增會員文案資料跳頁
	@GetMapping(value = "/vendorPhotos/add")
	public String addNewVendorPhotosForm(Model model) {
		
		VendorPhotos vendorPhotos = new VendorPhotos();
		
		model.addAttribute("vendorPhotos", vendorPhotos);
		
		return "/Ryu/backendAddNewVendorPhotosForm";
		
	}
	
	
	
	// 當使用者填妥資料按下Submit按鈕後，本方法接收將瀏覽器送來的會員資料，先進行資料的檢查，
	// 若資料有誤，轉向寫入錯誤訊息的網頁，若資料無誤，則呼叫Service元件寫入資料庫
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	@PostMapping(value = "/vendorPhotos/post")
	public String insertVendorPhotosData(@ModelAttribute("vendorPhotos") /* @Valid */ VendorPhotos vendorPhotos,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		BackendVendorPhotosValidator backendVendorPhotosValidator = new BackendVendorPhotosValidator();
		
		backendVendorPhotosValidator.validate(vendorPhotos, bindingResult);
		
		if (bindingResult.hasErrors()) {
//          下列敘述可以理解Spring MVC如何處理錯誤	
			System.out.println("======================");
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			
			System.out.println("======================");
			return "/Ryu/backendAddNewVendorPhotosForm";
		}
		
		System.out.println("bean==>" + vendorPhotos);
		
		MultipartFile image = vendorPhotos.getImage();
		
		String originalFilename = image.getOriginalFilename();
		
		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
			
			vendorPhotos.setFileName(originalFilename);
			
		}
		// 建立Blob物件，交由 JPA 寫入資料庫
		if (image != null && !image.isEmpty()) {
			
			try {
				
				byte[] b = image.getBytes();
				Blob blob = new SerialBlob(b);
				vendorPhotos.setVendorPhotosImage(blob);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
				
			}
			
		}
		
		// 必須要找出對應的Member物件
		// 必須要找出對應的Level物件
		String account = vendorPhotos.getAccount();
		
		Register register = backendRegisterRepository.findRegisterByAccount(account);
		
		VendorDetails vendorDetails = register.getVendorDetails();
		
		vendorPhotos.setVendorDetails(vendorDetails);
		
		backendVendorPhotosService.insertVendorPhotos(vendorPhotos);
		
		redirectAttributes.addFlashAttribute("ModifyMessage", "新增成功");
		
		return "redirect:/topGun/vendorPhotos/page";
		
	}
	
	
	
	@GetMapping("/vendorPhotos/picture/{id}")
	public ResponseEntity<byte[]> getPicture(@PathVariable("id") Integer id) {
		
		byte[] body = null;
		ResponseEntity<byte[]> re = null;
		MediaType mediaType = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		
		VendorPhotos vendorPhotos = backendVendorPhotosService.findById(id);
		
		if (vendorPhotos == null) {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		
		String fileName = vendorPhotos.getFileName();
		
		if (fileName != null) {
			if (fileName.toLowerCase().endsWith("jfif")) {
				mediaType = MediaType.valueOf(servletContext.getMimeType("dummy.jpeg"));
			} else {
				mediaType = MediaType.valueOf(servletContext.getMimeType(fileName));
				headers.setContentType(mediaType);
			}
		}
		
		Blob blob = vendorPhotos.getVendorPhotosImage();
		
		
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
	
	
	
	
	// 修改廣告文案資料跳頁
	// 當使用者需要修改時，本方法送回含有會員資料的表單，讓使用者進行修改
	// 由這個方法送回修改記錄的表單...
	@GetMapping(value = "/vendorPhotos/put/{id}")
	public String editVendorPhotosForm(@PathVariable("id") Integer id, Model model) {
		
		VendorPhotos vendorPhotos = backendVendorPhotosService.findById(id);
		
		model.addAttribute("vendorPhotos", vendorPhotos);
		
		return "Ryu/backendEditVendorPhotosForm";
		
	}
	
	
	
	
	
	// 當將瀏覽器送來修改過的會員資料時，由本方法負責檢核，若無誤則寫入資料庫
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	@PostMapping(value = "/vendorPhotos/put/{id}")
	public String modify(@ModelAttribute("vendorPhotos") VendorPhotos vendorPhotos,
			BindingResult bindingResult, 
			Model model,
			@PathVariable Integer id, 
			RedirectAttributes redirectAttributes) {
		
		BackendPutVendorPhotosValidator backendPutVendorPhotosValidator = new BackendPutVendorPhotosValidator();
		
		backendPutVendorPhotosValidator.validate(vendorPhotos, bindingResult);
		
		if (bindingResult.hasErrors()) {
			
			System.out.println("bindingResult hasErrors(), vendorPhotos = " + vendorPhotos);
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list) {
				
				System.out.println("有錯誤：" + error);
				
			}
			
			return "Ryu/backendEditVendorPhotosForm";
			
		}
		
		String title = vendorPhotos.getTitle();
		
		Integer vendorPhotosId = vendorPhotos.getVendorPhotosId();
		
		VendorPhotos presentVendorPhotos = backendVendorPhotosService.findById(vendorPhotosId);
		
		// 找到對應的VendorDetails物件
		VendorDetails vendorDetails = backendVendorDetailsService.findById(presentVendorPhotos.getVendorDetails().getVendorDetailsId());
		
		vendorPhotos.setVendorDetails(vendorDetails);
		
		
		MultipartFile image = vendorPhotos.getImage();
		
		
		if (image.getSize() == 0) {
			
			// 表示使用者並未挑選圖片
			VendorPhotos original = backendVendorPhotosService.findById(id);
			vendorPhotos.setFileName(original.getFileName());
			vendorPhotos.setVendorPhotosImage(original.getVendorPhotosImage());
			
		} else {
			
			String originalFilename = image.getOriginalFilename();
			
			if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
				
				vendorPhotos.setFileName(originalFilename);
				
			}
			
			// 建立Blob物件
			if (image != null && !image.isEmpty()) {
				
				try {
					
					byte[] b = image.getBytes();
					Blob blob = new SerialBlob(b);
					vendorPhotos.setVendorPhotosImage(blob);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
					
				}
				
			}
			
		}
		
		try {
			
			backendVendorPhotosService.insertVendorPhotos(vendorPhotos);
//			redirectAttributes.addFlashAttribute("ModifyMessage", "修改成功: 編號=" + id);
			redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告文案 [ " + title + " ] 修改成功");
			
		} catch(Exception e) {
			
//			redirectAttributes.addFlashAttribute("ModifyMessage", "查無此筆紀錄: 編號=" + id);
			redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告文案 [ " + title + " ] 不存在");
			
		}
		
		
		return "redirect:/topGun/vendorPhotos/page";
		
	}
	
	
	
	// 刪除一筆紀錄
	// 由這個方法刪除記錄...
	@DeleteMapping("/vendorPhotos/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			 RedirectAttributes redirectAttributes) {
		
		VendorPhotos vendorPhotos = backendVendorPhotosService.findById(id);
		String title = vendorPhotos.getTitle();
		
		backendVendorPhotosService.deleteById(id);
		
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告文案 [ " + title + " ] 刪除成功");
		
		
		return "redirect:/topGun/vendorPhotos/page";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	// 分頁查詢跳頁
	@GetMapping("/vendorPhotos/page")
	public String showVendorDetailsByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
		Page<VendorPhotos> page = backendVendorPhotosService.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendShowVendorPhotos";
		
	}
	
	
	
	// 所有廠商文案資料
	@GetMapping(value = "/vendorPhotos")
	public String vendorPhotosList(Model model) {
		
		List<VendorPhotos> allVendorPhotos = backendVendorPhotosService.getAllVendorPhotos();
		
		model.addAttribute("allVendorPhotos", allVendorPhotos);
		
		return "/Ryu/allVendorPhotos";
		
	}
	
	
	
	
	
	
	
	

}
