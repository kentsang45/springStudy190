package com.kent.board;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kent.AbstractTests;
import com.kent.board.config.BoardConfig;
import com.kent.board.mapper.ReplyMapper;

@ContextConfiguration(classes = {BoardConfig.class})
public class ReplyMapperTests extends AbstractTests{

	@Autowired
	ReplyMapper mapper;
	
	@Test
	public void testGetOne() {
		show(mapper);
		show(mapper.selectOne(10));
	}
	
}

