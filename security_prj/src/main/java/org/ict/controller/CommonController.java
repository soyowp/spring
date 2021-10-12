package org.ict.controller;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("접근거부 : " + auth);
		model.addAttribute("errorMessage", "접근 불허");
	}

	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error여부 : " + error);
		log.info("logout 여부 : " + logout);

		if (error != null) {
			model.addAttribute("error", "로그인 에러입니다 계정 확인을 해주세요");
		}
		if (logout != null) {
			model.addAttribute("logout", "로그아웃했습니다.");
		}
	}

	@GetMapping("/customLogout")
	public void logoutGet() {
		log.info("로그아웃합니다");
	}

//	@PostMapping("/customLogout")
//	public void logoutPost() {
//		//이부분이 출력이 안되는데 로그아웃이 작동합니다
//		// 세션 파기는 security-context에서 합니다.
//		// 아래로직이 출력 안되던 이유가
//		//logoutPost에 무단으로 파라미터를
//		//지벙넣어서 안된것같습니다. 다시해보세요. 넵
//		log.info("포스트방식 로그아웃 요청");
//		log.info("세션 파기 실행");
//		
//		//넣어본적이 업성서 사실.. 그냥 명목상으로
//		// 처리해줄 수 있는 주소만 넣는 형식인가보네요.
//		//넵 알겠습니다! 감사합니다!
//		
//	}
}
