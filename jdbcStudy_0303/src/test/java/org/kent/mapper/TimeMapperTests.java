package org.kent.mapper;

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
	TimeMapper timeMapper;
	
	// mybatis xml 설정
	@Test
	public void testGetTime2() {
		// xml파일 이름과 클래스 이름이 같아야한다.
		log.info(timeMapper.getTime2());
	}
	
	// mybatis annotation 설정
	@Test
	public void testTime() {
		log.info(timeMapper);
		log.info(timeMapper.getTime());
	}
}
