package org.ict.security;

import org.ict.domain.CustomUser;
import org.ict.domain.MemberVO;
import org.ict.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		log.warn("유저이름 확인 : " + username);
		
		MemberVO vo = mapper.read(username);
		
		log.info("확인된 유저이름에서 얻어온 정보 : " + vo);
		return vo == null? null : new CustomUser(vo);
	}
	

	
}
