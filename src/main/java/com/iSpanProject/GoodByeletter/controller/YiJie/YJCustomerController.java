package com.iSpanProject.GoodByeletter.controller.YiJie;

import java.util.HashMap;
import java.util.LinkedList;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iSpanProject.GoodByeletter.dao.Lillian.RegisterDao;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.YiJie.Picture;
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
	@Autowired
	private RegisterDao rDao;
	
	private static final String Code = "123";//預設驗證碼
///////////////////////////////////////////////////////////////	
	//註冊(禁制註冊重複帳號、並加入驗證錯誤訊息
	@GetMapping("/customer/add/page")
	public String registerCusPage() {
		return "YiJie/mycompany";
	}
	
	@PostMapping("/customer/add")
	public String registerCus(@RequestParam(value = "account") String acc,
							  @RequestParam(value = "password") String pass,
							  @RequestParam("rCode") String rCode,
							  @RequestParam(value = "type") String type,//0318
						      Model model) {
		//去後端找有沒有相同的帳號
		Register reg = rDao.findRegisterByAcc(acc);
		String account = reg.getAccount();
		if(account != null) {
			model.addAttribute("errorMessage", "該帳號已經存在");
			return "YiJie/mycompany";
		}
		if(Code.equals(rCode)) {
			Register cus1 = new Register();
			cus1.setAccount(acc);
			cus1.setPassword(pass);
		
			customerService.insert(cus1);
			//加上車車來載memberId
			Register reg1 = customerService.findByAccAndPass(acc, pass);
			Integer memberId = reg1.getMemberId();
			model.addAttribute("memberId", memberId);
			
			//新增帳號時同時建立detail
			YJCustomerDetail detail1 = new YJCustomerDetail();
			Register reg2 = customerService.findById(memberId);
			detail1.setFK_memberId(reg2);
			detail1.setType(type);
			
			///////////////////////////
			detailService.insert(detail1);
			return "redirect:/";
		}else {
			model.addAttribute("errorMessage", "驗證碼輸入錯誤");
			return "YiJie/mycompany";
		}
	}
	
	//登入
	@GetMapping("/customer/login/page")
	public String loginCus1Page1() {
		return "YiJie/cuslogin";
	}
	@PostMapping("/customer/login")
	public String loginCus(@RequestParam(value="account") String acc, 
			@RequestParam(value="password") String pass, 
			HttpSession session,
			Model model) {
		
		Register exis = customerService.findByAccAndPass(acc, pass);
		if( exis != null ) {
			model.addAttribute("register", exis);
			
			String acc1 = exis.getAccount();
			String pass1 = exis.getPassword();
			
			if (acc.equals(acc1) && pass.equals(pass1)) {
				session.setAttribute("exis", exis);
				return "YiJie/companylogin";
			}
		}
		model.addAttribute("errorMessage", "此帳號不存在");
		return "YiJie/cuslogin";
	}
	
	//登出
	@GetMapping("/customer/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	

	/////####################  input check  ################################//////
	
//	@PostMapping("/customer/add2")
//	public String registerCus2(@ModelAttribute("inputCheck") Register reg,
//								@RequestParam("rCode") String rCode,
//								Model model) {
//		Map<String, String> errors = new HashMap<String, String>();
//		model.addAttribute("errors", errors);
//		// 檢查帳號是否重複
//		if(customerService.findByAcc(reg.getAccount()) != null) {
//			errors.put("message", "該帳號已被註冊!");
//		}
//		// 檢查驗證碼是否錯誤
//		if(Code.equals(rCode)) {
//			errors.put("message", "驗證碼錯誤!");
//		}
//		// 檢查帳號是否有輸入
//		if(reg.getAccount() == null || reg.getAccount().isEmpty()) {
//			errors.put("message", "請輸入您的帳號!");
//		}
//		// 檢查密碼是否有輸入
//		if(reg.getPassword() == null || reg.getPassword().isEmpty()) {
//			errors.put("message", "請輸入您的帳號!");
//		}
//		
//		if (!errors.isEmpty()) {
//		return "YiJie/mycompany";
//		}
//		
//		///////////
//			//加上車車來載memberId
//		customerService.insert(reg);
//		Register company = customerService.findByAccAndPass(reg.getAccount(), reg.getPassword());
//		Integer memberId = company.getMemberId();
//		model.addAttribute("memberId", memberId);
//			//創建對應的detail
//		YJCustomerDetail detail1 = new YJCustomerDetail();
//		Register reg2 = customerService.findById(memberId);
//		detail1.setFK_memberId(reg2);
//		detailService.insert(detail1);
//		////////////
//		return "YiJie/cuslogin";
//		
//	}
//	
	
	/////####################  input check  ################################//////

/////////////////////////////////////////////////////////////////////0313
//	//
//	@GetMapping("/gologin")
//	public String loginCus1Page() {
//		return "YiJie/companylogin";
//	}
//	
//	@GetMapping("/example/company")
//	public String mycompanyPage() {
//		return "example/mycompany";
//	}
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
