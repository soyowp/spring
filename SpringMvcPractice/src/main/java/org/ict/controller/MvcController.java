package org.ict.controller;

import java.util.Scanner;

import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// 빈 컨테이너에 넣어주기(등록 안하면 사용 불가)

@Controller
public class MvcController {

	// 기본주소 (localhost:8181)뒤에 /goA를 붙이면 goA실행
	@RequestMapping(value = "/goA")
	public String goA() {
		System.out.println("goA 주소 접속 감지");
		return "A";
	}

	@RequestMapping(value = "/goB")
	public String goB() {
		System.out.println("goB주소 접속 감지");
		return "B";
	}
	
	@RequestMapping(value = "/goC")
	// 주소 뒤 ?cNum=값 형태로 들어오는 값을 로직 내 cNum으로 처리합니다.
	// 들어온 파라미터를 .jsp파일로 전달하기 위해서는
	// Model model을 파라미터에 추가로 선언해줍니다.
	public String goC(int cNum, Model model) {
		System.out.println("주소로 전달받은 값 : " + cNum);
		// 전달받은 cNum을 C.jsp에 출력하는 로직을 작성
		model.addAttribute("cNum", cNum);
		return "C";
	}

	// goD는 requestParam을 이용해 변수명과 받는 이름이 일치하지 않게 해보겠습니다.
	@RequestMapping(value = "/goD")
	// @RequestParam("대체이름")은 변수 왼쪽에 선언합니다.
	// 이렇게 되면 적힌 변수명 대신 대체 이름으로 치환해 받아옵니다.
	public String goD(@RequestParam("d") int dNum, Model model) {
		model.addAttribute("dNum", dNum);
		System.out.println("D변수명으로 받은값 dNum에 저장 : " + dNum);
		return "D";
	}

	@RequestMapping(value = "/ctof", method = RequestMethod.POST)
	public String cToF(@RequestParam("cel") int cel, Model model) {
		System.out.println("ctof 파라미터 POST로 넘어옴");

		double faren = cel * 1.8 + 32;

		model.addAttribute("faren", faren);
		model.addAttribute("cel", cel);

		return "ctof";
	}

	// CtoF폼을 이용해 섭씨온도를 입력하고 제출 버튼을 누르면 결과값이 나오는 로직을 작성
	@RequestMapping(value = "/ctof", method = RequestMethod.GET)
	public String cToFForm() {
		System.out.println("ctof form 감지");

		return "ctofform";
	}

	// 위와 같은 방식으로 bmi측정 페이지를 만들어보자
	// 폼과 결제페이지로 구성시키고
	// bmi 공식은 체중 / (키(m)^2)로 나오는 결과

	@RequestMapping(value = "/bmi", method = RequestMethod.GET)
	public String bMiForm() {
		System.out.println("bmi페이지 호출");

		return "bmiform";
	}

	@RequestMapping(value = "/bmi", method = RequestMethod.POST)
	public String bMi(@RequestParam("zl") int height, @RequestParam("ahaanrp") int weight, Model model) {
		System.out.println("bmi 폼 값 전송받음");
		double m = (height * 0.01);
		double bmi = weight / (m * m);
		model.addAttribute("bmi", bmi);
		return "bmi";
	}

	//PathVariable을 이요하면 url패턴만으로도 특정 파라미터를 받을 수 있따
	// rest방식으로 url을 처리할때 주로 사용하며
	// "/pathtest/숫자" 중 숫자 위치에 온것은 {page}라는 변수값으로 간주
	
	@RequestMapping(value = "/pathtest/{page}")
	//int page 왼쪽에 @PathVariable을 붙여 처리해야 연동 가능
	public String pathTest(@PathVariable int page, Model model){
		model.addAttribute("page", page);

		//받아온 page변수를 path.jsp에 보내기
		//path.jsp에는 {path} 페이지 조회중입니다 라는 문장이 뜨게 하기

		return "path";
	}

	//ctof 로직을 PathVariable 적용시켜 만들어보기
	// ctofpv.jsp에 결과 나오게 하기
	@RequestMapping(value = "/ctofpv/{cel}")
	public String ctofpv(@PathVariable int cel, Model model){

		double faren = cel * 1.8 + 32;

		model.addAttribute("faren", faren);
		model.addAttribute("cel", cel);
		return "ctofpv";
	}
	
	//void타입 컨트롤러의 특징
	//void타입은 return구문 뒤에 자료를 기입할 수 없는 만큼
	//view파일의 이름은 그냥 메서드이름.jsp로 자동지정해버립니다.
	//간단한 작성은 void타입으로 해도 되지만 메서드명에 제약이 생겨 잘 안씀.
	
	@RequestMapping(value="/voidreturn")
	public void voidreturn(int num, Model model){
		System.out.println("void컨트롤러는 리턴이 필요없다");

		model.addAttribute("num", num);
		//파라미터 임의 설정
		//현 메서드의 맞는 view파일 생성
		//1에서 얻어온 파라미터를 2에서 출력
	}
	
	
}
