package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.security.Principal;
import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendMemberDetailRepository;
import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorDetails;
import com.iSpanProject.GoodByeletter.model.Ryu.VendorPhotos;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendLevelService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendMemberDetailService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorDetailsService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendVendorPhotosService;
import com.iSpanProject.GoodByeletter.validate.BackendPutVendorDetailsValidator;
import com.iSpanProject.GoodByeletter.validate.BackendPutVendorPhotosValidator;

@Controller
@SessionAttributes({"existing", "username", "exis", "name", "userPrincipal"})
//@RequestMapping("/topGun")
public class BackendPageController {
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
	@Autowired
	private BackendMemberDetailService backendMemberDetailService;
	
	
	@Autowired
	BackendMemberDetailRepository backendMemberDetailRepository;
	
	
	@Autowired
	private BackendVendorPhotosService backendVendorPhotosService;
	
	@Autowired
	private BackendVendorDetailsService backendVendorDetailsService;
	
	@Autowired
	private BackendLevelService backendLevelService;
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	
	
	// 後台首頁入口
	@GetMapping("/topGun")
	public String enterBackendHome() {
		
		return "/Ryu/backendHome";
		
	}
	
	
	
	
	
	
	
//	@GetMapping("/user/login")
//	public String template() {
		
//		BackendMember m1 = new BackendMember();
//		model.addAttribute("backendMember", m1);
		
//		return "/Ryu/backendHome";
		
//	}
	
	
//	@GetMapping(value="/lastNoteLogin", produces = "application/javascript")
//	public String lastNoteLogin() {
//		
//		return "loginForm";
//		
//	}
	
	
	
//	@GetMapping(value="/lastNoteLogin", produces = "text/css")
//	public String lastNoteLogin() {
//		
//		return "loginForm";
//		
//	}
	
	
	
//	@GetMapping(value="/lastNoteLogin", produces = "text/html")
//	public String lastNoteLogin() {
//		
//		return "loginForm";
//		
//	}
	
	
	
	@GetMapping("/lastNoteLogin")
	public String lastNoteLogin() {
		
		return "/Ryu/loginForm";
		
	}
	
	
	
