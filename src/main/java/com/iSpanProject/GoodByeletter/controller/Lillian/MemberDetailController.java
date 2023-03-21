package com.iSpanProject.GoodByeletter.controller.Lillian;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.MemberDetailService;
import com.iSpanProject.GoodByeletter.service.Lillian.RegisterService;
import com.iSpanProject.GoodByeletter.service.Lillian.SendMailService;

@Controller
@SessionAttributes({ "existing", "authenticated" })
public class MemberDetailController {

	@Autowired
	private MemberDetailService memberDetailService;

	@Autowired
	private RegisterService registerService;

	@Autowired
	private SendMailService sendMailService;

//註冊會員資料

	@PostMapping("/memberDetail/add2")
	public String saveMemberDetail(@RequestParam(value = "name") String name,
			@RequestParam(value = "gender") String gender,
			@RequestParam(value = "birthday") @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday,
			@RequestParam(value = "email") String email, @RequestParam(value = "county") String county,
			@RequestParam(value = "address") String address, @RequestParam(value = "memberId") Integer memberId,
//			@ModelAttribute("newMemberDetail") MemberDetail memberDetail,
			Model model) {
//		if (!errors.isEmpty()) {
//			return "Lillian/addMemberDetail";
//		}
		// 檢查Email是否已經存在
//	    boolean isEmailExist = memberDetailService.checkEmailExist(email);
//	    if (isEmailExist) {
//	        // 如果Email已經存在，返回錯誤消息
//	        Map<String, String> msg = new HashMap<>();
//	        msg.put("error", "此Email已被註冊!");
//	        model.addAttribute("msg", msg);
//	        return "Lillian/addMemberDetail";
//	    }
	    // 如果Email不存在，保存新用户信息
		MemberDetail newMemberDetail = new MemberDetail();
		newMemberDetail.setName(name);
		newMemberDetail.setGender(gender);
		newMemberDetail.setBirthday(birthday);
		newMemberDetail.setEmail(email);
		newMemberDetail.setCounty(county);
		newMemberDetail.setAddress(address);
		/////////////////////
		Register register = registerService.findById(memberId);
		newMemberDetail.setFK_memberId(register);
		///////////////////////
		memberDetailService.insert(newMemberDetail);
		Map<String, String> msg = new HashMap<String, String>();
		model.addAttribute("msg", msg);
		msg.put("success", "會員註冊成功!");
		
		return "redirect:/";
		
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "Lillian/addMemberDetail";
//		}
}
		
		

//編輯會員資料
	@GetMapping("/memberDetail/edit")
	public String editMemberDetailPage(@RequestParam Integer memberId, Model model) throws ParseException {// model儲存送過去
		MemberDetail memberDetails = memberDetailService.findByMemberId(memberId);
		
		
		if (memberDetails == null) {
			MemberDetail md = new MemberDetail();
			model.addAttribute("memberDetails", md);

			return "Lillian/MemberDetailEdit";
		}
		////// 時間轉換///////////
//		Date memberBirthday=memberDetails.getBirthday();
//		SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
//		String memberBirthdayString=format.format(memberBirthday);
//		Date memberBirthdayNewType=format.parse(memberBirthdayString);
//		memberDetails.setBirthday(memberBirthdayNewType);

		model.addAttribute("memberDetails", memberDetails);
		
		

		return "Lillian/MemberDetailEdit";
	}

	@PutMapping("/memberDetail/putMemberDetail")
	public String updateMemberDetailEdit(@ModelAttribute("memberDetail") MemberDetail memberDetail,
			HttpServletRequest request, Model model) {
		Register registerNew = (Register) model.getAttribute("existing");
		Integer memberId = registerNew.getMemberId();
		Register currentRegister = registerService.findById(memberId);

		memberDetail.setFK_memberId(currentRegister);
		memberDetail.setFK_Plevel(currentRegister.getFK_Plevel());

		memberDetailService.updateMemberDetail(memberDetail);

		return "redirect:/";
	}

	// 忘記密碼
	@GetMapping("/forgetpwd")
	public String forgetpwd(Model model) {
		Register newRegister = new Register();
		model.addAttribute("newRegister", newRegister);
		return "Lillian/forgetPwd";
	}
//1寄信
	@ResponseBody
	@PostMapping("/forgetpwd/sendEmail")
	public String sendEmail(@RequestParam("email") String email) throws MessagingException {
		sendMailService.sendEmail(email);
		return "success";
		//return "Lillian/CheckEmail";
	}
	
	@GetMapping("/forgetpwd/checkEmail")
	public String checkEmail() {
		return "Lillian/CheckEmail";
	}
//2更改新密碼
	@GetMapping("/forgetpwd/resetPassword")
	public String resetPwd(@RequestParam(name="code", required = false) String code, Model model) {
		if(code==null)
			return "index";
		else {
			model.addAttribute("code",code);
			return "Lillian/resetPwd";
		}
	}
	
	@PostMapping("/forgetpwd/updatePassword")
	public String updatePassword(@RequestParam("token")String token, 
			@RequestParam("password")String password,
			Model model)throws MessagingException {
		
		System.out.println("token="+ token);
		System.out.println("password="+ password);
		sendMailService.updatePassword(token,password);
		
		model.addAttribute("updatePwd","更新密碼完成");
		return "Lillian/updatePwdSuccess";
	}
//更改成功畫面
	@GetMapping("/forgetpwd/updatePwdSuccess")
	public String updatePwdSuccess() {
		return "redirect:/";
	}
	

}