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

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerDetail;
import com.iSpanProject.GoodByeletter.model.YiJie.YJCustomerRepository;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerDetailService;
//import com.iSpanProject.GoodByeletter.model.YiJie.YJLevel;
import com.iSpanProject.GoodByeletter.service.YiJie.YJCustomerService;

@Controller
public class YJCustomerController {
	
	
	@Autowired
	private YJCustomerService customerService;
	@Autowired
	private YJCustomerDetailService detailService;
	
	private static final String Code = "123";//預設驗證碼
///////////////////////////////////////////////////////////////	
	//註冊
	
	@GetMapping("/customer/add")
	public String registerCusPage() {
		return "YiJie/mycompany";
	}
	
	@PostMapping("/customer/registeradd")
	public String registerCus(@RequestParam(value = "account") String acc,
							  @RequestParam(value = "password") String pass,
							  @RequestParam("rCode") String rCode,
							  //HttpSession session,
						      Model model) { 
		
		if(Code.equals(rCode)) {
			Register cus1 = new Register();
			cus1.setAccount(acc);
			cus1.setPassword(pass);
		
			customerService.insert(cus1);
			///////////
			//加上車車來載memberId
			Register reg = customerService.findByAccAndPass(acc, pass);
			Integer memberId = reg.getMemberId();
			model.addAttribute("memberId", memberId);
			
			YJCustomerDetail detail1 = new YJCustomerDetail();
			Register reg2 = customerService.findById(memberId);
			detail1.setFK_memberId(reg2);
			detailService.insert(detail1);
			////////////
			
			Map<String, String> msg = new HashMap<String, String>();
			model.addAttribute("msg", msg);
			msg.put("success", "會員註冊成功!");
			return "redirect:/";
		}else {
			return "/customer/add";
		}
	}
	
	
	@GetMapping("/customer/page")
	public String loginCus1Page1() {
		return "YiJie/cuslogin";
	}
	
	//登入
	@PostMapping("/customer/login")
	public String loginCus(@RequestParam(value="account") String acc, 
						   @RequestParam(value="password") String pass, 
						   HttpSession session,
						   Model model) {
		
		Register exis = customerService.findByAccAndPass(acc, pass);
		
		model.addAttribute("register", exis);
		
		String acc1 = exis.getAccount();
		String pwd = exis.getPassword();
			
		if (acc.equals(acc1) && pass.equals(pwd)) {
			session.setAttribute("existing", exis);
			
			return "YiJie/companylogin";
		} else {
			return "/gologin";
		}
	}

	@GetMapping("/gologin")
	public String loginCus1Page() {
		return "YiJie/companylogin";
	}
	
	@GetMapping("/example/company")
	public String mycompanyPage() {
		return "example/mycompany";
	}
	//登出
//		@GetMapping("/register/logout")
//		public String logoutRegister(HttpSession session) {
//			session.invalidate();
//			return "redirect:/";
//		}
//////////////////////////////////////////////////////////////////////	
//
//	@ResponseBody
//	@GetMapping("/customers")
//	public List<Register> findAll(){
//		return customerDao.findAll();
//	}
////	
//	@ResponseBody
//	@DeleteMapping("/customer/delete")
//	public String deleteById(@RequestParam Integer id) {
//		try {
//			customerDao.deleteById(id);
//			return "刪除成功";
//		}catch(EmptyResultDataAccessException e) {
//			return "沒有這筆資料";
//		}
//		
//	}
	
	
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
