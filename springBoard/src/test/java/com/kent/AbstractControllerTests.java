package com.kent;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.kent.board.config.BoardConfig;
import com.kent.common.config.RootConfig;
import com.kent.common.config.ServletConfig;
import com.kent.common.config.WebConfig;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {
		RootConfig.class, 
		ServletConfig.class, 
		WebConfig.class
})
@WebAppConfiguration
@Log4j
public class AbstractControllerTests {
	
	@Autowired
	protected WebApplicationContext context;
	
	protected MockMvc mvc;
	
	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void basicTest() {
        log.info("context : " + context);
        log.info("mvc : " + mvc);
	}
	
	
	
	
	
}
