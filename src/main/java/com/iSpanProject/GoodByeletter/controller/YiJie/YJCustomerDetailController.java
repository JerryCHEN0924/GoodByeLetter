package com.iSpanProject.GoodByeletter.controller.YiJie;

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

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
//import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetailRepository;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerService;


@Controller
@SessionAttributes("exis")//引入車車
public class YJCustomerDetailController {

//	@Autowired
	private YJCustomerService memberService;
	@Autowired
	private YJCustomerDetailService detailService;
	
	@PostMapping("/customerDetail/add2")
	public String addDetail(@RequestParam(value="name") String name,
							@RequestParam(value="type") String type,
							@RequestParam(value="email") String email,
							@RequestParam(value="address") String address,
							@RequestParam(value = "memberId") Integer id,
							//@RequestParam(value="picPath") String picPath,
							//@RequestParam(value="picValue") String picValue,
							Model model) {
		
		YJCustomerDetail detail1 = new YJCustomerDetail();
		detail1.setName(name);
		detail1.setType(type);
		detail1.setEmail(email);
		detail1.setAddress(address);
		
		////抓member表單的id來存，需要加車車
		Register reg = memberService.findById(id);
		detail1.setFK_memberId(reg);
		
		detailService.insert(detail1);
		Map<String, String> msg = new HashMap<String, String>();
		model.addAttribute("msg", msg);
		msg.put("success", "會員註冊成功!");
		return "redirect:/";
	}
	
	@GetMapping("customerDetail/add2")
	public String CustomerPage() {		
		return "redirect:/";
	}
	
	//////////////////////////////////////
	
	@GetMapping("customerDetail/detailpage")
	public String DetailPage() {		
		return "YiJie/companylogin";
	}
	
	@PutMapping("/customerDetail/putDetail")
	public String updDetail(@ModelAttribute("customerDetail") YJCustomerDetail detail,
			HttpSession session) {
		Register reg = (Register)session.getAttribute("exis");
		detail.setFK_memberId(reg);
		detailService.updateDetail(detail);
		return "YiJie/companylogin";
	}
	
	/////////////////////////////////////
	
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
