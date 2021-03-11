package com.kent;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kent.common.config.RootConfig;

import jdk.internal.org.jline.utils.Log;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class})
@Log4j
public class AbstractTests {
	
	protected void show(Object obj) {
		log.info(obj);
	}
	
	protected void show(String obj) {
		log.info(obj);
	}
}
