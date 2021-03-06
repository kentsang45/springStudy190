package org.kent.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.service.Restaurant;
import org.kent.service.TimeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class InjectionTests {
	// field injection으로 해보기
	@Autowired
	private Restaurant res;
	
	// spring에 등록한 객체를
	// 생성해서 연결한다.
	@Autowired
	private TimeDAO timeDAO;
	

	
	@Test
	public void testExist() {
		log.info(res);
		
	}
	
	@Test
	public void testTime() {
		try {
		log.info(timeDAO.getTime());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
