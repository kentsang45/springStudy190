package com.kent.board;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.kent.AbstractTests;
import com.kent.board.config.BoardConfig;
import com.kent.board.service.ReplyService;

@ContextConfiguration(classes= BoardConfig.class)
public class ReplyServiceTests extends AbstractTests{
	@Autowired
	ReplyService service;
	
	@Test
	public void testList() {
		show("========== test list =============");
		service.selectList(131092, 0).forEach(r->show(r));;
	}
}