	@GetMapping("/lastNoteLogout")
	public String lastNoteLogout() {
		
		return "index";
		
	}
	
//	@GetMapping("/successLogin")
////	@PostMapping("/home")
//	public String home(Model model) {
//		
//		return "successMessage";
//		
//	}
	
	
	// 暫時沒用到了 Security 只管控後台
	@GetMapping("/successLogin")
//	@PostMapping("/home")
	public String home(Model model, Principal principal) {
		
		String username = principal.getName(); // 從Principal對象中獲取用戶名
		
		
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("username = " + username);
		System.out.println("=======================");
		System.out.println("=======================");
		
		
		
		
		Register register = backendRegisterRepository.findRegisterByAccount(username);
		
		System.out.println("=======================");
		System.out.println("=======================");
		System.out.println("register = " + register);
		System.out.println("=======================");
		System.out.println("=======================");
		
		String levelName = register.getFK_Plevel().getLevelName();
		
		System.out.println("==========HightLight=============");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("register = " + levelName);
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("=================================");
		System.out.println("=================================");
		
		
		
		
		
//		model.addAttribute("existing", register);
		
		
		
//		Level fk_Plevel = register.getFK_Plevel();
//		
//		
//		String string = fk_Plevel.toString();
//		
//		
//		System.out.println("====================");
//		System.out.println("====================");
//		System.out.println("string123 = " +string);
//		System.out.println("====================");
//		System.out.println("====================");
		
//		
//		if(string == "1" ) {
//			
//			model.addAttribute("existing", register);
//			
//		}else {
//			
//			model.addAttribute("exis", register);
//			
//		}
		
//		List<Level> roles = Arrays.asList(register.getFK_Plevel());
//		
//		
//		List<String> roleIds4 = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
//		String rolesString4 = String.join(",", roleIds4);
//		
//		
//		System.out.println("============");
//		System.out.println("============");
//		System.out.println("roleIds4 = " + roleIds4);
//		System.out.println("rolesString4 = " + rolesString4);
//		System.out.println("============");
//		System.out.println("============");
		
		
		
		if(levelName.equals("一般會員") ) {
		
		model.addAttribute("existing", register);
		
		}else if(levelName.equals("廣告商") ){
			
			model.addAttribute("exis", register);
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "Ryu/successMessage";
		
	}
	
	
	
	// 測試從 Session 中取得 Username
//	@GetMapping("/getTest")
//	@ResponseBody
//	public String getTest(Model model) {
//		
//		String getTest = (String) model.getAttribute("username");
//		
//		return getTest;
////		return "123456";
//		
//	}
	
	@GetMapping("/getTest")
//	@ResponseBody
	public String getTest(Principal principal) {
		
//	    String username = principal.getName(); // 從Principal對象中獲取用戶名
//	    
//	    return username;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		
		System.out.println("=========================");
		System.out.println("==========ROLE===========");
		System.out.println("=========================");
		System.out.println(auth.getName());
		System.out.println(auth.getCredentials());
		System.out.println(auth.getDetails());
		System.out.println(auth.getPrincipal());
		System.out.println(auth.getAuthorities());
		System.out.println(auth.getClass());
		System.out.println("=========================");
		System.out.println("=========================");
		System.out.println("=========================");
		
		return null;
	    
	}
	
//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	
//	System.out.println("testtesttest");
//	System.out.println(auth.getName());
	
	
//	@GetMapping("/getTest")
//	@ResponseBody
//	public String getTest(Authentication authentication) {
//	    String username = authentication.getName(); // 獲取用戶名
//	    // 其他認證訊息
//	    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities(); // 獲取用戶權限
//	    Object credentials = authentication.getCredentials(); // 獲取用戶憑證訊息，如密码
//	    boolean isAuthenticated = authentication.isAuthenticated(); // 判斷用戶是否已認證
//	    // 其他訊息 ...
//	    return username;
//	}
	
	
	
	
	
	
//	@GetMapping("/")
//	public String home() {
//		
//		return "/Ryu/backendHome";
//		
//	}
	
	
	
	
//	####################### Ryuz divider #######################
	// 優化後台追加更新
//	####################### i am divider #######################
	
	
	
	// 首頁分頁查詢，模糊條件搜尋 Account
	@GetMapping("/topGun/backendHome/getQueryLikePageExecute")
	public String getRegistersByAccountQueryLikePageExecute(@RequestParam(name = "page", defaultValue = "1") Integer pageNumber, @RequestParam(name = "account", required = true) String account, Model model) {
		
		Page<Register> page = backendRegisterService.findAllByAccountQueryLikePage(account, pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendHome";
		
	}
	
	
	
	
	// 後台首頁編輯會員，跳頁
	@GetMapping("/topGun/backendHome/register/edit")
	public String editRegisterPage(@RequestParam("memberId") Integer memberId, Model model) {
		
		Register register = backendRegisterService.findRegisterById(memberId);
		
		model.addAttribute("register", register);
		
		return "/Ryu/backendHomeEditRegisterForm";
		
	}
	
	
	// 後台首頁編輯會員
	@PutMapping("/topGun/backendHome/register/editPost")
	public String editPostRegister(@ModelAttribute("register") Register register,
			RedirectAttributes redirectAttributes) {
		
		String account = register.getAccount();
		
		backendRegisterService.updateRegister(register);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 修改成功");
		
		return "redirect:/topGun";
		
		
		
		
	}
	
	
	// 後台首頁刪除會員資料
	@DeleteMapping("/topGun/backendHome/register/delete")
	public String deleteRegister(@RequestParam("memberId") Integer memberId,
			RedirectAttributes redirectAttributes) {
		
		Register mem = backendRegisterService.findRegisterById(memberId);
		
		String account = mem.getAccount();
		
		backendRegisterService.deleteRegisterById(memberId);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 刪除成功");
		
		return "redirect:/topGun";
		
		
	}
	
	
	
	// 後台首頁編輯一般會員詳細資料，跳頁
	@GetMapping("/topGun/backendHome/memberDetail/edit")
	public String editMemberDetailPage(@RequestParam("memberId") Integer memberId, Model model,
			RedirectAttributes redirectAttributes) {
		
		Register mem = backendRegisterService.findRegisterById(memberId);
		
		String account = mem.getAccount();
		
		MemberDetail memberDetail = mem.getMemberDetail();
		
		if(memberDetail == null) {
		
			redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 詳細資料不存在");
			return "redirect:/topGun";
			
		}
		
		model.addAttribute("memberDetail", memberDetail);
		
		return "/Ryu/backendHomeEditMemberDetailForm";
		
	}
	
	
	
	// 後台首頁編輯一般會員詳細資料
	@PutMapping("/topGun/backendHome/memberDetail/editPost")
	public String editPostMemberDetail(@ModelAttribute("memberDetail") MemberDetail memberDetail,
			RedirectAttributes redirectAttributes) {
		
		backendMemberDetailService.updateMemberDetail(memberDetail);
		
		String account = memberDetail.getFK_memberId().getAccount();
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 詳細資料編輯成功");
		
		return "redirect:/topGun";
		
		
	}
	
	
	
	// 因 register 的 memberDetail 欄 有cascade = CascadeType.ALL，致使刪除 memberDetail 的功能失效
	// 後台首頁刪除一般會員詳細資料
	@DeleteMapping("/topGun/backendHome/memberDetail/delete")
	public String deleteMemberDetail(@RequestParam("id") Integer id,
			RedirectAttributes redirectAttributes) {
		
		MemberDetail memberDetail = backendMemberDetailService.findMemberDetailById(id);
		
		String account = memberDetail.getFK_memberId().getAccount();
		
		
		System.out.println("=====================");
		System.out.println("=====================");
		System.out.println(id);
		System.out.println("=====================");
		System.out.println("=====================");
		
		backendMemberDetailService.deleteMemberDetailById(id);
		
//		Optional<MemberDetail> findById = backendMemberDetailRepository.findById(id);
//		
//		if(findById.isPresent()){
//			
//			System.out.println("=====================");
//			
//			System.out.println("=======刪除 MemberDetail==========");
//			backendMemberDetailRepository.deleteById(id);
//			
//			System.out.println("=====================");
//		}else {
//			
//			System.out.println("=====================");
//			System.out.println("======MemberDetail 不存在=========");
//			System.out.println("=====================");
//		}
		
		
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 詳細資料刪除成功");
		
		return "redirect:/topGun";
		
		
	}
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	
	
	@GetMapping("/topGun/backendHome/money")
	public String home(Model model) {
		
		List<VendorPhotos> allVendorPhotosByEnabledTrue = backendVendorPhotosService.getAllVendorPhotosByEnabledTrue();
		
		if(allVendorPhotosByEnabledTrue == null) {
			
			System.out.println("============================");
			System.out.println("============================");
			System.out.println("沒有廠商文案");
			System.out.println("============================");
			System.out.println("============================");
			
		}else {
			
			
			System.out.println("============================");
			System.out.println("============================");
			System.out.println("有廠商文案");
			System.out.println("============================");
			System.out.println("============================");
			
		}
		
		
		model.addAttribute("allVendorPhotosByEnabledTrue", allVendorPhotosByEnabledTrue);
		
		return "/Ryu/backendShowMeTheMoney";
		
	}
	
	
	
	// 後台首頁編輯廣告商會員詳細資料，跳頁
	// 當使用者需要修改時，本方法送回含有會員資料的表單，讓使用者進行修改
	// 由這個方法送回修改記錄的表單...
	@GetMapping(value = "/topGun/backendHome/vendorDetails/put/{id}")
	public String editVendorDetailsForm(@PathVariable("id") Integer id, Model model,
			RedirectAttributes redirectAttributes) {
		
		Register mem = backendRegisterService.findRegisterById(id);
		
		String account = mem.getAccount();
		
		VendorDetails presentVendorDetails = mem.getVendorDetails();
		
//		VendorDetails vendorDetails = backendVendorDetailsService.findById(id);
		
		if(presentVendorDetails == null) {
			
			redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 詳細資料不存在");
			return "redirect:/topGun";
			
		}
		
		model.addAttribute("vendorDetails", presentVendorDetails);
		
		return "Ryu/backendHomeEditVendorDetailsForm";
		
	}
	
	
	
	// 後台首頁編輯廣告商會員詳細資料
	// 當將瀏覽器送來修改過的會員資料時，由本方法負責檢核，若無誤則寫入資料庫
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	@PostMapping(value = "/topGun/backendHome/vendorDetails/put/{id}")
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
			
			return "Ryu/backendHomeEditVendorDetailsForm";
			
		}
		
//		Register mem = vendorDetails.getRegister();
//		
//		String account = mem.getAccount();
		
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
			redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 詳細資料修改成功");
			
		} catch(Exception e) {
			
//			redirectAttributes.addFlashAttribute("ModifyMessage", "查無此筆紀錄: 編號=" + id);
			redirectAttributes.addFlashAttribute("backendHomeMessages", "會員 [ " + account + " ] 詳細資料不存在");
			
		}
		
