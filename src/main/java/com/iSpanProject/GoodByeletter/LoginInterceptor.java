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
    	System.out.println("我是??????");
    	HttpSession session = request.getSession();
    	
        // 獲取 Cookie 中的用户信息
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getValue().equals("1")) {
                    // 根據用户 ID 查詢數據庫獲取用户信息
                	Integer memberId = Integer.parseInt(cookie.getValue());
                	Register register = registerService.findById(memberId);
                	session.setAttribute("existing", register);
                    return true;
                }
            }
        }
        // 跳轉到登錄頁面
        response.sendRedirect(request.getContextPath() + "/register/login1");
        return false;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        
    }
 
}
