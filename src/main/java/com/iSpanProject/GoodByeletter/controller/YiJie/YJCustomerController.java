package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomer;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerRepository;
//import com.iSpanProject.GoodByeletter.model.YiJie.YJLevel;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerService;

@Controller
public class YJCustomerController {
	
	@Autowired
	private YJCustomerRepository customerDao;
	@Autowired
	private YJCustomerService customerService;
	
	private static final String Code = "123";//預設驗證碼
	
	//註冊
	
	@GetMapping("/customer/register")
	public String registerCusPage() {
		return "registerCus";
	}
	
	@PostMapping("/customer/register")
	public String registerCus(@RequestParam(value = "account") String acc,
							@RequestParam(value = "password") String pass,
							@RequestParam("rCode") String rCode,
						   Model model) { 
		
		if(Code.equals(rCode)) {
			YJCustomer cus1 = new YJCustomer();
			cus1.setAcc(acc);
			cus1.setPass(pass);
		
			customerService.insert(cus1);
			Map<String, String> msg = new HashMap<String, String>();
			model.addAttribute("msg", msg);
			msg.put("success", "會員註冊成功!");
			return "YiJie/customerDetail";
		}else {
			return null;
		}
	}
	//登入
	
	@GetMapping("/customer/page")
	public String loginCus1Page() {
		return "YiJie/mycompany";
	}
	
	@PostMapping("/customer/login")
	public String loginCus(@RequestParam(value="account") String acc, 
						@RequestParam(value="password") String pass, 
						HttpSession session) {
		
		//Register existing = registerService.findByAccAndPwd(account, password);
		YJCustomer exis = customerService.findByAccAndPass(acc, pass);

		String acc1 = exis.getAcc();
		String pwd = exis.getPass();
		
		if (acc.equals(acc1) && pass.equals(pwd)) {
			session.setAttribute("acc", acc1);
			session.setAttribute("pwd", pwd);
			
			return "redirect:/";//如果有帳號回主頁面
		} else {
			return "redirect:/login01";//失敗重新輸入
		}
	}
	
//////////////////////////////////////////////////////////////////////	
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
	
	
//	//註冊1.0
//	@ResponseBody //等外面傳入json，接住反序列化成java物件
//	@PostMapping("/customer/register")
//	public String register(@RequestBody YJCustomer customer,
//						   //@RequestBody YJLevel level,
//						   @RequestParam("level") YJLevel level,
//						   String verificationCode,
//						   Model model) { 
//		
////		// 解析請求中的帳號、密碼和驗證訊息
////        String acc = customer.getAcc();
////        //String pass = customer.getPass();
////        
////        YJCustomer existingCustomer = customerDao.findCustomerByAcc(acc);
////		if( existingCustomer != null ) {
////			return "已經有此帳號了!";
////		}
////		// 驗證訊息為 "123" 時，帳號等級提升至 level=2
////        if ("123".equals(verificationCode)) {
////        	
////        	YJLevel lev1 = new YJLevel();
////        	lev1.setPlevel(2);
////        	customer.setLevel(lev1);	
////            //customer.setLevel(2);
////        	
////        }
//		customerDao.save(customer);
//		return "成功";
//	}
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
