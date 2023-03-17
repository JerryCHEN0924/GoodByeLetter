//package com.iSpanProject.GoodByeletter.service.Ryu;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.iSpanProject.GoodByeletter.dao.Ryu.BackendRegisterRepository;
//import com.iSpanProject.GoodByeletter.model.Lillian.Register;
//import com.iSpanProject.GoodByeletter.model.Ryu.BackendUserDetails;
//
//
//
//
//@Service
//public class BackendUserDetailsService implements UserDetailsService {
//	
//	
////	@Autowired
////	public PasswordEncoder encoder;
//	
//	
////	@Autowired
////	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	
//	@Autowired
//	private BackendRegisterRepository backendRegisterRepository;
//	
//	
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		
//		
//		System.out.println("##################################");
//		System.out.println("##################################");
//		System.out.println("loadUserByUsername = " + username);
//		System.out.println("##################################");
//		System.out.println("##################################");
//		
//		
//		
//		Register register = backendRegisterRepository.findRegisterByAccount(username);
//		
//		
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		
//		String encode = encoder.encode(register.getPassword());
//		
//		register.setPassword(encode);
//		
//		
//		
//		
////		List<Level> roles = Arrays.asList(register.getFK_Plevel());
////		
////		List<String> roleNames = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
////		
////		List<String> roleIds = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
////		List<String> roleIds2 = roles.stream().map(role -> "ROLE_" + role.getLevelName()).collect(Collectors.toList());
////		
////		
////		String rolesString = Arrays.toString(roleIds.toArray(new String[0]));
////		String rolesString2 = Arrays.toString(roleIds2.toArray(new String[0]));
////		
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println(roleIds);
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println(roleIds2);
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println(roleIds.toArray(new String[0]));
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("rolesString = " + rolesString);
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("rolesString2 = " + rolesString2);
////		System.out.println("============");
////		System.out.println("============");
////		
////		
////		List<String> roleIds3 = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
////		String rolesString3 = String.join(",", roleIds3);
////		
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("roleIds3 = " + roleIds3);
////		System.out.println("rolesString3 = " + rolesString3);
////		System.out.println("============");
////		System.out.println("============");
////		
////		
////		List<String> roleIds4 = roles.stream().map(role -> role.getLevelName()).collect(Collectors.toList());
////		String rolesString4 = String.join(",", roleIds4);
////		
////		
////		System.out.println("============");
////		System.out.println("============");
////		System.out.println("roleIds4 = " + roleIds4);
////		System.out.println("rolesString4 = " + rolesString4);
////		System.out.println("============");
////		System.out.println("============");
////		
////		
////		if(register == null){
////	        throw new UsernameNotFoundException("No user found with email");
////	    }
////		
////		UserDetails userDetails = 
////				org.springframework.security.core.userdetails.User.builder()
////				.username(register.getAccount())
////                .password(encoder.encode(register.getPassword()))
//		
//		
//		
////                .roles("USER")
////                .roles(roleNames.toArray(new String[0]))
//                
////                .roles(rolesString)
////                .roles("一般會員")
//                
////                .roles(rolesString)
//                
//                
//                // 可以動，前端設置 .hasRole("admin")
////                .roles("admin")
//                
//                // 不能動 ？？？
////                .roles(rolesString)
//                
//                
////                .roles(rolesString4)
//                
////		.roles(rolesString3)
////                .build();
//		
//		
//		
//		
//		
//		
//		return new BackendUserDetails(register);
//		
//		
//		
//	}
//	
//	
//	
//	
//	// 可以增加一個新增會員資料的方法 with 存入加密過後的密碼 encoder
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//}
