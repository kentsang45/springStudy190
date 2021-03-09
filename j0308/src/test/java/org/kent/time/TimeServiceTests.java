package org.kent.time;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.common.config.CommonConfig;
import org.kent.time.config.TimeConfig;
import org.kent.time.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommonConfig.class, TimeConfig.class})
public class TimeServiceTests {

	@Autowired
	TimeService timeService;
	
	@Test
	public void testTimeService() {
		log.info("============== Time Service : "+timeService+" =================");
		log.info("============== Time Service : "+timeService.getTime()+" =================");
	}
}
