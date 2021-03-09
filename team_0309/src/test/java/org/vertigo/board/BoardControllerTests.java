package org.vertigo.board;

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
	            mvc.perform(
	                    MockMvcRequestBuilders.get("/board/list")
	            );
	            log.info("testTodo................................done");
	        }catch(Exception e){
	            log.info(e.getMessage());
	        }
	}
	
}
