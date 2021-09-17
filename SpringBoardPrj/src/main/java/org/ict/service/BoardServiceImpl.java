package org.ict.service;

import java.util.List;

import org.ict.domain.BoardVO;
import org.ict.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

//BoardServiceImple은 BoardService 인터페이스를 구현합니다.
@Log4j // 로깅 어노테이션 에러가 뜨면 pom.xml수정
// 자세한 사항은 pom.xml의 log4j 참조
@Service // 의존성 등록을 위한 어노테이션
@AllArgsConstructor // 서비스 생성자 자동생성
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	//등록작업시 BoardVO를 매개로 실행하기 때문에
	//아래와 같이 BoardVO를 파라미터에 설정해둠.
	//BoardServiceTests에 VO를 생성해 테스트하기
	
	@Override
	public void regeister(BoardVO vo) {
		log.info("등록작업 실행");
		// mapper.insert(vo); 에서 bno를 얻기위해 변경
		mapper.insertSelectKey(vo);
	}

	//전체 글을 다 가져오지 않고 글 하나만 가져오는 로직을 완성시키고
	//테스트코드 작성하기
	
	@Override
	public BoardVO get(Long bno) {
		log.info("글 선택작업");
		BoardVO vo = mapper.select(bno);	
		return vo;
	}

	
	//삭제와 수정은 한번에 진행
	@Override
	public void modify(BoardVO vo) {
		log.info(vo.getBno()+"번 글 수정");
		mapper.update(vo);		
	}

	@Override
	public void remove(Long bno) {
		log.info(bno+"번 글 삭제");
		mapper.delete(bno);
		
	}

	
	//글 전체 목록을 가져오는 로직을 작성
	//해당 로직은 mapper내부의 getList의 쿼리문을 먼저
	//전체 글을 가져오는 로직으로 수정 후 service에 등록해서 구현
	@Override
	public List<BoardVO> getList(String keyword) {
		log.info("리스트가져오기");
		List<BoardVO> boardList = mapper.getList(keyword);
		
		return boardList;
	}

}
