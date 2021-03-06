package org.ict.service;

import java.util.List;

import org.ict.domain.BoardVO;
import org.ict.domain.Criteria;
import org.ict.domain.SearchCriteria;

//서비스 계층은, 하나의 동작을 담당
//mapper계층에서 하나의 메서드가 하나의 쿼리문을 담당했는데
//service계층은, 하나의 메서드가 2개 이상의 쿼리문 담당이 가능하며
//메서드 하나가 사용자의 하나의 동작 단위를 담당합니다.
public interface BoardService {

	//사용자 동작단위 기술
	//글 등록
	public void regeister(BoardVO vo);
	
	//글 조회
	public BoardVO get(Long bno);
	
	//글 수정
	public void modify(BoardVO vo);
	
	//글 삭제
	public void remove(Long bno);
	
	// 글 전체 목록
	public List<BoardVO> getList(String keyword);
	
	// 글 목록 페이징
	public List<BoardVO> getListPaging(SearchCriteria cri);
	
	// 글 전체 갯수
	public int totalPage(SearchCriteria cri);
}
