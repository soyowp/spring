package org.ict.controller;

import org.ict.domain.MemberVO;
import org.ict.service.UserSerivce;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/secu/*")
public class SecurityController {
	
	private UserSerivce service;

	@GetMapping("/all")
	public void doAll() {
		log.info("모든사람이 접속 가능");
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@GetMapping("/member")
	public void doMember() {
		log.info("멤버만 접속 가능");
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/admin")
	public void doAdmin() {
		log.info("운영자만 접속 가능");
	}

	@GetMapping("/join")
	public String join() {
		return "secu/join";
	}
	
	@PostMapping("/join")
	public String doJoin(MemberVO vo) {
	log.info("회원가입기능 실행");
	service.register(vo);
	return "/secu/login";
	
}
}
