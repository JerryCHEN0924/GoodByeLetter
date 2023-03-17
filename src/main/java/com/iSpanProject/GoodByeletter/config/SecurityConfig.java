package com.iSpanProject.GoodByeletter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 
		 http.exceptionHandling().accessDeniedPage("/WEB-INF/views/Ryu/unauthMessage.jsp");
		 
		 http.logout().logoutUrl("/logout").logoutSuccessUrl("/").permitAll();
		 
		 http.formLogin()
		 
		 	 .loginPage("/lastNoteLogin")
		 	 
		 	 .loginProcessingUrl("/user/login")
		 	 
		 	 
		 	 .defaultSuccessUrl("/topGun", true).permitAll()
		 	 
		 	 .and().authorizeRequests()
		 	 
		 	 
//		 	 ====================================================================================
//		 	 ====================================================================================
		 	 
		 	 
		 	 
		 	 	.antMatchers("/topGun/**").hasAuthority("超級管理員")
		 	 	
		 	 	.antMatchers("/**").permitAll(); // 允許 所有路徑訪問
		 
		 
		 
//		 	 ====================================================================================
//		 	 ==================================================================================== 
		 	 	
		 	 http.csrf().disable();
		 
		 	 http.rememberMe();
		 	 
	

       return http.build();
	
	
   }
	
	
	
	
	
	
	
	

}
