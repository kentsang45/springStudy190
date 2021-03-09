package org.kent.time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.common.config.CommonConfig;
import org.kent.main.common.ConfigLoadTests;
import org.kent.time.config.TimeConfig;
import org.kent.time.mapper.TimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// 상속해서 쓰면 더 좋다.
@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommonConfig.class, TimeConfig.class})
public class TimeMapperTests {
	
	@Autowired
	TimeMapper mapper;
	
	@Test
	public void testTimeMapper() {
		log.info("=========== TimeMapper : "+mapper+"===================");
		log.info("=========== TimeMapper : "+mapper.getNow2()+"===================");
	}
	
	
	
	
	
}
