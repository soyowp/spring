package org.ict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.logging.Log;
import org.ict.domain.BoardVO;

@Mapper
public interface BoardMapper {

	// board_tbl에서 글번호 3번 이하만 조회하는 쿼리문을
	// 어노테이션을 이요해 작성해주세요

	// @Select("SELECT * FROM board_tbl where bno<=3")
	public List<BoardVO> getList();

	// insert구문 실행용으로 메서드를 선언합니다.
	// VO내부에 적혀있는 정보를 이용해 insert합니다.
	public void insert(BoardVO vo);

	// 글번호(Long bno)를 파라미터로 받아
	// 해당 글 번호에 해당하는 글을 리턴해 보여주는 메서드를 작성
	// 메서드 이름은 select로, xml도 작성하기
	public BoardVO select(Long bno);
	
	
	// 글 번호를 파라미터로 받아
	// 해당 글 번호에 해당하는 글을 삭제해주는 메서드를 작성
	public void delete(Long bno);
	
	//글 수정로직을 작성
	//BoardVO를 받아서 수정
	//바꿀 내역은 title, content, writer는 vo에서 받아서
	//where구문은 bno로 구분해서 처리
	
	public void update(BoardVO vo); 
}