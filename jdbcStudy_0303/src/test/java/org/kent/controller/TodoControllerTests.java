package org.kent.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import lombok.extern.log4j.Log4j;

@Log4j
public class TodoControllerTests extends AbstractControllerTests{
	
	@Test
	public void testTodo() throws Exception {
		log.info(mvc);
		
		mvc.perform(
				MockMvcRequestBuilders.post("/todo/add")
				.param("title", "SampleTitle")
				.param("completed", "true")
				);

		log.info("testTodo................................done");
	}
}
