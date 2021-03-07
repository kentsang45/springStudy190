package org.kent.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.dao.DataSourceTests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TodoMapperTests {
	@Autowired
	TodoMapper mapper;
	
	@Test
	public void testSelectOne() {		
		log.info("===================testSelectOne : "+mapper+"=================");
		log.info(mapper.selectOne(10));
		log.info("===================testSelectOne Done=================");
	}
	
	
}
