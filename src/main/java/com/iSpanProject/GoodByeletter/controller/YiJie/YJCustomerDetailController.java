package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.text.ParseException;
import java.util.HashMap;

//import java.util.List;
import java.util.Map;
//import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.iSpanProject.GoodByeletter.model.Lillian.MemberDetail;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
//import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetailRepository;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerService;


@Controller
@SessionAttributes({"exis","detail"})//引入車車
public class YJCustomerDetailController {

	@Autowired
	private YJCustomerService memberService;
	@Autowired
	private YJCustomerDetailService detailService;
	
	//去廠商功能主頁面
	@GetMapping("/customer/home/page")
	public String DetailPage2() {		
		return "YiJie/companylogin";
	}
	
//	//去更新廠商資料頁面
//	@GetMapping("/Detail/page2")
//	public String updDetailPage() {
//		return "YiJie/detail";
//	}
	
	//更新廠商資料
	@GetMapping("/customer/detail/page")
	public String editDetailPage(@ModelAttribute("exis") Register exis,
								Model model) throws ParseException {// model儲存送過去
		//0314
		//Register reg = (Register)session.getAttribute("exis");
		Integer memberId = exis.getMemberId();
		
		YJCustomerDetail detail = detailService.findByMemberId(memberId);
		model.addAttribute("detail", detail);
		return "YiJie/detail";

	}
	@PostMapping("/customer/detail/putDetail")
	public String updDetail(@ModelAttribute("exis") Register exis,
							@ModelAttribute("detail") YJCustomerDetail detail,
							@RequestParam(value = "name") String name,
							//@RequestParam(value = "type") String type,
							@RequestParam(value = "email") String email,
							@RequestParam(value = "address") String address,
							HttpSession session,
							Model model) {
		
		Register reg = (Register)session.getAttribute("exis");//透過"exis"抓到Register物件，存進reg
		Integer mId = reg.getMemberId();//取出reg中的id放入mId
		detail.setName(name);
		//detail.setType(type);//0318
		detail.setEmail(email);
		detail.setAddress(address);
		
		detailService.updateDetail(mId, detail);
		
		return "YiJie/companylogin";
	}
	/////////////////////////////////////
	
//	//去填寫會員詳細資料頁面
//	@GetMapping("/Detail/page1")
//	public String DetailPage() {		
//		return "YiJie/customerDetail";
//	}
//	
//	//填寫會員詳細資料
//	@PostMapping("/customerDetail")
//	public String addDetail(@RequestParam(value="name") String name,
//							@RequestParam(value="type") String type,
//							@RequestParam(value="email") String email,
//							@RequestParam(value="address") String address,
//							@RequestParam(value = "memberId") Integer id,
//							//@RequestParam(value="picPath") String picPath,
//							//@RequestParam(value="picValue") String picValue,
//							Model model) {
//		
//		YJCustomerDetail detail1 = new YJCustomerDetail();
//		detail1.setName(name);
//		detail1.setType(type);
//		detail1.setEmail(email);
//		detail1.setAddress(address);
//		
//		////抓member表單的id來存，需要加車車
//		Register reg = memberService.findById(id);
//		detail1.setFK_memberId(reg);
//		
//		detailService.insert(detail1);
//		Map<String, String> msg = new HashMap<String, String>();
//		model.addAttribute("msg", msg);
//		msg.put("success", "資料填寫成功!");
//		return "redirect:/";
//	}
	
	//////////////////////////////////////
//	@PostMapping("/customerDetail/addPicture")
//	public String addPic(@RequestParam(value="picPath") String picPath,
//						 @RequestParam(value="picValue") String picValue,
//						 Model model) {
//		
//		YJCustomerDetail detail1 = new YJCustomerDetail();
//		
//	}
	
	//customerDetailDao要能用得把上面第一個@autowired打開
//	@GetMapping("/customerDetail")
//	public List<YJCustomerDetail> findAll(){
//		return customerDetailDao.findAll();
//	}
//	@GetMapping("/customerDetail/id")
//	public YJCustomerDetail findById(@RequestParam("id") Integer id) {
//		Optional<YJCustomerDetail> optional = customerDetailDao.findById(id);
//		
//		if(optional.isPresent()) {
//			YJCustomerDetail detail = optional.get();
//			return detail;
//		}return null;
//	}
	
	
}
