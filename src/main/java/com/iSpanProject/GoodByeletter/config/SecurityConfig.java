package com.iSpanProject.GoodByeletter.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
import com.iSpanProject.GoodByeletter.model.Lillian.Level;
import com.iSpanProject.GoodByeletter.model.Lillian.Register;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	
	
	@Autowired
	private BackendRegisterRepository backendRegisterRepository;
	
//	@Autowired
//	private BackendUserDetailsService backendUserDetailsService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	
	
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 
		 
		 // 自定義沒有訪問權限訪問跳轉頁面
		 http.exceptionHandling().accessDeniedPage("/WEB-INF/views/Ryu/unauthMessage.jsp");
		 
		 http.logout().logoutUrl("/logout").logoutSuccessUrl("/lastNoteLogout").permitAll();
		 
		 http.formLogin()
		 
//		 	 .permitAll()
		 
		 	 // 測試 HTML
//		 	 .loginPage("/WEB-INF/views/loginFormTest.html") // 自定義自己編寫的登入頁面
//		 	 .loginPage("/loginFormTest.html")
		 	 
		 	 // 無法直接訪問 /WEB-INF/views
//		 	 .loginPage("/WEB-INF/views/loginForm.jsp") // 自定義自己編寫的登入頁面
		 
		 	 // 無法放到 src/main/resources/static 之下，static 不能放 JSP 只能放靜態文件
//		 	 .loginPage("/loginForm.jsp") // 自定義自己編寫的登入頁面
		 	 
		 	 
		 	 // 先自定義一個 Page Controller 讓他跳轉到登入頁面
		 	 .loginPage("/lastNoteLogin") // 自定義自己編寫的登入頁面
		 	 
		 	 // 預設
//		 	.loginPage()
		 	 
		 	 
//		 	 .permitAll()
		 	 
		 	 .loginProcessingUrl("/user/login") // 登入頁面設置
		 	 
		 	 
		 	 // 測試 controller /home 由 GetMapping 改成 PostMapping
//		 	 .defaultSuccessUrl("/home").permitAll()
		 	 
		 	 
		 	 // .defaultSuccessUrl("/home", true) 是正規的方式，true 表示重定向，是將請求重定向到 "/home" 路徑，而非直接請求該路徑。
		 	 // 第二個參數用於指定是否允許使用POST方法進行重定向。因為重定向只能使用GET方法，如果在登入成功後進行重新定向使用POST方法，就會導致問題。
		 	 // 所以在這種情況下，如果重新定向是通過POST方式完成的，則可以使用該參數來解決這個問題。
		 	 .defaultSuccessUrl("/successLogin", true).permitAll()
//		 	 .defaultSuccessUrl("/topGun/backendHome", true).permitAll()
		 	 
//		 	 .loginProcessingUrl("/user/login").permitAll() // 登入頁面設置
//		 	 .defaultSuccessUrl("/")
		 	 
//		 	 .defaultSuccessUrl("/topGun/backendHome").permitAll() // 登入成功之後，跳轉路徑
//		 	 .defaultSuccessUrl("/home").permitAll() // 登入成功之後，跳轉路徑
//		 	 .defaultSuccessUrl("/").permitAll() // 登入成功之後，跳轉路徑
		 	 
		 	 .and().authorizeRequests() // 定義那些Url被保護，那些不被保護

		 	 	.antMatchers("/",
		 	 			"/register/**", "/register1", "/memberDetail/**",
		 	 			"/customer/**", "/picture/**",
		 	 			"/board/**", "/comment/**", "/wschat/**", "/ws/**",
		 	 			"/LastNote/**",
		 	 			"/css/**", "/js/**", "/images/**", "/assets/**",
		 	 			"/user/login").permitAll() // 設置哪些路徑可以直接訪問，不需要認證 匹配到的路徑, 不需要身份驗證
		 	 	
		 	 	 .antMatchers("/ws", "/chat/**").permitAll()  // 允許 WebSocket 路徑訪問
		 	 	
		 	 	//當前登入用戶，只有具有1的權限才可以訪問這個路徑
//		 	 	.antMatchers("/topGun/backendMember/add").hasAuthority("超級管理員")
//		 	 	.antMatchers("/topGun/backendMember/add").hasAuthority("一般會員")
		 	 	
//		 	 	.antMatchers("/topGun/backendMember/add").hasRole("一般會員")
//		 	 	.antMatchers("/topGun/backendMember/add").hasAuthority("ROLE_一般會員")
		 	 	
//		 	 	.antMatchers("/topGun/backendMember/add").hasAuthority("admin")
		 	 	
		 	 	// 可以動，後端設置 .roles("admin")
