package org.ict.persistence;

import org.ict.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {

	@Autowired
	private TimeMapper timeMapper;
	
	@Test
	public void testGetTime() {
		log.info("현재 시간 조회중...");
		log.info(timeMapper.getTime());
	}
	
	@Test
	public void testGetTime2(){
		log.info("현재 시간 조회중...2");
		log.info(timeMapper.getTime2());
	}
	
	@Test
	public void testGetTime3() {
		log.info("현재시간 조회 자 드가자!");
		log.info(timeMapper.getTime3());
	}
}
