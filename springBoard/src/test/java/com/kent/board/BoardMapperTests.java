package com.kent.board;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kent.AbstractTests;
import com.kent.board.config.BoardConfig;
import com.kent.board.domain.Board;
import com.kent.board.mapper.BoardMapper;
import com.kent.common.dto.PageDTO;

import lombok.extern.log4j.Log4j;

@ContextConfiguration(classes = {BoardConfig.class})
public class BoardMapperTests extends AbstractTests {

	@Autowired
	BoardMapper mapper;
	
	@Test
	public void testTotalCount() {
		PageDTO page = PageDTO.builder().page(0).perSheet(15).type("t").keyword("10").build();
		show("TotalCount : " + mapper.getTotalCount(page));
	}
	
	@Test
	public void testGetOne() {
		Board board = mapper.getOne(10);
		Date date = board.getUpdatedate();
		show("Board : " + mapper.getOne(10));
		show("Date : " + date);
	}
	
	@Test
	public void testRegister() {
		Board board = Board.builder().title("TEST_TITLE").content("TEST_CONTENT").writer("TEST_WRITER").build();
		mapper.register(board);
		show("Board Register Done...");
		show("lastIndex : " +  board.getBno());
	}
	
	// 131058
	@Test
	public void testModify() {
		Board board = Board.builder().bno(131058).title("MOD_TITLE").content("MOD_CONTENT").writer("MOD_WRITER").build();
		mapper.modify(board);
		show("Board : " + mapper.getOne(131058));
		show("Board Modify Done...");		
	}
	
	@Test
	public void testDelete() {
		mapper.delete(131058);
		show("Board : " + mapper.getOne(131058));
		show("Board Delete Done...");		
	}
	
	@Test
	public void testPageList() {
		PageDTO page = PageDTO.builder().page(0).perSheet(15).type("t").keyword("100").build();
		List<Board> list = mapper.getPageList(page);
		list.forEach(b->show(b));
		show("Board PageList Done...");
	}
	
	
	
	
	
	@Test
	public void testSqlTime() {
		Date sqlNow = mapper.getOne(131077).getUpdatedate();
		java.util.Date utilDate = new java.util.Date(sqlNow.getTime() - 9 * 1000 * 60 * 60);
		
		show(utilDate);
	}
}
