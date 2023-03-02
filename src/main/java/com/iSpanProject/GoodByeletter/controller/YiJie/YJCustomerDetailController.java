package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.util.HashMap;
//import java.util.List;
import java.util.Map;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
//import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetailRepository;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;

public class YJCustomerDetailController {

//	@Autowired
//	private YJCustomerDetailRepository customerDetailDao;
	@Autowired
	private YJCustomerDetailService detailService;
	
	@PostMapping("/customerDetail/add2")
	public String addDetail(@RequestParam(value="name") String name,
							@RequestParam(value="type") String type,
							@RequestParam(value="email") String email,
							@RequestParam(value="address") String address, 
							//@RequestParam(value="picPath") String picPath,
							//@RequestParam(value="picValue") String picValue,
							Model model) {
		
		YJCustomerDetail detail1 = new YJCustomerDetail();
		detail1.setName(name);
		detail1.setType(type);
		detail1.setEmail(email);
		detail1.setAddress(address);
		
		detailService.insert(detail1);
		Map<String, String> msg = new HashMap<String, String>();
		model.addAttribute("msg", msg);
		//msg.put("success", "會員註冊成功!");
		return "YiJie/addCustomerDetail";
	}
	
	@GetMapping("register/customerDetail")
	public String CustomerPage() {		
		return "YiJie/addCustomerDetail";
	}
	
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
