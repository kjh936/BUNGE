package com.bunge.member.security;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.bunge.admin.service.AdminService;
import com.bunge.member.domain.Member;
import com.bunge.member.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/*
  	1. UserDetails 인터페이스는 Securiy애소 사용자 정보를 담는 인터페이스
  	
  	2. UserDeatilsService 인터페이스는 DB에서 유저 정보를 불러오는 loadUserByUsername()가 존재합니다.
  	
  	3. UserDaetails 인터페이스를 구현한 클래스는 실제로 사용자의 정보와 사용자가가 가진 권한의 정보를 처리해서 반환반환하게 됩니다.
  			예)		UserDetails user = new User(username, users.getPassword() , roles);
 */
@Component
public class CustomUserDatilsService implements UserDetailsService{
	
	@Autowired
	MemberMapper membermapper;

	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Member member = membermapper.checkid(username);

		if(member==null) {

			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return member;
	}

}
