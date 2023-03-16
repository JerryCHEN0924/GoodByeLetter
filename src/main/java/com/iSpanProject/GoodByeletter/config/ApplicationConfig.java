package com.iSpanProject.GoodByeletter.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;
import com.iSpanProject.GoodByeletter.model.Ryu.BackendUserDetails;

@Configuration
@EnableWebSecurity
public class ApplicationConfig {
	
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	
	
	
	
	
	
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				
				System.out.println("##################################");
				System.out.println("##################################");
				System.out.println("loadUserByUsername = " + username);
				System.out.println("##################################");
				System.out.println("##################################");
				
				
				Register register = backendRegisterRepository.findRegisterByAccount(username);
				
				String encode = passwordEncoder().encode(register.getPassword());
				
				
				register.setPassword(encode);
				
				
				
				List<Level> roles = Arrays.asList(register.getFK_Plevel());
				
				
				List<String> roleIds4 = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
				String rolesString4 = String.join(",", roleIds4);
				
				
				System.out.println("============");
				System.out.println("============");
				System.out.println("roleIds4 = " + roleIds4);
				System.out.println("rolesString4 = " + rolesString4);
				System.out.println("============");
				System.out.println("============");
				
				
				
				
				
				
				
				
				
				
				return new BackendUserDetails(register);
				
				
				}
				
			};
		}
	
	
	
	
	
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userDetailsService());
		
		authProvider.setPasswordEncoder(passwordEncoder());
		
		
		return authProvider;
		
		
		
	}
	
	
	
	
	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		
		return config.getAuthenticationManager();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
//	@Bean
//	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		 
//		 // 自定義沒有訪問權限訪問跳轉頁面
//		 http.exceptionHandling().accessDeniedPage("/WEB-INF/views/Ryu/unauthMessage.jsp");
//		 
//		 http.logout().logoutUrl("/logout").logoutSuccessUrl("/lastNoteLogout").permitAll();
//		 
//		 http.formLogin()
//		 
//		 
//		 .loginPage("/lastNoteLogin") // 自定義自己編寫的登入頁面
//		 
//		 .loginProcessingUrl("/user/login") // 登入頁面設置
//		 
//		 .defaultSuccessUrl("/successLogin", true).permitAll()
//	
//		 .and().authorizeRequests() // 定義那些Url被保護，那些不被保護
//
//	 	 .antMatchers("/",
//	 	 			"/register/**", "/register1", "/memberDetail/**",
//	 	 			"/customer/**", "/picture/**",
//	 	 			"/board/**", "/comment/**", "/wschat/**", "/ws/**",
//	 	 			"/LastNote/**",
//	 	 			"/css/**", "/js/**", "/images/**", "/assets/**",
//	 	 			"/user/login").permitAll() // 設置哪些路徑可以直接訪問，不需要認證 匹配到的路徑, 不需要身份驗證
//	 	 	
//	 	 .antMatchers("/ws", "/chat/**").permitAll()  // 允許 WebSocket 路徑訪問
//	 	 	 
//	 	 	 
//	 	 .antMatchers("/getTest").permitAll()  // 允許 測試 路徑訪問
//	
//	 	 .antMatchers("/topGun/**").hasAuthority("超級管理員")
//	
//	
//	 	.anyRequest().authenticated() // 其他尚未匹配到的url都需要身份驗證
//	 	 .and()
//	 	 .authenticationProvider(authenticationProvider());
//	 	
//	 
//	 	 
//	 	// 關閉csrf防護
//	 	 http.csrf().disable();
//	 
//	 	 http.rememberMe()
//	 	 
//	 	.rememberMeParameter("remember-me") // 設置 remember-me 的 input 名稱
//        .userDetailsService(userDetailsService()) // 設置 UserDetailsService
//        .tokenValiditySeconds(60) // 設置 remember-me 的有效期時間
//        .useSecureCookie(true); // 設置是否使用安全 Cookie
//	
//	
//	 	return http.build();
//		
//		
//	   }
	
	
	
	
	
		
				
	

}
