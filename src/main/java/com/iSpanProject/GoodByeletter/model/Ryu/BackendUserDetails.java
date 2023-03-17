package com.iSpanProject.GoodByeletter.model.Ryu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.iSpanProject.GoodByeletter.model.Lillian.Register;

public class BackendUserDetails implements UserDetails {
	
	
	private static final long serialVersionUID = 1L;
	
	
	
	private Register register;
	
	
	
	public BackendUserDetails(Register register) {
		super();
		this.register = register;
	}



	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> authority_list = new ArrayList<SimpleGrantedAuthority>();
		
		authority_list.add(new SimpleGrantedAuthority(register.getFK_Plevel().getLevelName()));
		
		return authority_list;
	}
	
	

	@Override
	public String getPassword() {
		
		return register.getPassword();
		
	}

	@Override
	public String getUsername() {
		
		return register.getAccount();
		
	}
	
	
	//驗證此帳號是否未過期，目前沒有要用到先設return true
	@Override
	public boolean isAccountNonExpired() {
		
		return true;
		
	}
	
	
	//驗證此帳號是否未被封鎖，目前沒有要用到先設return true
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
		
	}
	
	
	//驗證此帳號憑證是否未過期，目前沒有要用到先設return true
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
		
	}
	
	
	//驗證此帳號是否可以使用，目前沒有要用到先設return true
	@Override
	public boolean isEnabled() {
		
		return true;
		
	}
	
	
	
	
	
	
}
