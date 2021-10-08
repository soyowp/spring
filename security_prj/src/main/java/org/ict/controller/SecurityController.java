package org.ict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/secu/*")
public class SecurityController {

	@GetMapping("/all")
	public void doAll() {
		log.info("모든사람이 접속 가능");
	}

	@GetMapping("/member")
	public void doMember() {
		log.info("멤버만 접속 가능");
	}

	@GetMapping("/admin")
	public void doAdmin() {
		log.info("운영자만 접속 가능");
	}


}