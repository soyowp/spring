package org.ict.service;

import static org.junit.Assert.assertNotNull;

import org.ict.domain.BoardVO;
import org.ict.domain.Criteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import lombok.extern.log4j.Log4j;

//Service테스트는 BoardServiceImpl내부기능을 서버없이 테스트 가능
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	
	//다형성 원리에 의해 BoardService로 만들어도 BoardServiceImpl이 주입됨
	@Autowired
	private BoardService service;
	
	//서비스 주입이 성공했는지 확인
	@Test
	public void testExist() {
		log.info(service);
		//assertNotNull은 해당 객체가 주입이 되지 않아
		//null인 경우 에러를 발생시킵니다.
		assertNotNull(service);
	}
	
	//@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("생성된 제목");
		vo.setContent("생성된 내용");
		vo.setWriter("글쓴이");
		service.regeister(vo);
	}
	
	//@Test
	public void TestGetList() {
		log.info(service.getList(null));
	}
	
	//@Test
	public void TestSelect() {
		log.info(service.get(3L));
	}
	
	//@Test
	public void TestModify() {
		BoardVO vo = new BoardVO();
		vo.setBno(1L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 내용");
		vo.setWriter("수정된 글쓴이");
		service.modify(vo);		
	}
	
	//@Test
	public void TestRemove() {
		service.remove(10L);
	}
	
	@Test
	public void testGetListPaging() {
		Criteria cri = new Criteria(200, 10);
		service.getListPaging(cri);
	}
}
