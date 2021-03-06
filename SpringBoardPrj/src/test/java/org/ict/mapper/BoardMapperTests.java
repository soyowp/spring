package org.ict.mapper;

import java.rmi.StubNotFoundException;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.ict.domain.BoardVO;
import org.ict.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.log4j.Log4j;

//테스트코드 기본 세팅
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	// 이 코드 내에서는 Mapper테스트를 담당합니다.
	// 따라서 BoardMapper내부의 메서드를 실행해야하고
	// BoardMapper타입의 변수가 필요하니
	// 선언하고 자동주입으로넣어주세요

	@Autowired
	private BoardMapper mapper;

	// 테스트용 메서드의 이름은 testGetList입니다.
	// 테스트코드가 실행될 수 있도록 만들어주세요.

	//@Test
	public void testGetList() {
		// 키워드(문자열)를 넣도록 getList를 바꿔놔서 아래와같이 "" 를 넣어줘야 합니다.
		// 방금처럼 null이 들어가있으면 문자열이 아니라 에러를 유발할 수 있습니다.
		log.info(mapper.getList(""));
	}

	// insert코드를 작성합니다.
	//@Test
	public void testInsert() {
		// 글 입력을 위해 BoardVO타입을 매개로 사용
		// 따라서 BoardVO를 만들어놓고
		// setter로 글제목, 글본문, 글쓴이 만 저장해둔 채로
		// mapper.insert(vo);를 호출해서 실행여부를 확인
		BoardVO vo = new BoardVO();
		vo.setTitle("테스트용 제목");
		vo.setContent("테스트용 내용");
		vo.setWriter("관리자");
		mapper.insert(vo);
	}

	// @Test
	public void testSelect() {
		mapper.select(3L);
	}

	// @Test
	public void testDelete() {
		mapper.delete(2L);
	}
	
	// @Test
	public void testUpdate() {
		BoardVO vo = new BoardVO();
		vo.setTitle("수정된 내용");
		vo.setContent("수정된 내용");
		vo.setWriter("수정된 작성자");
		vo.setBno(3L);
		mapper.update(vo);
	}
	
	// @Test
	public void testgetPaging() {
		//페이징코드를 이용해 원하는 번호의 페이지가 출력되는지 확인하기
		Criteria cri = new Criteria(3, 10);
		mapper.getListPaging(cri);
		
	}
	
	@Test
	public void testTotlapage() {
		mapper.totalPage();
	}
}
