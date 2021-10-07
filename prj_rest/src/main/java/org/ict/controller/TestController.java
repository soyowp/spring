package org.ict.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ict.domain.TestVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello Hello";
	}
	
	@RequestMapping("/sendVO")
	public TestVO sendTestVO() {
		TestVO vo = new TestVO();
		vo.setName("KO");
		vo.setAge(10);
		vo.setMno(1);
		return vo;
	}
	
	@RequestMapping("/sendVOList")
	public List<TestVO> testsendList(){
	List<TestVO> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			TestVO vo = new TestVO();
			vo.setName(i+"KO");
			vo.setAge(1+i);
			vo.setMno(i);
			list.add(vo);
		}
		return list;
	}
	@RequestMapping("/sendMap")
	public Map<Integer, TestVO>sendMap(){
		Map<Integer, TestVO> map = new HashMap<>();
		for(int i=0; i<10; i++) {
			TestVO vo = new TestVO();
			vo.setName(i+"KO");
			vo.setAge(1+i);
			vo.setMno(i);
			map.put(i,vo);
			
		}
		return map;	
	}
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		//ResponseEntity는 생성자에 HttpStatus.코드번호로 어떤 접속코드를 넘겨줄지 정할수 있다.
		return
				new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<TestVO>> sendListNot(){
		
		List<TestVO> list = new ArrayList<>();
		for(int i=0; i<10 ; i ++) {
			TestVO vo = new TestVO();
			vo.setMno(i);
			vo.setName(i+"KO");
			vo.setAge(20+i);
			list.add(vo);
		}
		//ResponseEntity의 생성자에 파라미터 2개를 넘기면
		// 전송할 데이터와 전송시 결과로 나올 코드를 함께 넘길 수 있다.
		return
				new ResponseEntity<List<TestVO>>(
						list, HttpStatus.NOT_FOUND);
				
		}
	}
