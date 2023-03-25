package com.iSpanProject.GoodByeletter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CookieConfig implements WebMvcConfigurer {

	@Autowired
	private LoginInterceptor loginInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		System.out.println("我是攔截器");
		registry.addInterceptor(loginInterceptor).addPathPatterns("/*","/LastNote/**")
      .excludePathPatterns("/ECPay/**","YiJie/updatePic.jsp","/customer/picture/page1","/customer/picture/updata1","/logout","/user/login","/lastNoteLogin","/login","/board/**","/topGun/**","/register/**","/forgetpwd/**","/mynav.jsp");

	}
}
////addPathPatterns("/**") 表示攔截所有的請求
////excludePathPatterns("/firstLogin","/zhuce");設置白名單，就是攔截器不攔截。首次輸入帳號密碼登錄和註冊不用攔截！
