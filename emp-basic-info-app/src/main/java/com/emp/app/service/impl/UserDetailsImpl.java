package com.emp.app.service.impl;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.emp.app.entity.EmplyeeBasicInfoEntity;

public class UserDetailsImpl implements UserDetails{

	private static final long serialVersionUID = 4398561209072388334L;
	private EmplyeeBasicInfoEntity emplyeeBasicInfoEntity;
	
	public UserDetailsImpl(EmplyeeBasicInfoEntity emplyeeBasicInfoEntity) {
		this.emplyeeBasicInfoEntity = emplyeeBasicInfoEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return emplyeeBasicInfoEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return emplyeeBasicInfoEntity.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
