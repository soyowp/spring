package org.ict.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.ict.domain.ReplyVO;

@Mapper
public interface ReplyMapper {

	public List<ReplyVO> getList(Long bno);

	public void create(ReplyVO vo);

	public void update(ReplyVO vo);

	public void delete(Long rno);

	public Long getBno(Long rno);
}
