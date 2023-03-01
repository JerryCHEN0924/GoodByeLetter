package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.iSpanProject.GoodByeletter.dao.YiJie.YJCustomerDetailDao;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetailRepository;

public class YJCustomerDetailController {

	@Autowired
	private YJCustomerDetailRepository customerDetailDao;
	
	@GetMapping("/customerDetail")
	public List<YJCustomerDetail> findAll(){
		return customerDetailDao.findAll();
	}
	
	@GetMapping("/customerDetail/id")
	public YJCustomerDetail findById(@RequestParam("id") Integer id) {
		Optional<YJCustomerDetail> optional = customerDetailDao.findById(id);
		
		if(optional.isPresent()) {
			YJCustomerDetail detail = optional.get();
			return detail;
		}return null;
	}
	
	@PostMapping("/customerDetail/add1")
	public String addDetail(@RequestBody YJCustomerDetail detail) {
		
		customerDetailDao.save(detail);
		return "新增成功";
	}
	
}
