package com.iSpanProject.GoodByeletter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.service.Lillian.RegisterService;

@Component
public class LoginInterceptor implements HandlerInterceptor {
 
	@Autowired
	private RegisterService registerService;
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//    	System.out.println("我是??????");
    	HttpSession session = request.getSession();
    	String requestURI = request.getRequestURI();//為了抓使用者要到的rui
    	 System.out.println(requestURI);
    	boolean cookieFound = false;
    	// 獲取 Cookie 中的用户信息
    	Cookie[] cookies = request.getCookies();//getcookie出來是陣列，所以要Cookie[]
    	if (cookies != null) {
    	    for (Cookie cookie : cookies) {//java不能直接用name抓到對應的cookie
    	        if (cookie.getName().equals("memberId") && !cookie.getValue().equals(null)) {
    	            // 根據用户 ID 查詢數據庫獲取用户信息
    	            Integer memberId = Integer.parseInt(cookie.getValue());//本來cookie裡面是字串所以要轉成數字
    	            Register register = registerService.findById(memberId);
    	            session.setAttribute("existing", register);
    	            cookieFound = true;
    	            break;
    	        }else {
//    	        	System.out.println("nonononononnonono cookie"); 	        	
    	        }
    	    }
    	}
    	if (cookieFound) {
    	    // 如果從Cookie中獲取到了數據，則直接返回true
    	    return true;
    	} else {
    	    // 如果從Cookie中没有獲取到數據，則從session中獲取數據
    	    Register register = (Register) session.getAttribute("existing");
    	    if (register != null) {
    	        return true;
    	    } else {
    	    	if(!"/index/".equals(requestURI)){//如果沒有session或cookie，使用者點擊除了首頁以外 -> return false 就會到/register/login1
    	    		response.sendRedirect(request.getContextPath()+"/register/login1");
    	    		return false;
    	    	}
    	        return true;//如果使用者想要進入index,-> return true 就可以進去
    	    }
    	}
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }
 
}