//		 	 	.antMatchers("/topGun/backendMember/add").hasRole("admin")
		 	 	
		 	 	// 不能動
//		 	 	.antMatchers("/topGun/backendMember/add").hasRole("user")
		 	 	
		 	 	// 能動 ... 括號?__?
//		 	 	.antMatchers("/topGun/backendMember/add").hasRole("[user]")
		 	 	
		 	 	
		 	 	// 終於 ... 
//		 	 	.antMatchers("/topGun/backendMember/add").hasRole("admin")
//		 	 	.antMatchers("/topGun/backendMember/add").hasRole("user")
		 	 	
		 	 	
		 	 	
		 	 	.antMatchers("/topGun/**").hasRole("超級管理員")
		 	 	
		 	 	
//		 	 	.antMatchers("/wschat/**").hasRole("超級管理員")
		 	 	
//		 	 	.antMatchers("/register/**").hasRole("一般會員")
//		 	 	
//		 	 	.antMatchers("/customer/**").hasRole("廣告商")
		 	 	
		 	 	
		 	 	
		 	 	
//		 	 	.antMatchers("/topGun/backendMember/add").hasRole("一般會員")
		 	 	
		 	 	
		 	 	
		 	 	
		 	 	
		 	 	
		 	 
		 	 .anyRequest().authenticated(); // 其他尚未匹配到的url都需要身份驗證
		 
		 
		 
		 	 
		 	// 關閉csrf防護
		 	 http.csrf().disable();
		 
		 
		 	 http.rememberMe()
		 	 	 .rememberMeParameter("remember-me")
		 	 	 .userDetailsService(userDetailsService())
		 	 	 .tokenValiditySeconds(60 * 3);
//		 	 	 .tokenValiditySeconds(60 * 60 * 24 * 7); // 通常都會大於 session timeout 的時間
		 	 
		 	 
		 	 
		 
		 
//       http
//               .authorizeHttpRequests()
//               .anyRequest().authenticated();
//       http
//               .formLogin();
	
	
	

       return http.build();
	
	
   }
	
	
	
	
	
	
	
	
	
	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
				
				
				
				Register register = backendRegisterRepository.findRegisterByAccount(account);
				
				
				List<Level> roles = Arrays.asList(register.getFK_Plevel());
				
				List<String> roleNames = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
				
				List<String> roleIds = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
				List<String> roleIds2 = roles.stream().map(role -> "ROLE_" + role.getLevelName()).collect(Collectors.toList());
				
				
				String rolesString = Arrays.toString(roleIds.toArray(new String[0]));
				String rolesString2 = Arrays.toString(roleIds2.toArray(new String[0]));
				
				System.out.println("============");
				System.out.println("============");
				System.out.println(roleIds);
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println(roleIds2);
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println(roleIds.toArray(new String[0]));
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println("rolesString = " + rolesString);
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println("============");
				System.out.println("rolesString2 = " + rolesString2);
				System.out.println("============");
				System.out.println("============");
				
				
				List<String> roleIds3 = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
				String rolesString3 = String.join(",", roleIds3);
				
				System.out.println("============");
				System.out.println("============");
				System.out.println("roleIds3 = " + roleIds3);
				System.out.println("rolesString3 = " + rolesString3);
				System.out.println("============");
				System.out.println("============");
				
				
				List<String> roleIds4 = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
				String rolesString4 = String.join(",", roleIds4);
				
				
				System.out.println("============");
				System.out.println("============");
				System.out.println("roleIds4 = " + roleIds4);
				System.out.println("rolesString4 = " + rolesString4);
				System.out.println("============");
				System.out.println("============");
				
				String encodedPassword = passwordEncoder().encode(register.getPassword());
				
				
//				if(register == null) throw new UsernameNotFoundException("No user found with email");
				
				
//				if(register == null){
//			        throw new UsernameNotFoundException("No user found with email");
//			    }
				
				UserDetails userDetails = 
						org.springframework.security.core.userdetails.User.builder()
						.username(register.getAccount())
		                .password(encodedPassword)
//		                .password(encoder.encode(register.getPassword()))
//		                .roles("USER")
//		                .roles(roleNames.toArray(new String[0]))
		                
//		                .roles(rolesString)
//		                .roles("一般會員")
		                
//		                .roles(rolesString)
		                
		                
		                // 可以動，前端設置 .hasRole("admin")
//		                .roles("admin")
		                
		                // 不能動 ？？？
//		                .roles(rolesString)
		                
		                
		                .roles(rolesString3)
//		                .roles(rolesString4)
		                
		                .build();
				
				
				return userDetails;
				
				
				
				
			}
			
		};
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
