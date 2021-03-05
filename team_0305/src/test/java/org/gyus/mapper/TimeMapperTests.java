package org.gyus.mapper;

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
	 TimeMapper time;
	 
	 
	 @Test
	 public void testMapper() {
		 log.info("되라되라되라" + time);
		 log.info("what time is ----->" + time.getTime()); //time안에있는 bean객체를 가져와야되니깐
	 }
}
