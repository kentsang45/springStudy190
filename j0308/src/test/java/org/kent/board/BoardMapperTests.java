package org.kent.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kent.board.config.BoardConfig;
import org.kent.board.mapper.BoardMapper;
import org.kent.common.config.CommonConfig;
import org.kent.time.config.TimeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommonConfig.class, TimeConfig.class, BoardConfig.class})
public class BoardMapperTests {
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testBoardMapper() {
		log.info("==================== testBoardMapper : " + mapper + "==================");
		mapper.getList().forEach(b->log.info(b));
	}
	
	
}
