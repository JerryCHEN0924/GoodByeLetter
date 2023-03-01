package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.sql.Date;
import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomer;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerRepository;
import com.iSpanProject.GoodByeletter.model.YiJie.YJLevel;

@Controller
public class YJCustomerController {
	
	@Autowired
	private YJCustomerRepository customerDao;	
	
	//註冊
	@ResponseBody //等外面傳入json，接住反序列化成java物件
	@PostMapping("/customer/register")
	public String register(@RequestBody YJCustomer customer,
						   //@RequestBody YJLevel level,
						   @RequestParam("level") YJLevel level,
						   String verificationCode) { 
		
//		// 解析請求中的帳號、密碼和驗證訊息
//        String acc = customer.getAcc();
//        //String pass = customer.getPass();
//        
//        YJCustomer existingCustomer = customerDao.findCustomerByAcc(acc);
//		if( existingCustomer != null ) {
//			return "已經有此帳號了!";
//		}
//		// 驗證訊息為 "123" 時，帳號等級提升至 level=2
//        if ("123".equals(verificationCode)) {
//        	
//        	YJLevel lev1 = new YJLevel();
//        	lev1.setPlevel(2);
//        	customer.setLevel(lev1);	
//            //customer.setLevel(2);
//        	
//        }
		customerDao.save(customer);
		return "成功";
	}
	//登入
	@PostMapping("customer/login")
	public String login() {
		
	}
//	
	@ResponseBody
	@GetMapping("/customer/id")
	public YJCustomer findById(@RequestParam("id") Integer id) {
		Optional<YJCustomer> optional = customerDao.findById(id);
		
		if(optional.isPresent()) {
			YJCustomer cus = optional.get();
			return cus;
		}return null;	
	}
//	
	@ResponseBody
	@GetMapping("/customers")
	public List<YJCustomer> findAll(){
		return customerDao.findAll();
	}
//	
	@ResponseBody
	@DeleteMapping("/customer/delete")
	public String deleteById(@RequestParam Integer id) {
		try {
			customerDao.deleteById(id);
			return "刪除成功";
		}catch(EmptyResultDataAccessException e) {
			return "沒有這筆資料";
		}
		
	}
//	
//	@ResponseBody
//	@GetMapping("/customer/page")
//	public List<YJCustomer> findByPage(@RequestParam Integer pageNumber){
//		Pageable pgb = PageRequest.of(pageNumber-1,3,Sort.Direction.ASC, "id"); //(要從第幾頁開始，一頁幾筆，排序方法)
//		Page<YJCustomer> page = customerDao.findAll(pgb);
//		List<YJCustomer> list = page.getContent();
//		return list;
//	}
	
//	@ResponseBody
//	@GetMapping("/customer/acc")
//	public YJCustomer findByAcc(@RequestParam String acc) {
//		return customerDao.findCustomerByAcc(acc);
//	}

//	@ResponseBody
//	@GetMapping("/customer/AccAndLevel")
//	public YJCustomer findByAccAndLevel(@RequestParam String acc,@RequestParam Integer level) {
//		return customerDao.findCustomerByAccAndLevel(acc, level);
//	}
	
	//findByLevelOrderByIdASC
//	@ResponseBody
//	@GetMapping("/customer/level")
//	public List<YJCustomer> findByLevelOrderByIdASC(@RequestParam Integer level){
//		return customerDao.findCustomerByLevelOrderById(level);
//	}
	
	//////////////////// findCustomerByAccNativeQuery原生 //////////////////////
	
//	@ResponseBody
//	@GetMapping("/customer/native/acc")
//	public YJCustomer findCustomerByAccNativeQuery(@RequestParam String acc) {
//		return customerDao.findCustomerByAccNativeQuery(acc);
//	}
	
	//deleteCustomerById
//	@ResponseBody
//	@DeleteMapping("/customer/delete/id")
//	public String deleteCustomerById(@RequestParam Integer id) {
//		customerDao.deleteCustomerById(id);
//		return "刪除成功";
//	}
	
	//////////////// JpaRepostitory透過方法名稱直接查詢 //////////////////
	//findByAccContaining 此處的Acc必須與Customer.java中欄位 private String acc 的型態與名稱相同
//	@ResponseBody //未註釋抱錯  "timestamp": "2023-02-22T08:28:34.572+00:00", "status": 404, "error": "Not Found", "message": "JSP file [/WEB-INF/jsp/customer/like.jsp] not found", "path": "/83-app/customer/like"
//	@GetMapping("/customer/like")
//	public List<YJCustomer> findByAccContaining(@RequestParam("str") String str){
//		return customerDao.findByAccContaining(str);
//	}
}
