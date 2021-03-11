package com.kent.board;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.kent.AbstractControllerTests;
import com.kent.board.config.BoardConfig;

import lombok.extern.log4j.Log4j;

@ContextConfiguration(classes= {BoardConfig.class})
@Log4j
public class BoardControllerTests extends AbstractControllerTests{
	@Test
	public void testController() {
		 try {
	            log.info(mvc);        
	            log.info("...................Board Controller getList started................................");
	            mvc.perform(
	                    MockMvcRequestBuilders.get("/board/list")
	                    .param("page", "0")
	                    .param("perSheet", "20")
	            ).andDo(print());
		 } catch(Exception e) {
			 log.info(e.getMessage());
		 }
	}
}