		return "redirect:/topGun";
		
		
	}
		
	
	
	// 首頁分頁查詢，模糊條件搜尋 Title，跳頁
	@GetMapping("/topGun/backendHome/getVendorPhotosQuery")
	public String VendorPhotosByTitleQuery() {
		
		return "/Ryu/backendHomeShowVendorPhotos";
		
	}
	
	
	
	
	// 首頁分頁查詢，模糊條件搜尋 Title
	@GetMapping("/topGun/backendHome/getVendorPhotosByTitleQueryLikePageExecute")
	public String getVendorPhotosByTitleQueryLikePageExecute(@RequestParam(name = "page", defaultValue = "1") Integer pageNumber, @RequestParam(name = "title", required = true) String title, Model model) {
		
		Page<VendorPhotos> page = backendVendorPhotosService.findAllByTitleQueryLikePage(title, pageNumber);
		
		model.addAttribute("page", page);
		
		return "/Ryu/backendHomeShowVendorPhotos";
		
	}
	
	
	
	
	// 修改廣告文案資料跳頁
	// 當使用者需要修改時，本方法送回含有會員資料的表單，讓使用者進行修改
	// 由這個方法送回修改記錄的表單...
	@GetMapping(value = "/topGun/backendHome/vendorPhotos/put/{id}")
	public String editVendorPhotosForm(@PathVariable("id") Integer id, Model model) {
		
		VendorPhotos vendorPhotos = backendVendorPhotosService.findById(id);
		
		model.addAttribute("vendorPhotos", vendorPhotos);
		
		return "Ryu/backendHomeEditVendorPhotosForm";
		
	}
	
	
	
	
	
	// 當將瀏覽器送來修改過的廣告文案資料時，由本方法負責檢核，若無誤則寫入資料庫
	// BindingResult 參數必須與@ModelAttribute修飾的參數連續編寫，中間不能夾其他參數
	@PostMapping(value = "/topGun/backendHome/vendorPhotos/put/{id}")
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
			
			return "Ryu/backendHomeEditVendorPhotosForm";
			
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
		
		
		return "redirect:/topGun/backendHome/getVendorPhotosQuery";
		
	}
	
	
	
	// 後台首頁編輯新版廣告文案刪除
	// 刪除一筆紀錄
	// 由這個方法刪除記錄...
	@DeleteMapping("/topGun/backendHome/vendorPhotos/delete/{id}")
	public String delete(@PathVariable("id") Integer id,
			 RedirectAttributes redirectAttributes) {
		
		VendorPhotos vendorPhotos = backendVendorPhotosService.findById(id);
		String title = vendorPhotos.getTitle();
		
		backendVendorPhotosService.deleteById(id);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "廣告文案 [ " + title + " ] 刪除成功");
		
		return "redirect:/topGun/backendHome/getVendorPhotosQuery";
		
	}
	
	
	
	
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	
	
	
	
	
	
	
	
	
}
