package org.ict.service;

import org.ict.domain.MemberVO;
import org.ict.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserServiceImpl implements UserSerivce {

	@Autowired
	private MemberMapper mapper;

	@Override
	public String register(MemberVO vo) {
		log.info("회원가입 실행");
		PasswordEncoder pwen = null;
		String pw = pwen.encode(vo.getUserpw());
		vo.setUserpw(pw);
		mapper.join(vo);
		log.info("회원가입 완료");
		mapper.authJoin(vo);
		log.info("인증가입 완료");

		return "/secu/all";
	}
}