package org.ict.service;

import java.util.List;

import org.ict.domain.ReplyVO;
import org.ict.mapper.BoardMapper;
import org.ict.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper mapper;
	
	@Autowired
	private BoardMapper boardMapper;

	@Transactional
	@Override
	public void addReply(ReplyVO vo) {
		mapper.create(vo);
		log.info(vo);
		Long bno = mapper.getBno(vo.getRno());
		boardMapper.updateReplyCount(bno, 1L);
		
	}

	@Override
	public List<ReplyVO> replyList(Long bno) {
		return mapper.getList(bno);
		
	}

	@Override
	public void modifyReply(ReplyVO vo) {
		mapper.update(vo);
		
	}

	@Transactional
	@Override
	public void removeReply(Long rno) {
		log.info("삭제 로직 돌입");
		log.info("대체 bno가뭔데 안돼" + mapper.getBno(rno));
		Long bno = mapper.getBno(rno);
		boardMapper.updateReplyCount(bno, -1L);
		mapper.delete(rno);
		
	}
	
		
	}


