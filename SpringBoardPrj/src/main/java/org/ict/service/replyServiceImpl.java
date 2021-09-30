package org.ict.service;

import java.util.List;

import org.ict.domain.ReplyVO;
import org.ict.mapper.replyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class replyServiceImpl implements replyService {

	@Autowired
	private replyMapper mapper;

	@Override
	public void addReply(ReplyVO vo) {
		mapper.create(vo);
		log.info(vo);
		
	}

	@Override
	public List<ReplyVO> replyList(Long bno) {
		return mapper.getList(bno);
		
	}

	@Override
	public void modifyReply(ReplyVO vo) {
		mapper.update(vo);
		
	}

	@Override
	public void removeReply(Long rno) {
		mapper.delete(rno);
		
	}
	

}
