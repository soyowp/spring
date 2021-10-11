package org.ict.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ict.domain.MemberVO;

@Mapper
public interface MemberMapper {

	public MemberVO read(String userid);
}
