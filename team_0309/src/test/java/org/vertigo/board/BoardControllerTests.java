package org.vertigo.board;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.vertigo.AbstractControllerTests;
import org.vertigo.board.config.BoardConfig;

import lombok.extern.log4j.Log4j;

@ContextConfiguration(classes = { BoardConfig.class })
@Log4j
public class BoardControllerTests extends AbstractControllerTests {

	@Test
	public void testController() {
		 try {
	            log.info(mvc);
	            
	            
	            log.info("Board Controller getList................................started");
	            mvc.perform(
	                    MockMvcRequestBuilders.get("/board/list")
	                    .param("page", "0")
	                    .param("perSheet", "20")
	            ).andDo(print());
	            log.info("Board Controller getList................................done");
	            
	            
	            log.info("Board Controller getRegister................................started");
	            mvc.perform(
	                    MockMvcRequestBuilders.get("/board/register")
	            ).andDo(print());
	            log.info("Board Controller getRegister................................done");
	            
	            
	            log.info("Board Controller getRead................................started");
	            mvc.perform(
	                    MockMvcRequestBuilders.get("/board/read")
	                    .param("bno", "10")
	            ).andDo(print());
	            log.info("Board Controller getRead................................done");
	        } catch(Exception e){
	            log.info(e.getMessage());
	        }
	}
	
}
