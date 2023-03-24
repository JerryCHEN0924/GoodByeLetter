package com.iSpanProject.GoodByeletter.controller.Ryu;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendMemberDetailService;
import com.iSpanProject.GoodByeletter.service.Ryu.BackendRegisterService;
import com.iSpanProject.GoodByeletter.validate.MemberDetailValidator;

@Controller
@RequestMapping("/topGun")
public class BackendMemberDetailController {
	
	@Autowired
	private BackendMemberDetailService backendMemberDetailService;
	
	@Autowired
	private BackendRegisterService backendRegisterService;
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	// 新增會員細項資料跳頁
	@GetMapping("/memberDetail/add")
	public String addNewMemberDetailForm(Model model) {
		
		MemberDetail memberDetail = new MemberDetail();
		
		model.addAttribute("memberDetail", memberDetail);
		
		return "/Ryu/backendAddNewMemberDetailForm";
	}
	
	// 新增會員細項資料
	@PostMapping("/memberDetail/post")
	public String insertMemberDetailData(@ModelAttribute("memberDetail") MemberDetail memberDetail,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		new MemberDetailValidator().validate(memberDetail, bindingResult);
		
		System.out.println("新增會員資料: " + memberDetail);
		
		
		if (bindingResult.hasErrors()) {
			System.out.println("======================");
			List<ObjectError> list = bindingResult.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			
			System.out.println("======================");
			return "/Ryu/backendAddNewMemberDetailForm";
			
		}
		
		System.out.println("bean==>" + memberDetail);
		
		// get 不到 register ... null ...
		// 為甚麼 ... 因為這時候 memberDetail 還沒建立 ... 當然 get 不到 ... 87 ...
//		Register register = memberDetail.getFK_memberId();
//		String account = register.getAccount();
		
		String account = memberDetail.getAccount();
		
		boolean checkAccountExist = backendRegisterService.checkAccountExist(account);
		
		if(!checkAccountExist) {
			
			redirectAttributes.addFlashAttribute("backendHomeMessages", "會員帳號 [ " + account + " ] 不存在");
			return "redirect:/topGun/memberDetail/add";
			
		}
		
		backendMemberDetailService.insertMemberDetail(memberDetail);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員帳號 [ " + account + " ] 詳細資料新增成功");
		
		return "redirect:/topGun/memberDetail/add";
		
	}
	
//	####################### i am divider #######################
		
	
	// 分頁查詢跳頁
	@GetMapping("/memberDetail/page")
	public String showMemberDetailByPage(@RequestParam(name = "p", defaultValue = "1") Integer pageNumber, Model model) {
		
	Page<MemberDetail> page = backendMemberDetailService.findByPage(pageNumber);
		
	model.addAttribute("page", page);
		
	return "/Ryu/backendShowMemberDetail";
		
	}
	
	// 修改會員細項資料跳頁
	@GetMapping("/memberDetail/edit")
	public String editMemberDetailPage(@RequestParam("id") Integer id, Model model) {
		
		MemberDetail memberDetail = backendMemberDetailService.findMemberDetailById(id);
		
		model.addAttribute("memberDetail", memberDetail);
		
		return "/Ryu/backendEditMemberDetailForm";
		
	}
	
	// 修改會員細項資料
	@PutMapping("/memberDetail/editPost")
	public String editPostMemberDetail(@ModelAttribute("memberDetail") MemberDetail memberDetail,
			 RedirectAttributes redirectAttributes) {
		
		Register presentRegister = memberDetail.getFK_memberId();
		
		String account = presentRegister.getAccount();
		
		backendMemberDetailService.updateMemberDetail(memberDetail);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員帳號 [ " + account + " ] 詳細資料修改成功");
		
		return "redirect:/topGun/memberDetail/page";
		
	}
	
	
	// 刪除會員細項資料
	// 因 Register 之對應屬性為 cascaded all，致使本刪除功能暫時失效
	@DeleteMapping("/memberDetail/delete")
	public String deleteMemberDetail(@RequestParam("id") Integer id,
			 RedirectAttributes redirectAttributes) {
		
		System.out.println("================================");
		System.out.println("================================");
		System.out.println("================================");
		System.out.println(id);
		System.out.println("================================");
		System.out.println("================================");
		System.out.println("================================");
		
		MemberDetail presentMemberDetail = backendMemberDetailService.findMemberDetailById(id);
		
		Register presentRegister = presentMemberDetail.getFK_memberId();
		
		String account = presentRegister.getAccount();
		
		backendMemberDetailService.deleteMemberDetailById(id);
		
		redirectAttributes.addFlashAttribute("backendHomeMessages", "會員帳號 [ " + account + " ] 詳細資料刪除成功");
		
		return "redirect:/topGun/memberDetail/page";
//		return "redirect:/topGun";
		
	}
	
//	####################### i am divider #######################
	
	
	
	
	
	
	
	
	
	
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
	
	// java.util.Date
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	dateFormat.setLenient(false);
	CustomDateEditor ce = new CustomDateEditor(dateFormat, true); 
	binder.registerCustomEditor(java.util.Date.class, ce);
	
	// java.sql.Date		
//	DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
//	dateFormat2.setLenient(false);
//	CustomDateEditor ce2 = new CustomDateEditor(dateFormat2, true); 
//	binder.registerCustomEditor(java.sql.Date.class, ce2);
//	}
	
	// java.sql.Date		
	DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd");
	dateFormat3.setLenient(false);
	CustomDateEditor ce3 = new CustomDateEditor(dateFormat3, true); 
	binder.registerCustomEditor(java.util.Date.class, ce3);
	
}
	
	
	
//	####################### Ryuz divider #######################
	
//	####################### i am divider #######################
	
	
	

}
